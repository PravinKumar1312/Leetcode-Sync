from typing import List

class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        total_sum = sum(nums)
        
        # If total sum is odd, no partitions work
        if total_sum % 2 != 0:
            return 0
        
        # If total sum is even, all partitions work
        return len(nums) - 1