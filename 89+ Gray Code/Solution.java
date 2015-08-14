public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<Integer>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            int cur = 1 << i;
            for (int j = res.size()-1; j >= 0; j--) {
                res.add(cur+res.get(j));
            }
        }
        return res;
    }
}
