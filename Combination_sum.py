#Run on leetcode-yes
#Time complexity-o(n)
#space complexity-o(1)

class Solution:
            
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        nums = sorted(candidates)
        print(nums)
        res = []
        self.dfs(target,res,0,[],nums)
        print(res)
        return res
    def dfs(self,target,res,start,subset,nums):
        if target == 0:
            res.append(list(subset))
        for i in range(start,len(nums)):
            if nums[i] > target:
                break
            if i != start and nums[i] == nums[i-1]:
                continue
            subset.append(nums[i])
            self.dfs(target-nums[i],res,i,subset,nums)
            subset.pop()
           
