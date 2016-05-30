package pythonError.errorInterpreter.errorSearch;

import java.util.HashMap;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */
public class BMPattern {
	private String pattern;
	private int[] badCharacterTable;
	private int[] goodSuffixTable;

	public BMPattern(String pattern, int[] badCharacterTable, int[] goodSuffixTable) {
		this.pattern = pattern;
		this.badCharacterTable = badCharacterTable;
		this.goodSuffixTable = goodSuffixTable;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String newPattern) {
		pattern = newPattern;
	}

	public int[] getBCRTable() {
		return badCharacterTable;
	}

	public void setBCRTable(int[] BCR) {
		badCharacterTable = BCR;
	}

	public int[] getGSRTable() {
		return goodSuffixTable;
	}

	public void setGSRTable(int[] GSR) {
		goodSuffixTable = GSR;
	}
}