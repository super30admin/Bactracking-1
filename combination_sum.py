// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
for every combination we check if the su is equal to the given target.If yes we add it to the list.

Time complexity --> o(2**n)
space complexity --> o(n*(2**n))

class Solution:
    def __init__(self):
        self.result=[]
    def backtrack(self,candidates,list1,target,index):
        if sum(list1)>target:
            return
        if sum(list1)==target:
            self.result.append(list(list1))
            return
        for i in range(index,len(candidates)):
            list1.append(candidates[i]) #append the candidate
            self.backtrack(candidates,list1,target,i) #recursion
            list1.pop() #Remove the candidate
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates==None or len(candidates)==0:
            return []
        self.backtrack(candidates,[],target,0)
        return self.result