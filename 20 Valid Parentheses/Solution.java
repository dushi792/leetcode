public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            stk.push(s.charAt(i));
        }
        LinkedList<Character> temp = new LinkedList<Character>();
        while (!stk.isEmpty()) {
            char curr = stk.pop();
            if (curr == ')' || curr == ']' || curr == '}') temp.add(curr);
            else {
                if (temp.size() == 0) return false;
                if (curr == '(' && temp.get(temp.size()-1) != ')') return false;
                if (curr == '[' && temp.get(temp.size()-1) != ']') return false;
                if (curr == '{' && temp.get(temp.size()-1) != '}') return false;
                temp.remove(temp.size()-1);
            }
        }
        if (temp.size() > 0) return false;
        else return true;
    }
}


// Improvement Solution with one stack space:
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stk.push(s.charAt(i));
            else if (s.charAt(i) == ')' && !stk.isEmpty() && stk.peek() == '(') stk.pop();
            else if (s.charAt(i) == ']' && !stk.isEmpty() && stk.peek() == '[') stk.pop();
            else if (s.charAt(i) == '}' && !stk.isEmpty() && stk.peek() == '{') stk.pop();
            else return false;
        }

        return stk.isEmpty();
    }
}
