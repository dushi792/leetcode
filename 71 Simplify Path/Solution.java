public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<String>();
        HashSet<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stk.empty()) {
                stk.pop();
            }
            if (!set.contains(dir)) {
                stk.push(dir);
            }
        }
        String res = new String();
        while (!stk.empty()) {
			// 不能写成 res += "/" + stk.pop()
			// 每次新路径要在旧路径之前
            res = "/" + stk.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}