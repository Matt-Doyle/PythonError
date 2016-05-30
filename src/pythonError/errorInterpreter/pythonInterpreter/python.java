package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

import pythonError.errorInterpreter.errorSearch.BMPattern;
import pythonError.errorInterpreter.errorSearch.BoyerMoore;

public class Python {

	private ArrayList<BMPattern> exceptions;
	private HashMap<String, String> explanations;

	public Python() {
		exceptions = new ArrayList<>();
		explanations = new HashMap<>();
	}

	public void addException(String exception, String explanation) { // Creates objects
		exceptions.add(BoyerMoore.compile(exception));
		explanations.put(exception, explanation);
	}

	public ArrayList<BMPattern> getExceptionList() { // Returns list of exceptions
		return exceptions;
	}

	public String getExplanation(String Exception) { // Returns the explanation for an exception
		assert explanations.containsKey(Exception);
		return explanations.get(Exception);
	}
}
