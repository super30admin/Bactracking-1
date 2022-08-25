# Time complexity : O(2 ^ m ^n)
# Space complexity : O(m*n)
# Leetcode : Solved and submitted

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        if not candidates:
            return self.res
        self.path = []
        self.helper(candidates, 0, target, self.path)
        return self.res
    
    def helper(self, candidates, pivot, amt, path):
        # return to the last function call if amount is less than 0
        if amt < 0:
            return
        # if amount is 0, then add the path to the res and also return
        if amt == 0:
            self.res.append(path[:])
            return
        # use for loop to go from that pivot element till the end of the arr
        for i in range(pivot,len(candidates)):
            # for each element, we append that element to path, call the recursive function and check for all combinations
            self.path.append(candidates[i])
            self.helper(candidates, i, amt - candidates[i], self.path)
            # remove the element from the end to keep the current path
            self.path.pop()
