"""
Time Complexity : 
Space Complexity : 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
I have 3 reaons below. The first one is backtracking using for loop. The second is backtrack without for loop
and the thirs is normal recursion. Backtracking is action , recurse and backtrack. In recursion, the solution
consumes a lot of space as a temp array is made at every node, which increases the space exponentially.
With backtracking, we use the same list for whole recursion and keep on removing the value once recursion at
that point is done.
"""


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if not candidates:
            return candidates
        self.backtrack(candidates, target, 0, [], 0, len(candidates))
        return self.result

    def backtrack(self, candidates, target, summ, temp, index, l):
        if summ == target:
            newtemp = copy.deepcopy(temp)
            self.result.append(newtemp)
            return
        if summ > target:
            return
        for i in range(index, l):
            temp.append(candidates[i])
            self.backtrack(candidates, target, summ+candidates[i], temp, i, l)
            temp.pop()

    # class Solution:
    #     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #         self.result=[]
    #         if not candidates:
    #             return candidates
    #         self.helper(candidates,target,0, [],0)
    #         return self.result

    #     def helper(self,candidates,target,summ,temp,index):
    #         if summ==target:
    #             newtemp=copy.deepcopy(temp)
    #             self.result.append(newtemp)
    #             return
    #         if summ>target or index>=len(candidates):
    #             return
    #         self.helper(candidates,target,summ,temp,index+1)
    #         temp.append(candidates[index])
    #         self.helper(candidates,target,summ+candidates[index],temp,index)
    #         temp.pop()

    # class Solution:
    #     def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    #         self.result=[]
    #         if not candidates:
    #             return candidates
    #         self.helper(candidates,target,0, [],0)
    #         return self.result

    #     def helper(self,candidates,target,summ,temp,index):
    #         if summ==target:
    #             self.result.append(temp)
    #             return
    #         if summ>target or index>=len(candidates):
    #             return
    #         self.helper(candidates,target,summ,temp,index+1)
    #         self.helper(candidates,target,summ+candidates[index],temp+[candidates[index]],index)
