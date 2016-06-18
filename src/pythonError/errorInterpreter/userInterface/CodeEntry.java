package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.StyleSpans;
import org.fxmisc.richtext.StyleSpansBuilder;
import pythonError.errorInterpreter.utils.FileLoader;

import java.util.Collection;
import java.util.Collections;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeEntry {

	private VirtualizedScrollPane nodeObject;
	private CodeArea richTextEntry;

	private static final String[] KEYWORDS = FileLoader.loadToString("/python/pythonKeywords.txt").split("\n");
	private static final String[] BUILT_IN_FUNCTIONS = FileLoader.loadToString("/python/pythonBuiltInFunctions.txt").split("\n");

	private static final String KEYWORD_PATTERN = "\\b(" + String.join("|", KEYWORDS) + ")\\b";
	private static final String BUILT_IN_FUNCTION_PATTERN = "\\b(" + String.join("|", BUILT_IN_FUNCTIONS) + ")\\b";
	private static final String STRING_PATTERN_DOUBLE = "\"([^\"\\\\]|\\\\.)*\"";
	private static final String STRING_PATTERN_SINGLE = "'([^'\\\\]|\\\\.)*'";
	private static final String COMMENT_PATTERN = "#.*(\\n|\\z)";

	private static Pattern pattern;

	public CodeEntry() {
		richTextEntry = new CodeArea();
		richTextEntry.setWrapText(false);
		richTextEntry.setParagraphGraphicFactory(LineNumberFactory.get(richTextEntry));

		IntFunction<String> format = (digits -> " %" + digits + "d ");

		richTextEntry.setParagraphGraphicFactory(LineNumberFactory.get(richTextEntry, format));
		richTextEntry.textProperty().addListener((obs, oldText, newText) -> {
			richTextEntry.setStyleSpans(0, computeHighlighting(newText, -1));
		});

		nodeObject = new VirtualizedScrollPane(richTextEntry);
		nodeObject.setPrefSize(800, 350);
	}

	public StyleSpans<Collection<String>> computeHighlighting(String text, int errorLineNumber) {
		String errorPattern;
		if (errorLineNumber > -1 && errorLineNumber <= text.length() + 1 && !richTextEntry.getText(errorLineNumber).isEmpty())
			errorPattern = richTextEntry.getText(errorLineNumber);
		else
			errorPattern = "hopefullythistextwillneverreallybeintheinput";
		errorPattern = errorPattern.replaceAll("\\(", "\\\\\\(");
		errorPattern = errorPattern.replaceAll("\\)", "\\\\\\)");
		errorPattern = errorPattern.replaceAll("\\{", "\\\\\\{");
		errorPattern = errorPattern.replaceAll("\\}", "\\\\\\}");
		errorPattern = errorPattern.replaceAll("\\[", "\\\\\\[");
		errorPattern = errorPattern.replaceAll("\\]", "\\\\\\]");
		pattern = Pattern.compile("(?<ERROR>" + errorPattern + ")"
				+ "|(?<KEYWORD>" + KEYWORD_PATTERN + ")"
				+ "|(?<BUILTINFUNCTION>" + BUILT_IN_FUNCTION_PATTERN + ")"
				+ "|(?<STRING>" + STRING_PATTERN_DOUBLE + "|" + STRING_PATTERN_SINGLE + ")"
				+ "|(?<COMMENT>" + COMMENT_PATTERN + ")");
		Matcher matcher = pattern.matcher(text);
		int lastKwEnd = 0;
		StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
		while (matcher.find()) {
			String styleClass = matcher.group("ERROR") != null ? "error" : matcher
					.group("KEYWORD") != null ? "keyword" : matcher
					.group("BUILTINFUNCTION") != null ? "built-in-function" : matcher
					.group("COMMENT") != null ? "comment" : matcher
					.group("STRING") != null ? "string" : null; /* never happens */
			assert styleClass != null;
			spansBuilder.add(Collections.emptyList(), matcher.start() - lastKwEnd);
			spansBuilder.add(Collections.singleton(styleClass), matcher.end() - matcher.start());
			lastKwEnd = matcher.end();
		}
		spansBuilder.add(Collections.emptyList(), text.length() - lastKwEnd);
		return spansBuilder.create();
	}

	public void highlightErrorLine(int errorLine) {
		richTextEntry.setStyleSpans(0, computeHighlighting(richTextEntry.getText(), errorLine));
	}

	public VirtualizedScrollPane getNodeObject() {
		return nodeObject;
	}

	public void setText(String strText) {
		richTextEntry.clear();
		richTextEntry.appendText(strText);
	}

	public String getText() {
		return richTextEntry.getText();
	}
}
