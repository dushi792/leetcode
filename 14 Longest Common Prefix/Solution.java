// My own solution
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer res = new StringBuffer();
        if (strs == null || strs.length == 0) return res.toString();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return res.toString();
            }
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}
// Other's Solution:
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length()-1);
        }
        return pre;
    }
}