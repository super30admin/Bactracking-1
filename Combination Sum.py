class Solution:
    #Solution 1
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(N^(T/M) + 1)
        #Space Complexity: O(T/M)           // only one copy of path
        #where, N is the number of candidates,
        #T is the target value, and
        #M is the minimum value among candidates
        
        self.result = []
        self.backtracking(candidates, 0, [], target)
        return self.result
        
    def backtracking(self, candidates, pivot, path, target):
        #base
        if target < 0:
            return
        elif target == 0:
            self.result.append(path.copy())
            return
        
        #logic
        for i in range(pivot, len(candidates)):
            #action
            path.append(candidates[i])
            
            #recursion
            self.backtracking(candidates, i, path, target - candidates[i])
            
            #backtrack
            path.pop()
        
    #Solution 2
    """
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #Approach: Recursion with backtracking
        #Time Complexity: O(N^(T/M) + 1)
        #Space Complexity: O(T/M)           // only one copy of path
        #where, N is the number of candidates,
        #T is the target value, and
        #M is the minimum value among candidates
        
        self.result = []
        self.backtracking(candidates, 0, [], target)
        return self.result
        
    def backtracking(self, candidates, idx, path, target):
        #base
        if idx == len(candidates) or target < 0:
            return
        elif target == 0:
            self.result.append(path.copy())
            return
        
        #logic
        #not choose
        self.backtracking(candidates, idx + 1, path, target)
        
        #choose
        path.append(candidates[idx])
        self.backtracking(candidates, idx, path, target - candidates[idx])
        
        #backtracking
        path.pop()
    """
    
    #Solution 3
    """
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #Approach: Recursion
        #Time Complexity: O(N^(T/M) + 1)
        #Space Complexity: O(N^(T/M) + 1)   // deep copy of path at every node
        #where, N is the number of candidates,
        #T is the target value, and
        #M is the minimum value among candidates
        
        self.result = []
        self.helper(candidates, 0, [], target)
        return self.result
        
    def helper(self, candidates, idx, path, target):
        #base
        if idx == len(candidates) or target < 0:
            return
        elif target == 0:
            self.result.append(path)
            return
        
        #logic
        #not choose
        self.helper(candidates, idx + 1, path.copy(), target)
        
        #choose
        path.append(candidates[idx])
        self.helper(candidates, idx, path.copy(), target - candidates[idx])
    """