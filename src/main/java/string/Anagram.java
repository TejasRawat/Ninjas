package string;

import java.util.HashMap;
import java.util.Map;


/**
 * An anagram of a string is another string that contains same characters, only the order of characters can be different.
 * For example, “abcd” and “dabc” are anagram of each othe
 */
public class Anagram {
    public static void main(String args[]) {

        isAnagram("", "");

    }

    public static boolean isAnagram(String string1, String string2) {
        Map<Character, Integer> charCountTable1 = getCharCountTable(string1);
        Map<Character, Integer> charCountTable2 = getCharCountTable(string1);
        return ifTableIdentical(charCountTable1, charCountTable2);
    }

    private static Map<Character, Integer> getCharCountTable(String string) {
        Map<Character, Integer> charCountTable = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (charCountTable.containsKey(character)) {
                final Integer count = charCountTable.get(character);
                charCountTable.put(character, count + 1);
            } else {
                charCountTable.put(character, 1);
            }
        }
        return charCountTable;
    }

    private static boolean ifTableIdentical(Map<Character, Integer> charCountTable1, Map<Character, Integer> charCountTable2) {

        return false;
    }
}
