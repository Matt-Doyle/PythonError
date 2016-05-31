package pythonError.errorInterpreter.inputPhaser;

import pythonError.errorInterpreter.errorSearch.BMPattern;

/**
 * Created by Christopher on 5/30/2016.
 */
public class Error {

	private BMPattern bmPattern;
	private String explanation;
	private String simpleExplanation;
	private String solution;

	public Error(BMPattern bmPattern, String explanation) {
		this.bmPattern = bmPattern;
		this.explanation = explanation;
		this.simpleExplanation = "";
		this.solution = "";
	}

	public Error(BMPattern bmPattern, String explanation, String simpleExplanation, String solution) {
		this.bmPattern = bmPattern;
		this.explanation = explanation;
		this.simpleExplanation = simpleExplanation;
		this.solution = solution;
	}

	public BMPattern getBmPattern() {
		return bmPattern;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getSimpleExplanation() {
		return simpleExplanation;
	}

	public String getSolution() {
		return solution;
	}
}
