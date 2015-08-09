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
        if (cur.size()>0 &&index >= s.length()) {
            List<String> temp = (ArrayList<String>) cur.clone();
            res.add(temp);
        }

        for(int i = index; i < s.length(); i++) {
            if (isPalind(s, index, i)) {
                if(index==i)
                    cur.add(Character.toString(s.charAt(i)));
                else
                    cur.add(s.substring(index,i+1));
                // cur.add(s.substring(index,i));
                helper(s, index+1);
                cur.remove(cur.size()-1);
            }
        }
    }

    private boolean isPalind(String s, int begin, int end) {
        if (begin == end) return true;
        while (begin < end) {
            if (s.charAt(begin) != s.charAt(end)) return false;
            begin++;
            end--;
        }
        return true;
    }
}
