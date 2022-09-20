class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result=[]
        
        if len(candidates)==0 or candidates==None:
            return result
        
        def dfs(i,curr,total):
            
            #base case
            if total==target:
                #adding the copy of current in the result array
                #So that we dont change the original current
                result.append(curr.copy())
                return
            
            #If total becomes big or we go over all the candidates
            if total>target or i>=len(candidates):
                return
            
            #Logic
            #If the element is added
            curr.append(candidates[i])
            #Curr is passed with the added element and it is added to the total
            dfs(i,curr,total+candidates[i])
            
            #If the elemnt is not added
            # pop the lement which is added
            curr.pop()
            #We move to the next elemnt and curr and total remains the same
            dfs(i+1,curr,total)
            
        
        dfs(0,[],0)
        return result