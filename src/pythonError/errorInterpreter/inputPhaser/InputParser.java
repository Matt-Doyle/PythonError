package pythonError.errorInterpreter.inputPhaser;

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
