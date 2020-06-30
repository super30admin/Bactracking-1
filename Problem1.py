# Time Complexity : O(n2) 
# Space Complexity : O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
    # 1) choose or not choose each element. We can implement this by recurisve solution one by passing new temp array 
    #    each time and one method by keeping the same array and backtracking
    
# class Solution1:
#     result = None 
#     tar = None
#     # TC = O(2^n) | Space = O(2^n)
#     def combinationSum(self, candidates, target):
#         self.result = []
#         self.tar = target 
#         if not candidates:
#             return self.result
#         self.__dfs(candidates,0,0,[])
#         return self.result 
    
#     def __dfs(self,candidates,indx,currSum,temp):
#         # base 
#         if currSum > self.tar or indx == len(candidates):
#             return 
#         if currSum == self.tar:
#             self.result.append(temp.copy())
#             return 
#         # logic 
#         self.__dfs(candidates,indx+1,currSum,temp)
#         self.__dfs(candidates,indx,currSum+candidates[indx],temp + [candidates[indx]])

# class Solution2:
#     result = None 
#     #  Time = O(n^2) | space = O(n)
#     def combinationSum(self, candidates, target):
#         self.result = []
#         if not candidates or len(candidates) == 0:
#             return self.result 
#         self.__dfs(candidates,target,0,0,[])
#         return self.result
    
#     def __dfs(self,candidates,target,indx,currSum,temp):
#         # base 
#         if currSum > target or indx == len(candidates):
#             return 
#         if currSum == target:
#             self.result.append(temp.copy())
#             return 
#         # logic 
#         for i in range(indx, len(candidates)):
#             temp.append(candidates[i])
#             self.__dfs(candidates,target,i,currSum+candidates[i],temp)
#             temp.pop()

class Solution3:
    # Time = O(2^n) | O(n) time 
    result = None
    def combinationSum(self, candidates, target):
        self.result = []
        if not candidates or len(candidates) == 0:
            return self.result 
        self.backtrack(candidates,target,0,0,[])
        return self.result
    
    def backtrack(self,candidates,target,indx,currSum,temp):
        if currSum > target or indx == len(candidates):
            return 
        if currSum == target:
            self.result.append(temp.copy())
            return 
        # Logic 
        # not choose 
        self.backtrack(candidates,target,indx+1,currSum,temp)
        
        #choose
        temp.append(candidates[indx])
        self.backtrack(candidates,target,indx,currSum+candidates[indx],temp)
        temp.pop()    

if __name__ == "__main__":
    s1 = Solution3()
    candidates = [2,3,6,7]
    target = 7 
    res = s1.combinationSum(candidates, target)
    
    
    print(res)