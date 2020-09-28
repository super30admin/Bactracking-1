# Leetcode problem link : https://leetcode.com/problems/combination-sum/
# Time Complexity : O(n^n)
#  Space Complexity : O(m) where m is the max number of elements that can be added to path without exceeding the target
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
     1. Start from the first index and add to current path
     2. Call backtracking recursively starting from same index and keep adding till current path sum exceeds target
     3. For loop will iterate through all elements in the input always starting from current index and going index + 1
     4. Once done with recursive call remove the element last added and continue
'''

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        output = []
        
        self.backtracking(candidates,target,0,output,[])
        return output

    def backtracking(self,candidates,target,index,output,path):
        if target < 0:
            return
        elif target == 0:
            temp = [i for i in path]
            output.append(temp)
            return
        elif index >= len(candidates):
            return
        
        for i in range(index,len(candidates)):
            path.append(candidates[i])
            self.backtracking(candidates, target - candidates[i], i, output, path)
            path.remove(path[-1])
            