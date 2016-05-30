package pythonError.errorInterpreter.errorSearch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Matthew Doyle on 29/05/2016.
 */
public class BoyerMoore { // Implementation derived from http://www.cs.utexas.edu/~moore/publications/fstrpos.pdf

    private static HashMap<Character, Number> GenerateBCRLookupTable(String Needle) {
        HashMap<Character, Number> BCRMap = new HashMap<>();

        for (int i = 0; i < Needle.length(); i++) {
            char lookupCharacter = Needle.charAt(i);
            BCRMap.put(lookupCharacter, Math.max(1, Needle.length() - 1 - i));
        }
        return BCRMap;
    }

    private static int[] GenerateGSRLookupTable(String Needle) {
        int m = Needle.length();

        int[] suffixes = new int[m];

        suffixes[m - 1] = m;
        int f = 0;

        int g = m - 1;
        for(int i = m - 2; i >= 0; i--) {
            if (i > g && suffixes[i + m - 1 - f] < i - g) {
                suffixes[i] = suffixes[i + m - 1 - f];
            } else {
                if (i < g) {
                    g = i;
                }
                f = i;
                while(g >= 0 && Needle.substring(g, g).equals(Needle.substring(g + m - 1 - f, g + m - 1 - f))) {
                    g--;
                }
                suffixes[i] = f - g;
            }
        }

        int[] goodSuffixes = new int[Needle.length()];

        for (int goodSuffix : goodSuffixes) {
            goodSuffixes[goodSuffix] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            if (suffixes[i] == i + 1) {
                for (int j = 0; j < m - 1 - i; j++) {
                    if (goodSuffixes[j] == m) {
                        goodSuffixes[j] = m - 1 - i;
                    }
                }
            }
        }

        for (int i = 0; i < m - 2; i++) {
            goodSuffixes[m - 1 - suffixes[i]] = m - 1 - i;
        }
        return goodSuffixes;
    }

    public static ArrayList<Number> search(String needle, String haystack) {
        int[] GSR = GenerateGSRLookupTable(needle);
        HashMap<Character, Number> BCR = GenerateBCRLookupTable(needle);
        return precomputedSearch(needle, haystack, GSR, BCR);
    }

    private static ArrayList<Number> precomputedSearch(String needle, String haystack, int[] GSR, HashMap<Character, Number> BCR) {
        ArrayList<Number> result = new ArrayList<>();
        int m = needle.length();
        int offset = 0;
        int searchArea = haystack.length() - needle.length() - 1;
        while (offset < searchArea) {
            int i = m - 1;
            while (i >= 0 && needle.charAt(i) == haystack.charAt(offset + i))
                i--;
            if (i < 0) {
                result.add(offset);
                offset += needle.length();
            } else {
                offset += Math.max(GSR[i], BCR.containsKey(haystack.charAt(i)) ? BCR.get(haystack.charAt(i)).intValue() : m);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BoyerMoore.search("test", "testing testing testing").forEach(System.out::println);
    }
}
