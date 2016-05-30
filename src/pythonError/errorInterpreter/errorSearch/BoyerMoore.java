package pythonError.errorInterpreter.errorSearch;

import java.util.ArrayList;

/**
 * Created by Matthew Doyle on 29/05/2016.
 */
public class BoyerMoore {

    public static ArrayList<Integer> precomputeSearch(String Needle, String Haystack, int charTable[], int offsetTable[]) {
        char[] haystack = Haystack.toCharArray();
        char[] needle = Needle.toCharArray();
        ArrayList<Integer> result = new ArrayList<>();
        if (needle.length == 0) {
            return result;
        }
        for (int i = needle.length - 1, j; i < haystack.length;) {
            for (j = needle.length - 1; needle[j] == haystack[i]; --i, --j) {
                if (j == 0) {
                    result.add(i);
                    return result;
                }
            }
            // i += needle.length - j; // For naive method
            i += Math.max(offsetTable[needle.length - 1 - j], charTable[haystack[i]]);
        }
        return result;
    }

    public static ArrayList<Integer> search(String Needle, String Haystack) {
        int charTable[] = makeCharTable(Needle.toCharArray());
        int offsetTable[] = makeOffsetTable(Needle.toCharArray());
        return precomputeSearch(Needle, Haystack, charTable, offsetTable);
    }

    public static BMPattern compile(String Needle) {
        return new BMPattern(Needle, makeCharTable(Needle.toCharArray()), makeOffsetTable(Needle.toCharArray()));
    }
    /**
     * Makes the jump table based on the mismatched character information.
     */
    private static int[] makeCharTable(char[] needle) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];
        for (int i = 0; i < table.length; ++i) {
            table[i] = needle.length;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            table[needle[i]] = needle.length - 1 - i;
        }
        return table;
    }

    /**
     * Makes the jump table based on the scan offset which mismatch occurs.
     */
    private static int[] makeOffsetTable(char[] needle) {
        int[] table = new int[needle.length];
        int lastPrefixPosition = needle.length;
        for (int i = needle.length - 1; i >= 0; --i) {
            if (isPrefix(needle, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[needle.length - 1 - i] = lastPrefixPosition - i + needle.length - 1;
        }
        for (int i = 0; i < needle.length - 1; ++i) {
            int slen = suffixLength(needle, i);
            table[slen] = needle.length - 1 - i + slen;
        }
        return table;
    }

    /**
     * Is needle[p:end] a prefix of needle?
     */
    private static boolean isPrefix(char[] needle, int p) {
        for (int i = p, j = 0; i < needle.length; ++i, ++j) {
            if (needle[i] != needle[j]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the maximum length of the substring ends at p and is a suffix.
     */
    private static int suffixLength(char[] needle, int p) {
        int len = 0;
        for (int i = p, j = needle.length - 1;
             i >= 0 && needle[i] == needle[j]; --i, --j) {
            len += 1;
        }
        return len;
    }


    public static void main(String[] args) {
        BoyerMoore.search("NameError", "Traceback (most recent call last):\n" +
                "  File \"<stdin>\", line 1, in ?\n" +
                "NameError: name 'spam' is not defined").forEach(System.out::println);
    }
}