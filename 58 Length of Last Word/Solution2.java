public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int idx = s.length()-1;
        while (idx >= 0 && s.charAt(idx) == ' ') {idx--;}
        int i = idx;
        while (i >= 0 && s.charAt(i) != ' ') {i--;len++;}
		// Better way
        // while(idx2>=0 && s.charAt(idx2)!=' ') idx2--;
		// return idx-idx2;
		return len;
    }
}