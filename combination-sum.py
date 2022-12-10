# 0-1 backtracking / can also be done via for loop based recursion/backtracking
#TC: O(2^n)
#SC: O(n)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        def f(i,t):
            nonlocal ans,curlist,candidates,target
            if t==0: 
                ans.append(deepcopy(curlist))
                return
            if t<0 or i==len(candidates): return

            curlist.append(candidates[i])
            f(i,t-candidates[i])
            curlist.pop()
            f(i+1,t)

        ans,curlist=[],[]
        f(0,target)
        return ans
