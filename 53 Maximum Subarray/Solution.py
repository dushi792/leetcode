class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def maxSubArray(self, nums):
        currmax = nums[0]
        summax = nums[0]
        for num in nums[1:]:
            currmax = currmax + num if currmax + num > num else num
            summax = currmax if currmax > summax else summax
        return summax
