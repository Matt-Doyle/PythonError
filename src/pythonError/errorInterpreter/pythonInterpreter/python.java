package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import java.util.ArrayList;
import java.util.HashMap;

import pythonError.errorInterpreter.errorSearch.BMPattern;
import pythonError.errorInterpreter.errorSearch.BoyerMoore;

public class python {

    private ArrayList<BMPattern> Exceptions;
    private HashMap<String, String> Explanations;

    python() {
        Exceptions = new ArrayList<>();
        Explanations = new HashMap<>();
    }

    public void AddException(String Exception, String Explanation) { // Creates objects
        Exceptions.add(BoyerMoore.compile(Exception));
        Explanations.put(Exception, Explanation);
    }

    public ArrayList<BMPattern> getExceptionList() { // Returns list of exceptions
        return Exceptions;
    }

    public String getExplanation(String Exception) { // Returns the explanation for an exception
        assert Explanations.containsKey(Exception);
        return Explanations.get(Exception);
    }
}