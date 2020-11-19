# Time Complexity:- n^n
# Space Complexity:- n+n
# Approach:- Use backtracking to generate all the combinations of our candidates starting from pivot element to the end of the array. To generate 
# all the combination recursively what we do is we choose or not choose a candidate. Here we are implementing the same using a a pivot
# element. Using this pivot element we can choose or not choose a candidate. When we increase the pivot element we are not choosing the candidate 
class Solution: 
    def combinationSum(self, candidates, target):
        res=[]
        def backtrack(sum,temp,pivot):
            if sum>target:
                return
            if sum==target:
                res.append(list(temp))
            for i in range(pivot,len(candidates)):
                temp.append(candidates[i])
                # i remaining the same because we can use the same candidate multiple times
                backtrack(sum+candidates[i],temp,i)
                temp.pop()
        backtrack(0,[],0)
        return res
            