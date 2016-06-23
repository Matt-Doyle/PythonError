package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import pythonError.errorInterpreter.errorSearch.BoyerMoore;
import pythonError.errorInterpreter.inputPhaser.Error;
import pythonError.errorInterpreter.utils.XMLLoader;

import java.util.HashMap;
import java.util.Set;

public class Python {

	private static HashMap<String, Error> explanations = (HashMap<String, Error>) XMLLoader.loadExceptions("/python/pythonExceptions.xml");

	private static void addException(String exception, String explanation) { // Creates objects
		explanations.put(exception, new Error(BoyerMoore.compile(exception), explanation));
	}

	private static void addException(String exception, String explanation, String simpleExplanation, String solution) { // Creates objects
		explanations.put(exception, new Error(BoyerMoore.compile(exception), explanation, simpleExplanation, solution));
	}

	public static HashMap<String, Error> getExplanations() {
		return explanations;
	}

	public static String getExplanation(String exception) { // Returns the explanation for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception).getExplanation();
	}

	public static String getSimpleExplanation(String exception) { // Returns the simple explanation for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception).getSimpleExplanation();
	}

	public static String getSolution(String exception) { // Returns the solution for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception).getSolution();
	}

	public static Error getError(String exception) { // Returns the solution for an exception
		assert explanations.containsKey(exception);
		return explanations.get(exception);
	}

	public static Set<String> getExceptions() {
		return explanations.keySet();
	}
}
