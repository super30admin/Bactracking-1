#Approach - Brute force complexity 
#Time complexity : O(n*2^(target/minimum elment in the list)) here n is number of elements i.e. we are creating new list
#Space complexity : O(log m base 2) where m is the depth of tree
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=ZcwpurxyIaQ&ab_channel=%7BS30%7D
class Solution:
    #brute force
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
            self.result.append(path)
            return
        if i==len(candidates) or target <0:
            return
        #logic
        #no choose 
        #when we are not choosing the ith element then we move to i+1 element and we are creating new list while calling the recursion function by appending the previous path in the list
        self.helper(candidates, target, i+1, list(path))
        #choose case
        #if we are selecting the element then we append that element to the list 
        path.append(candidates[i])
        #further calling recursion function for same element and as we have selected the element so we will change the target value
        self.helper(candidates, target-candidates[i], i, list(path))
