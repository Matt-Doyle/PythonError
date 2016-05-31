package pythonError.errorInterpreter.inputPhaser;

/**
 * Created by Christopher on 31/05/2016.
 */
public class LinedError extends Error {

	private int line;

	public LinedError(Error error, int line) {
		super(error.getBmPattern(), error.getExplanation(), error.getSimpleExplanation(), error.getSolution());
		this.line = line;
	}

	public int getLine() {
		return line;
	}
}
