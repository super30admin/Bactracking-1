#39. Combination Sum
"""
Time Complexity = O(2^n)
Space Complexity = O(n)

"""

class Solution:
    result = []
    def helper(self,candidates, target, index, path):
        #checking for base condition. If target is achieved then path is stored in result
        #base
        if (target == 0):
            print("here")
            self.result.append(list(path))
            return
        
        #checking if index is in limit of candidates array
        if  index == len(candidates) or target < 0 :
            return
        
        #logic
        """
        #case 0 no choose
        self.helper(candidates, target, index+1, path)
        
        path.append(candidates[index])
        print(path)
        
        #case1 choose
        self.helper(candidates, target - candidates[index], index, path)
        """

        for i in range(index, len(candidates)):
            #action
            path.append(candidates[i])
            print(path)
            
            #recurse
            self.helper(candidates, target - candidates[i], i, path)
            
            #backtracking
            path.pop()
        
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #null case
        
        self.result = []
        
        if (candidates == None or len(candidates) == 0):
            return self.result
        
        path = []
        #calling helper function
        self.helper(candidates, target, 0, path)
        return self.result
