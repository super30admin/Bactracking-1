#Time complexity is O(2^n) where n is the number of elements int he candidates array
#Space complexity is O(2^n) where n is the number of elements int he candidates array
#Code ran successfully on leet code
#No issues faced while coding

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        #Creating a new list to give the combinations as output
        self.result=[]
        self.helper(candidates,0,target,[])
        return self.result
    
    def helper(self,candidates,idx,target,path):
        #base case
        #If index crosses the length of the array or if target becomes negative, we will return nothing
        if(idx==len(candidates) or target<0):
            return
        #If target is equal to 0, we will append the path to the final result
        if(target==0):
            self.result.append(list(path))
            return
        #logic
        #No choose
        #If we dont choose , we will just increase the index value and we will make recursive call
        self.helper(candidates,idx+1,target,path)
        #choose
        #action
        #If we choose we will append the candidates value to the path
        path.append(candidates[idx])
        #We will make a recursive call, but subtracting the target from the candidates value
        self.helper(candidates,idx,target-candidates[idx],path)
        #backtrack the values added to the path
        path.pop()


