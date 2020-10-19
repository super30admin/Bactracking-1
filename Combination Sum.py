# Time Complexity : No idea
# Space Complexity : No idea
# Did this code successfully run on Leetcode : - Yes
# Any problem you faced while coding this : No

class Solution(object):
    def combinationSum(self, candidates, target):
        
        ans = []
        candidates.sort()
        self.combination(candidates,target,[],ans,0)
        return ans

    def combination(self,candidates,target,path,ans,index):
        # base condition
        if target<0:
            return
        if target==0:
            ans.append(path)
            return
        
        # Backtracking
        for i in range(index,len(candidates)):
            self.combination(candidates,target-candidates[i],path+[candidates[i]],ans,i)
        