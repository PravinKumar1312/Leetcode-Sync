from typing import List

class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total = sum(nums)
        target = total % p
        
        if target == 0:
            return 0
        
        prefix_mod = {}
        prefix_mod[0] = -1  # to handle case when prefix itself equals target
        curr = 0
        min_len = len(nums)
        
        for i, num in enumerate(nums):
            curr = (curr + num) % p
            # We want (curr - target) % p
            need = (curr - target) % p
            if need in prefix_mod:
                min_len = min(min_len, i - prefix_mod[need])
            prefix_mod[curr] = i
        
        return min_len if min_len < len(nums) else -1