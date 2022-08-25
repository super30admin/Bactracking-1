# Time complexity : O(2^n)
# Space complexity : O(h)
# Leetcode : Solved and submitted

class Solution:
    def combinationSum(self, candidates, target):
        self.res = []
        if not candidates:
            return self.res
        # making path as global
        self.path = []
        
        # sort the candaidates list
        candidates.sort()
        
        # call the recursive function
        self.helper(candidates, 0, target, self.path)
        return self.res
    def helper(self, candidates, pivot, amt, path):
        # if amt is negative, we simply return
        if amt < 0:
            return
        # if amt is 0, then we add the copy of path to the res and return from there
        if amt == 0:
            self.res.append(path[:])
            return
          
        # start of for loop recursion from pivot till the end
        for i in range(pivot,len(candidates)):
            # if element in candidate at i is greater than amt, then we break, since the list is sorted now
            if candidates[i] > amt:
                break
            # append the element at i to the path
            self.path.append(candidates[i])
            
            # after choosing candidates[i], if we still have amt left, only then we call the function recursively
            if amt - candidates[i] >= 0 or candidates[i] < amt:
                self.helper(candidates, i, amt - candidates[i], self.path)
             # backtrack by removing the last element added to the path
            self.path.pop()
