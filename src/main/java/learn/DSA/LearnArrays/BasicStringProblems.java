package learn.DSA.LearnArrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class BasicStringProblems {

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static boolean checkPallindrom(String str) {
        StringBuilder sb = new StringBuilder(str);
        if (sb.reverse().toString().equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    public static void countOccurance(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void removeDuplicate(String str) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            if (!res.toString().contains(String.valueOf(str.charAt(i)))) {
                res.append(str.charAt(i));
            }
        }

        System.out.println(res.toString());
    }

    public static void countVowelsConsonants(String str) {
        int vowels = 0;
        int consonants = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + " Consonants: " + consonants);
    }

    public static void firstNonRepeatedChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> ch : map.entrySet()) {
            if (ch.getValue() == 1) {
                System.out.println(String.valueOf(ch.getKey()));
                break;
            }
        }
    }

    public static void countWordsInSentence(String str) {
        String[] words = str.trim().split("\\s+");
        System.out.println(words.length);
    }

    public static void checkAnagram(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);

        System.out.println(Arrays.equals(a, b));
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        String str = "NUN";
        System.out.println(checkPallindrom(str));
        countOccurance("Programme", 'm');
        removeDuplicate("Programme");
        firstNonRepeatedChar("programmep");
        countWordsInSentence("Java is   Awesome");
        checkAnagram("silent", "liste");
        countVowelsConsonants("hello");
    }
}
