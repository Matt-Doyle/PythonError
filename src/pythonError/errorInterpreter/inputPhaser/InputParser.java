package pythonError.errorInterpreter.inputPhaser;

import pythonError.errorInterpreter.errorSearch.BoyerMoore;
import pythonError.errorInterpreter.pythonInterpreter.Python;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Christopher on 30/05/2016.
 */
public class InputParser {

    public static ArrayList<Line> parseCode(String input) {
        ArrayList<Line> lines = new ArrayList<>();
        Arrays.stream(input.split("\n")).forEach(i -> lines.add(new Line(input))); // don't judge me, I just wanted this to look cool -Matt
        return lines;
    }

	public static LinedError parseError(String traceback, Python pSearch) {
		Error error = pSearch.getError("BaseException");
		for (Error thisError : pSearch.getExplanations().values()) {
			ArrayList<Integer> CharacterPositions = BoyerMoore.precomputeSearch(thisError.getBmPattern().getPattern(), traceback, thisError.getBmPattern().getBCRTable(), thisError.getBmPattern().getGSRTable());
			if (CharacterPositions.size() > 0) {
				error = pSearch.getError(thisError.getBmPattern().getPattern());
				break;
			}
		}
		ArrayList<String> tracebackWords = new ArrayList<>(Arrays.asList(traceback.split(" ")));
		int lineNumber = Integer.parseInt(tracebackWords.get(tracebackWords.lastIndexOf("line") + 1).replace(",", ""));
		return new LinedError(error, lineNumber);
	}
}


class CodeParser {
    static String[] KEYWORDS = {"False", "class", "finally", "is", "return", "None", "continue", "for", "lambda", "try", "True", "def", "from", "nonlocal",
    "while", "and", "del", "global", "not", "with", "as", "elif", "if", "or", "yield", "assert", "else", "import", "pass", "break", "except", "is", "raise"};
    static String[] OPERATORS = {"+", "-", "*", "/", "//", "%", "**", "==", "!=", "<", ">", "<=", ">=", "is", "in", "and", "or", "not", "&", "|", "~", "^", "<<",
            ">>"};
    static String[] DELIMITERS = {};

    private int isKeyword(String input, int i) {
        String currentChar = input.substring(i, i);
        if (currentChar.matches("[A-Za-z_]")) {
            for (String keyWord : KEYWORDS) {
                if (i + (keyWord.length() - 1) > input.length()) {
                    continue;
                }
                for (int j = 0; j < keyWord.length(); j++) {
                    if (input.charAt(i + j) != keyWord.charAt(j)) {
                        continue;
                    }
                }
                if (i + keyWord.length() > input.length()) {
                    return i + keyWord.length() - 1;
                } else if (input.charAt(i + keyWord.length()) == ' ' || input.charAt(i + keyWord.length()) == '\n') {
                    return i + keyWord.length() - 1;
                }
            }
        }
        return 0;
    }

    public ArrayList<Token> constructTokens(String input) {
        input.replace("\\\n", " ");


        ArrayList<Token> tokenList = new ArrayList<>();
        int previousIndent = 0;
        int currentIndent = 0;

        boolean isNewLine = true;

        for (int i = 0; i < input.length(); i++) {
            if (isNewLine) {
                int keywordOffset = isKeyword(input, i);
                if (keywordOffset > 0) {

                }
            }
        }

        return new ArrayList<>();
    }
}