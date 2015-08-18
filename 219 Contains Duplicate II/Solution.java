public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}

// Solution with more details
// 用一个set维护窗口内的数字判断是否出现重复，使用两个指针start和end标记滑动窗口的两端，
// 初始都是0，然后end不断进行扩展，扫描元素判断是否出现重复元素，直到发现end-start>k,
// 就开始移动start，并且在set中移除对应的元素。如果以为扫描到数组末尾还没有发现重复元素，
// 那就可以返回false。
// 时间复杂度和空间复杂度都是O（N）
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length && i <= k; i++) {
            if (!set.add(nums[i])) return true;
        }
        for (int i = k+1; i < nums.length; i++) {
            set.remove(nums[i-k-1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
