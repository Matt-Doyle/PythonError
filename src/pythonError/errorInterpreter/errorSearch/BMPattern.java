package pythonError.errorInterpreter.errorSearch;

import java.util.HashMap;

/**
 * Created by Matthew Doyle on 30/05/2016.
 */
public class BMPattern {
    private String pattern;
    private HashMap<Character, Number> badCharacterTable;
    private int[] goodSuffixTable;

    BMPattern(String pattern, HashMap<Character, Number> badCharacterTable, int[] goodSuffixTable) {
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

    public HashMap<Character, Number> getBCRTable() {
        return badCharacterTable;
    }

    public void setBCRTable(HashMap<Character, Number> BCR) {
        badCharacterTable = BCR;
    }

    public int[] getGSRTable() {
        return goodSuffixTable;
    }

    public void setGSRTable(int[] GSR) {
        goodSuffixTable = GSR;
    }

}
