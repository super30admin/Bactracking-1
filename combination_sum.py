# TC: O(2^N)
# SC: O(H)

class Solution:
    res=[]
    def helper(self,candidates,i,li,target):
        if target==0:
            print(self.res)
            self.res.append(li)
            return

        if i==len(candidates) or target<0:
            return

        lis=li.copy()
        self.helper(candidates,i+1,lis,target)

        lis1=li.copy()
        lis1.append(candidates[i])
        self.helper(candidates,i,lis1,target-candidates[i])

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res=[]
        self.helper(candidates,0,[],target)
        return self.res

        