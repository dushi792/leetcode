public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<List<String>>();
        if (strs == null || strs.length == 0) {
            return res;
        }
		// 为了满足结果按照字典序排列，要先对strs排列；
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            if (map.containsKey(str)) {
                map.get(str).add(strs[i]);
            }
            else {
                LinkedList list = new LinkedList();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        Iterator iter = map.values().iterator();
        while (iter.hasNext()) {
            List<String> item = (LinkedList<String>)iter.next();
            res.add(item);
        }
        return res;
    }
}