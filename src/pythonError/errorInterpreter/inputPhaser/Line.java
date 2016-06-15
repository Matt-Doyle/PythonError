package pythonError.errorInterpreter.inputPhaser;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Christopher on 30/05/2016.
 */
public class Line {

	private String text;
	private int indentation;

	private static int getIndentationAmount(String input) {
		int indentation = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t') {
				break;
			} else {
				indentation++;
			}
		}
		return indentation;
	}

	public Line(String text) {
		this.text = text;
		this.indentation = getIndentationAmount(text);
	}

	public ArrayList<String> toStringArray() {
		return new ArrayList<>(Arrays.asList(text.split(" ")));
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIndentation() {
		return indentation;
	}

	public void setIndentation(int indentation) {
		this.indentation = indentation;
	}

	@Override
	public String toString() {
		return "Line{" +
				"indentation=" + indentation +
				", text='" + text + '\'' +
				'}';
	}
}
