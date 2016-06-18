package pythonError.errorInterpreter.userInterface;

/**
 * Created by Matthew Doyle on 28/05/2016.
 */

import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.InlineCssTextArea;
import pythonError.errorInterpreter.pythonInterpreter.Python;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TracebackResult {

	private VirtualizedScrollPane nodeObject;
	private InlineCssTextArea richTextEntry;

	private static final String[] EXCEPTIONS = Python.getExceptions().toArray(new String[Python.getExceptions().size()]);

	private static final String EXCEPTION_PATTERN = "\\b(" + String.join("|", EXCEPTIONS) + ")\\b";
	private static final String TITLE_PATTERN = "(Explanation:)|(Solution:)|(Oops!)";
	private static final String LINE_NUMBER_PATTERN = "line [0-9]+";
	private static final Pattern PATTERN = Pattern.compile("(?<EXCEPTION>" + EXCEPTION_PATTERN + ")"
			+ "|(?<LINENUMBER>" + LINE_NUMBER_PATTERN + ")"
			+ "|(?<TITLE>" + TITLE_PATTERN + ")");

	public TracebackResult() {
		richTextEntry = new InlineCssTextArea();
		richTextEntry.setWrapText(true);
		richTextEntry.setEditable(false);

		richTextEntry.textProperty().addListener((obs, oldText, newText) -> computeHighlighting(newText));

		nodeObject = new VirtualizedScrollPane(richTextEntry);
		nodeObject.setPrefSize(700, 200);
	}

	private void computeHighlighting(String text) {
		Matcher matcher = PATTERN.matcher(text);
		while (matcher.find()) {
			String styleClass = matcher.group("EXCEPTION") != null ? "red" : matcher
					.group("LINENUMBER") != null ? "bold" : matcher
					.group("TITLE") != null ? "bold" : null; /* never happens */
			assert styleClass != null;
			if (Objects.equals(styleClass, "red"))
				richTextEntry.setStyle(matcher.start(), matcher.end(), "-fx-fill: #DD0000;");
			else if (Objects.equals(styleClass, "bold"))
				richTextEntry.setStyle(matcher.start(), matcher.end(), "-fx-font-weight: bold;");
		}
	}

	public VirtualizedScrollPane getNodeObject() {
		return nodeObject;
	}

	public void setText(String strText) {
		richTextEntry.clear();
		richTextEntry.appendText(strText);
	}

	public void appendText(String strText) {
		richTextEntry.appendText(strText);
	}

	public String getText() {
		return richTextEntry.getText();
	}
}
