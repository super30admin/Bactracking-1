// Time Complexity: O(n^n)
// Space Complexity: O(max length of output list)
// Passed all Test cases on Leetcode: Yes
// Approach: Use backtracking to build lists that sum up to target. Use only one list to store intermediate results. keep iterating
// in the loop by passing 'i' to recursion as we can use a digit multiple time. Break recursion if target is less than 0.

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        
        if(candidates==[]):
            return([])
        
        self.op=[]
        
        self.backtrack(candidates,target,0,[])
        return(self.op)

    def backtrack(self,candidates,target,index,l):
        if(target<0):
            return
        if(target==0):
            self.op.append(copy.deepcopy(l))
            return
            
        for i in range(index,len(candidates)):
            l.append(candidates[i])
            self.backtrack(candidates,target-candidates[i],i,l)
            l.pop()
            
            
        
        