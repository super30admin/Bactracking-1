#Approach - Forloop based recursion
#Time complexity : O(2^(target/minimum elment in the list))
#Space complexity : O(log m base 2) where m is the depth of tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=ZcwpurxyIaQ&ab_channel=%7BS30%7D
class Solution:
    #for loop based recursion
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #checking null case
        if candidates == None or len(candidates) == 0:
            return self.result
        self.helper(candidates, target, 0, [])
        return self.result
    
    def helper(self, candidates: List[int], target: int, index:int, path: List[int]):
        #base case 
        #if we reach the leaf when when index gets out of bound or target is 0 or negative
        #if tagert is 0 then we will append our one path to the result
        if target == 0:
            #while appending path we are making new deep copy so we are using list function because there only one path for whole recusrion and it changes during backtrack so at the end list gets empty and thus we get none as result 
            self.result.append(list(path))
            return
        if target <0:
            return
        #logic
        #For loop will work from the coming index in the recursion till the last element
        for i in range(index, len(candidates)):
            #here we are not having no choose condition we are directly taking or not taking and checking the targert if target get negative then we stop calling further paths
            #action
            path.append(candidates[i])
            #recurse
            self.helper(candidates, target-candidates[i], i, path)
            #backtrack
            path.pop(len(path)-1)
