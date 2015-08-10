public class Solution {
    List<List<String>> res;
    ArrayList<String> cur;
    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        cur = new ArrayList<String>();
        helper(s, 0);
        return res;
    }
    public void helper(String s, int index) {
        //Discuss answer: if(currLst.size()>0 //the initial str could be palindrome
        if (index >= s.length()) {
            List<String> temp = (ArrayList<String>) cur.clone();
            res.add(temp);
        }
        for(int i = index; i < s.length(); i++) {
            if (isPalind(s, index, i)) {
                if(index==i)
                    cur.add(Character.toString(s.charAt(i)));
                else
                // 第i+1个元素不会被复制，只复制到第i个
                    cur.add(s.substring(index,i+1));
                helper(s, i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    private boolean isPalind(String s, int begin, int end) {
        if (begin == end) return true;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) return false;
            begin++; end--;
        }
        return true;
    }
}
