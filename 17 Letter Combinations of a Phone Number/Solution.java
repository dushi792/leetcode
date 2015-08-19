// Better Solution should be reviewed: https://leetcode.com/discuss/24431/my-java-solution-with-fifo-queue
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits == null || digits.length() == 0)
            return res;
        backtracking(digits, res, new StringBuffer(), 0);
        return res;
    }
    private void backtracking(String digits, List<String> res, StringBuffer curr, int index) {
        if (index == digits.length()) {
            res.add(new String(curr.toString()));
            return;
        }
        char[] letter = convert(digits.charAt(index));
        for (int i = 0; i < letter.length; i++) {
            curr.append(letter[i]);
            backtracking(digits, res, curr, index+1);
            curr.deleteCharAt(index);
        }
    }
    private char[] convert(char c) {
        String str = new String();
        switch (c) {
            case '2': str = "abc"; break;
            case '3': str = "def"; break;
            case '4': str = "ghi"; break;
            case '5': str = "jkl"; break;
            case '6': str = "mno"; break;
            case '7': str = "pqrs"; break;
            case '8': str = "tuv"; break;
            case '9': str = "wxyz"; break;
        }
        char[] res = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            res[i] = str.charAt(i);
        }
        return res;
    }
}
