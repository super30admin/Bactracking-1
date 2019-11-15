"""
Leetcode: Accepted
TimeComplexity: n^n
explaination:we keep iterating through out a patricula index and if we the target becomes lesser than the target we pop the element and increment the index


"""



class Solution:
    
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #if the candidates array is null, we return 0
        if len(candidates)==0:
            return None
        result=[]
        #calling the backtrack function with the first index
        self.backtrack(result,candidates,target,[],0)
        return result 
    
    def backtrack(self,result,candidates,target,temp,index):
        
        #e keep decreasing the target with the candidates[i] and when target becomes 0 we add it to the resultant list
        if target<0:
            return
        
        
        if target==0:
            result.append(temp[:])  
            print(result)
            # return
        
        #we are iteratinf through the candidates 
        for i in range(index,len(candidates)):
            # we will add the element only if its lesser than the target. If your element is greater than target then there is no point so you break and go tothe next element
            if target>=candidates[i]:
                temp.append(candidates[i])
                self.backtrack(result,candidates,target-candidates[i],temp,i)
                #if it returns because of some of the base conditions, you pop the last element
                temp.pop()


