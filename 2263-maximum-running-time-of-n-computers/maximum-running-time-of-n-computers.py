from typing import List

class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        total = sum(batteries)
        left, right = 0, total // n + 1
        
        def can_run(t):
            # Check if we can run all n computers for t minutes
            total_power = 0
            for b in batteries:
                total_power += min(b, t)
            return total_power >= n * t
        
        while left < right:
            mid = (left + right + 1) // 2
            if can_run(mid):
                left = mid
            else:
                right = mid - 1
        return left