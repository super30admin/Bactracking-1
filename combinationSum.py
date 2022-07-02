# 0/1 recursion with backtracking 
# TC Exponential =  (Target/min(nums))+len(nums)
# SC Recursive stack space
class Solution:
    def __init__(self):
        self.result= []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return []
        
        self.helper(candidates, target, 0, [])
        return self.result
        
    def helper(self, candidates, target, i, path):
        # base 
        if target < 0 or i >= len(candidates): return
        if target == 0:
            self.result.append(path[:])
            return
        
        # logic
        
        
        # no choose
        self.helper(candidates, target, i+1, path)

        # choose
        #action
        path.append(candidates[i])
        # recurse
        self.helper(candidates, target-candidates[i], i, path)
        # backtrack
        path.pop()


# for loop recursion with backtracking 
# TC Exponential =  (Target/min(nums))+len(nums)
# SC Recursive stack space
# we prefer for loop based recursion when we have more than once choices, like in this case we have 
# to make choices for every element in the array. On Contrary, in trees with just left and right nodes
# we can use 0/1 recursion like we did above.
class Solution:
    def __init__(self):
        self.result= []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if not candidates:
            return []
        
        self.helper(candidates, target, 0, [])
        return self.result
        
    def helper(self, candidates, target, index, path):
        # base 
        if target < 0: return
        if target == 0:
            self.result.append(path[:])
            return
        
        # logic
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, target-candidates[i], i, path)
            path.pop()

