# Time complexity : O(2^n^m) n - number of elements in the arr and m - amount
# Space complexity : O(n*m)
# Leetcode : Solved and submitted

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.res = []
        
        # check if candidates is present, if not then return empty list as result
        if not candidates:
            return self.res
        self.path = []
        
        # call the helper function with null values 
        self.helper(candidates, 0, target, self.path)
        return self.res
    
    def helper(self, candidates, i, amt, path):
      
        # if we have reached the end of the list or the amount is negative, then we return from that function call
        if i == len(candidates) or amt < 0:
            return
        # if amount is 0, then we add it to the result list and also return
        if amt == 0:
            temp = path[:]
            self.res.append(temp)
            return
        
        # recursively call the function until we reach the end of the list with the amount
        self.helper(candidates, i+1, amt, self.path)
        # add the current element to the path
        self.path.append(candidates[i])
        # with the element in the path, check for possible comibnations of sum equal to the target by using the recursive call
        self.helper(candidates, i , amt - candidates[i], self.path)
        # removed the element at each step to the ones that we added, so that we have no references at the end
        self.path.pop()
