#TC: I am confused while calculating the time complexity of this solution. Can you help me with it. I think it should be O(N)
#SC: O(N) .  I think I might be wrong

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        results=[]
        
        
        def backtrack(remain,list1,start):
            if remain==0:
                results.append(list1.copy())
                return
            elif remain<0:
                return
            
            
            for i in range(start,len(candidates)):
                list1.append(candidates[i])
                
                backtrack(remain-candidates[i],list1,i)
                
                list1.pop()
        
        
        
        
        
        backtrack(target,[],0)
        return results