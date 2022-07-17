import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Palindrome {
    public static void main(String[] args) {
        String word1 = "cacb";
        String word2 = "cbba";

        longestPalindrome(word1, word2);

    }

    public static int longestPalindrome(String word1, String word2) {
        //System.out.println(strSubset(word1));
        //System.out.println(strSubset(word2));

        for(char[] w : strSubset(word1)) {
            System.out.print(Arrays.toString(w) + " ");
        }
        System.out.println();
        for(char[] w : strSubset(word2)) {
            System.out.print(Arrays.toString(w) + " ");
        }

        return 0;
    }

    private static List<char[]> strSubset(String str) {
        List<char[]> subsets = new ArrayList<>();

        int subsetSize = 1;
        for(int i = 0; i < str.length() && subsetSize <= str.length(); i++) {
            subsets.add(new char[]{str.charAt(i)});
            subsetSize++;
        }
        return subsets;
    }
    private static boolean palindromeChecker() {
        return false;
    }
}
           
     