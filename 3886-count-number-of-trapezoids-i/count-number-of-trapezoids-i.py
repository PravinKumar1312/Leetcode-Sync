from collections import defaultdict
from typing import List

class Solution:
    def countTrapezoids(self, points: List[List[int]]) -> int:
        MOD = 10**9 + 7
        
        # Group points by y-coordinate
        y_count = defaultdict(int)
        for x, y in points:
            y_count[y] += 1
        
        # Compute a[i] = C(cnt, 2) mod MOD
        a = []
        for cnt in y_count.values():
            if cnt >= 2:
                a.append(cnt * (cnt - 1) // 2 % MOD)
        
        if len(a) < 2:
            return 0
        
        # S = sum(a[i])
        S = 0
        sum_a2 = 0
        for val in a:
            S = (S + val) % MOD
            sum_a2 = (sum_a2 + val * val) % MOD
        
        inv2 = pow(2, MOD - 2, MOD)
        ans = (S * S - sum_a2) % MOD
        ans = ans * inv2 % MOD
        
        return ans