public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int index = s.length()-1; index >= 0; index--) {
            if (s.charAt(index) != ' ') 
                len++;
            else if (len > 0) {
                return len;
            }
        }
        return len;
    }
}