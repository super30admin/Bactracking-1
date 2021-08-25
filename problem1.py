#combination sum
#time complexity: O(N) where n is the number of candidates
#space complexity: O(N)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(i,cur,total):
            if total == target:
                res.append(cur.copy())
                return
            if i>=len(candidates) or total>target:
                return
            
            cur.append(candidates[i])
            #including candidates
            dfs(i,cur,total+candidates[i])
            cur.pop()
            #when candidiates cant be added
            dfs(i+1,cur,total)
        
        dfs(0,[],0)
        return res 