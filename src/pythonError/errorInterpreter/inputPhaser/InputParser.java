package pythonError.errorInterpreter.inputPhaser;

import pythonError.errorInterpreter.errorSearch.BMPattern;
import pythonError.errorInterpreter.errorSearch.BoyerMoore;
import pythonError.errorInterpreter.pythonInterpreter.Python;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Christopher on 30/05/2016.
 */
public class InputParser {

	public static ArrayList<Line> parseCode(String input) {
		ArrayList<Line> lines = new ArrayList<>();
		String[] linesAsStrings = input.split("\n");
		for (String line : linesAsStrings) {
			int indentation = 0;
			while (input.startsWith("    ")) {
				input = input.substring(4);
				indentation++;
			}
			while (input.startsWith("  ")) {
				input = input.substring(2);
				indentation++;
			}
			while (input.startsWith("\t")) {
				input = input.substring(1);
				indentation++;
			}
			lines.add(new Line(input, indentation));
		}
		return lines;
	}

	public static Error parseError(String traceback, Python pSearch) {
		BMPattern error = pSearch.getExceptionList().get(0);
		for (BMPattern bmPattern : pSearch.getExceptionList()) {
			ArrayList<Integer> CharacterPositions = BoyerMoore.precomputeSearch(bmPattern.getPattern(), traceback, bmPattern.getBCRTable(), bmPattern.getGSRTable());
			if (CharacterPositions.size() > 0) {
				error = bmPattern;
				break;
			}
		}
		ArrayList<String> tracebackWords = new ArrayList<>(Arrays.asList(traceback.split(" ")));
		int lineNumber = Integer.parseInt(tracebackWords.get(tracebackWords.lastIndexOf("line") + 1).replace(",", ""));
		return new Error(error, lineNumber);
	}
}
