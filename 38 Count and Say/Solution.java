public class Solution {
    public String countAndSay(int n) {
        StringBuffer preStrs = new StringBuffer();
        StringBuffer newStrs = new StringBuffer();
        preStrs.append(1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < preStrs.length(); j++) {
                int count = 1;
                char num = preStrs.charAt(j);
                while (j+1 < preStrs.length() && num == preStrs.charAt(j+1)) {
                    count++;
                    j++;
                }
                newStrs.append(count);
                newStrs.append(num);
            }
            newStrs.append(count).append(num);
        }
        return preStrs.toString();
    }
}
