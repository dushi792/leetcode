class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def findMin(self, nums):
        min = nums[0]
        for i in nums:
            if i < min:
                return i
        return min