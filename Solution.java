import java.util.Arrays;

public class Solution {

    /*
    Create the lexicographically smallest string by removing 
    any letter from the first 'k' letters and appending
    it to the end of the string, any number of times.
     */
    public String orderlyQueue(String s, int k) {

        /*
        When k=1, the only possible letter combinations are those created
        by circular rotation of all letters i.e. the frist becomes
        the last, etc. Thus, we have to find the smallest string among 
        all these combinations.        
         */
        if (k == 1) {
            return findLexicographicallySmallestStringByRotation(s);
        }

        /*
        When k>1, any leter combination can be created. 
        Therefore, a sorted string is returned.        
         */
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        return String.valueOf(sorted);
    }

    public String findLexicographicallySmallestStringByRotation(String s) {
        String smallest = s;
        int rotations = s.length();
        while (rotations-- > 0) {
            s = s.substring(1) + s.charAt(0);
            smallest = smallest.compareTo(s) > 0 ? s : smallest;
        }
        return smallest;
    }
}
