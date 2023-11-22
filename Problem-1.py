class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        subset, superset = [], []
        def helper(n, sum):
            if n < 0:
                return
            if sum > target:
                return
            if sum == target:
                superset.append(subset[:])
                return
            
            #Include
            subset.append(candidates[n])
            helper(n, sum + candidates[n])

            #Exclude
            subset.remove(candidates[n])
            helper(n-1, sum)

        helper(len(candidates)-1, 0)
        print(superset)
        return superset