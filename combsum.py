class Solution:
        
        """
        Description: Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
        
        Time Complexicity: O(2^n)
        Space Complexicity: O(n)
        
        Worked in leetcode: No

        Approach: Use of backtracking (each node, the generated list has to be re-initialized)
        1. use helper function recursively to make target == 0
        2. select options; choose or not choose a given item in the array, add item to an empty list when choose 
        3. backtrack the list created so it doesn't keep additional values under the hood
        """
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []
        if candidates == None or len(candidates) == 0: return self.result
        
        self.helper(candidates, target, 0, [])
        
        return self.result
    
    def helper(self, candidates, target, idx, path):
        
        # base
        if idx == len(candidates) or target < 0: 
            return
        
        if target == 0:
            self.result.append(path.copy())
        
        # logic
        # don't choose item
        self.helper(candidates, target, idx + 1, path)
        
        # choose item
        path.append(candidates[idx])
        self.helper(candidates, target - candidates[idx], idx, path)
        
        # backtrack
        path.pop()
