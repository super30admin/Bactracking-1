#Approach: For loop Recursion:
#Time Complexity O(2^N) 
#Space Complexity O(h)
#It successfully runs on leetcode 

#Backtracking
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates,0, target, [])
        return self.result
        
    def helper(self, candidates, idx, target, path):
        if target< 0 : return
        if target==0:
            self.result.append(list(path))
            return
        for i in range(idx,len(candidates)): 
         
            path.append(candidates[i])
            self.helper(candidates, i, target -candidates[i], path)
            path.pop()

#For loop recursion without backtracking, creating new array list every time
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates,0, target, [])
        return self.result
        
    def helper(self, candidates, idx, target, path):
        if target< 0 : return
        if target==0:
            self.result.append((path))
            return
        for i in range(idx,len(candidates)): 
            temp = list(path)
            temp.append(candidates[i])
            self.helper(candidates, i, target -candidates[i], temp)
     


#Approach: just like coin change choose not choose and everytime new list
#Time Complexity O(2^N) 
#Space Complexity O(h)
#It successfully runs on leetcode 

#backtracking
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates,0, target, [])
        return self.result
        
    def helper(self, candidates, i, target, path):
        if i == len(candidates) or target< 0 : return
        if target==0:
            self.result.append(list(path))
            return
        #Not Choose
        self.helper(candidates, i+1, target, path) 
        #choose
        path.append(candidates[i])
        self.helper(candidates, i, target -candidates[i], path)
        path.pop()



#Approach: Adding new list to every recursion call
#Time Complexity O(2^N) + O(N)
#Space Complexity O(h)
#It successfully runs on leetcode 

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates,0, target, [])
        return self.result
        
    def helper(self, candidates, i, target, path):
        if i == len(candidates) or target< 0 : return
        if target==0:
            self.result.append(path)
            return
        #Not Choose
        self.helper(candidates, i+1, target, list(path)) 
        #choose
        path.append(candidates[i])
        self.helper(candidates, i, target -candidates[i], list(path))



#using choose before not choosing so path will be modified for both choose and not choose, in this scenario we can have temp list for choose scenario
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates,0, target, [])
        return self.result
        
    def helper(self, candidates, i, target, path):
        if i == len(candidates) or target< 0 : return
        if target==0:
            self.result.append(path)
            return
        #choose
        temp= list(path)
        temp.append(candidates[i])
        self.helper(candidates, i, target -candidates[i], temp)
        #Not Choose
        self.helper(candidates, i+1, target, list(path)) 