package pythonError.errorInterpreter.inputPhaser;

/**
 * Created by Matthew Doyle on 31/05/2016.
 */


enum tokens {
    newLine,
    keyWord,
    stringLiteral,
    number,
    comment,
    indent,
    dedent
}

public class Token {
    tokens type;
    public Token(tokens type) {
        this.type = type;
    }
}
