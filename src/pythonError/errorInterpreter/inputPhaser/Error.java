package pythonError.errorInterpreter.inputPhaser;

import pythonError.errorInterpreter.errorSearch.BMPattern;

/**
 * Created by Christopher on 30/05/2016.
 */
public class Error {

	private BMPattern bmPattern;
	private int line;

	public Error(BMPattern bmPattern, int line) {
		this.bmPattern = bmPattern;
		this.line = line;
	}

	public BMPattern getBmPattern() {
		return bmPattern;
	}

	public int getLine() {
		return line;
	}
}
