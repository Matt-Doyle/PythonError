package pythonError.errorInterpreter.pythonInterpreter;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

public class python {
    Pattern parentheses = Pattern.compile("\\(|\\)");
    Pattern braces = Pattern.compile("\\{|\\}");
    Pattern brackets = Pattern.compile("\\[|\\]");
}