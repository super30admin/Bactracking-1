class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        candidates.sort()
        res = []
        count = [0]
        def helper(S, slate):
            if sum(slate) > target:
                return
            
            if sum(slate) == target:
                res.append(slate[:])
                count[0] += 1
                return
            
            for index in range(len(S)):
                slate.append(S[index])
                helper(S[index:], slate)
                slate.pop()
                
        if candidates:
            helper(candidates,[])
            return res
        return []