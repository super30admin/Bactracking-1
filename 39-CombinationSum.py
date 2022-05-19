#Time Complexity :  
# Space Complexity :
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
class Solution:
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        result = [] 

        if len(candidates) == 0 or candidates is None:
            return result

        def helper(candidates,target,index,path):

            # base case
            if target == 0:
                result.append(list(path))
                #print('result: ', self.result)
                return
            if target < 0 or index == len(candidates):
                return


            # Logic
            # 0 (do not choose case)
            helper(candidates,target,index+1,path)
            # 1(choose case)
            path.append(candidates[index])
            #Recursion
            helper(candidates,target - candidates[index],index,path)
            #Backtracking
            path.pop()
            

        helper(candidates,target,0,[])
        return result
        
        
    
             
        
    