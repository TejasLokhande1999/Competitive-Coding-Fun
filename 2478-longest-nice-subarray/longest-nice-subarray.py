class Solution:
    def longestNiceSubarray(self, nums: List[int]) -> int:

        maxlen= 1
        curror= 0
        left = 0

        for right in range (len(nums)):
            while curror & nums[right] != 0:
                curror ^= nums[left]
                left += 1

            curror |= nums[right]
            maxlen = max (maxlen, right - left + 1)
        return maxlen

            

        