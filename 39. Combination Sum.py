# time complexity: O(2^n)
# space complexity: O(n)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result=[]
        if candidates==None or len(candidates)==0: return result
        
        def helper(candidates, target, index, path):
            #base
            if target<0: return
            if target==0:
                result.append(list(path))
                return
            #logic
            for i in range(index, len(candidates)):
                #newlist=list(path)
                #newlist.append(candidates[i])
                #action
                path.append(candidates[i])
                #recursion
                helper(candidates, target-candidates[i], i, path)
                #backtracking
                path.pop()
        
        helper(candidates, target, 0, [])
        return result
        