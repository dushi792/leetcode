public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            // 这个if用来跳过重复，不写的话[0,0,0]测试fail
            if (i == 0 || nums[i] != nums[i-1]) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j+1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        // 记得上面跳过重复元素之后要移动指针
                        j++;
                        k--;
                    }
                    else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}