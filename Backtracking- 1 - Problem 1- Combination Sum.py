"""
FAANMG Problem #69 {Medium}

39. Combination Sum

Time Complexity:O(2^m*k) m = no of nodes; k = amount
Space Complexity:O(m*H)H: height of the tree


Did this code successfully run on Leetcode : Yes

Recursive Solution 

@name: Rahul Govindkumar
"""   
class Solution:
    
    def helper(self, candidates, index ,target, path):
        
        #base
        if(index ==len(candidates) or target < 0):
            return
        
        if(target == 0):
            self.result.append(path)
          
            return
            
        #logic
        # we will pass a new path every time we go to the choose/not choose scenario as the path is a data structure list inside stack and it will pass as a refernce so we will get all the elements. To avoid this we will use new list.
        # not choose
        self.helper(candidates, index + 1  ,target, path.copy())
        path.append(candidates[index])
        self.helper(candidates, index ,target-candidates[index],path)
        

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        if not candidates:
            return []
        
        self.result=[]
        self.helper(candidates, 0 ,target,[])
        
        return self.result
        
'''
Approach 2

Time Complexity:O(2^m*k) m = no of nodes; k = amount
Space Complexity:O(m*H)H: height of the tree

'''

class Solution:
    
    def helper(self, candidates, index ,target, path):
        
        #base
        if(index ==len(candidates) or target < 0):
            
            return
        
        if(target == 0):
            self.result.append(path)
           
      
            return
            
        #logic
        #Choose
        # we will pass a new path every time we go to the choose/not choose scenario as the path is a data structure list inside stack and it will pass as a refernce so we will get all the elements. To avoid this we will use new list.



        # choose
        # if we will do choose scenario before not choose and add the path above then we will get wrong answer. So to avoid this we will add the path in temp array. We will pass this new temp array in choose scenario only.
        temp = path.copy()        
        temp.append(candidates[index])
        

        self.helper(candidates, index ,target-candidates[index],temp)
        
        #not choose
    

        self.helper(candidates, index + 1  ,target, path.copy())
       
        

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        if not candidates:
            return []
        
        self.result=[]
        self.helper(candidates, 0 ,target,[])
        
        return self.result
        
        

'''
Approach 3

Backtracking

Time Complexity:O(2^m*k) m = no of nodes; k = amount
Space Complexity:O(m*H)H: height of the tree

'''


class Solution:
    
    def helper(self, candidates, index ,target, path):
        
        #base
        if(index ==len(candidates) or target < 0):
            return
        
        # if amount is 0, then we add it to the result list and also return
        if(target == 0):
            
            # adding the path new reference as its being backtracked
            self.result.append(path.copy())
          
            return
            
        #logic
        
        # recursively call the function until we reach the end of the list with the amount
        #not choose
        self.helper(candidates, index + 1  ,target, path)
        
        #choose
        #action : Add the element to the list
        path.append(candidates[index])
        
        #recurse
        self.helper(candidates, index ,target-candidates[index],path)
        #backtrack
        path.pop()
        

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # check if candidates is present, if not then return empty list as result
        if not candidates:
            return []
        
        self.result=[]
        self.helper(candidates, 0 ,target,[])
        
        return self.result
        
'''
Approach 4

For loop based recursion - Brute Force

Time Complexity:O(2^m*k) m = no of nodes; k = amount
Space Complexity:O(m*H)H: height of the tree

'''

class Solution:
    
    def helper(self, candidates, pivot ,target, path):
        
        #base
        if(target < 0):
            return
        
        # if amount is 0, then we add it to the result list and also return
        if(target == 0):
            
            # adding the path new reference as its being backtracked
            self.result.append(path)
          
            return
            
        for i in range(pivot, len(candidates)):
            
            temp=list(path)
            temp.append(candidates[i])
            self.helper(candidates, i ,target - candidates[i] , temp)
            
            
        

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # check if candidates is present, if not then return empty list as result
        if not candidates:
            return []
        
        self.result=[]
        
          
        
        self.helper(candidates, 0 ,target,[])
        
        return self.result
        

'''
Approach 4

For loop based recursion - Backtrack

Time Complexity:O(2^m*k) m = no of nodes; k = amount
Space Complexity:O(m*H)H: height of the tree

'''

class Solution:
    
    def helper(self, candidates, pivot ,target, path):
        
        #base
        if(target < 0):
            return
        
        # if amount is 0, then we add it to the result list and also return
        if(target == 0):
            
            # adding the path new reference as its being backtracked
            self.result.append(list(path))
          
            return
            
        for i in range(pivot, len(candidates)):
            
            #action
            path.append(candidates[i])
            #recurse
            self.helper(candidates, i ,target - candidates[i] , path)
            #backtrack
            path.pop()
            
            
        

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # check if candidates is present, if not then return empty list as result
        if not candidates:
            return []
        
        self.result=[]
        
          
        
        self.helper(candidates, 0 ,target,[])
        
        return self.result
        