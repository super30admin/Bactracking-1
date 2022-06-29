#Approach - Brute force with backtracking
#Time complexity : O(2^(target/minimum elment in the list))
#Space complexity : O(log m base 2) where m is the depth of tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=ZcwpurxyIaQ&ab_channel=%7BS30%7D
class Solution:
    #brute force with backtrack
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #checking null case
        if candidates == None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self, candidates: List[int], target: int, i:int, path: List[int]):
        #base case 
        #if we reach the leaf when when index gets out of bound or target is 0 or negative
        #if tagert is 0 then we will append our one path to the result
        if target == 0:
            #while appending path we are making new deep copy so we are using list function because there only one path for whole recusrion and it changes during backtrack so at the end list gets empty and thus we get none as result 
            self.result.append(list(path))
            return
        if i==len(candidates) or target <0:
            return
        #logic
        #no choose
        self.helper(candidates, target, i+1, path)
        #choose
        path.append(candidates[i])
        self.helper(candidates, target-candidates[i], i, path)
        #backtrack
        path.pop(len(path)-1)
