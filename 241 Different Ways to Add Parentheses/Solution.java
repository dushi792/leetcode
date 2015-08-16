public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-'
            || input.charAt(i) == '*') {
                // 每次用substring基本必错，很容易写成input.substring(0,i-1)
                // 实际上substring(int beginIndex, int endIndex)不包含endIndex位置的字符
                // 所以要写到i而不是i-1
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for (Integer lf : left){
                    for (Integer rt : right) {
                        if (input.charAt(i) == '+') res.add(lf+rt);
                        else if (input.charAt(i) == '-') res.add(lf-rt);
                        else res.add(lf*rt);
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
