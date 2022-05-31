'''
Time Complexity : 0(2^n) -- two possibilites i.e. choose and not choose

Space Complexity:   creating a new list 0(x)
                    recursion stack i.e 0(n)

Run on LeetCode: Yes
Issues Faced: No
'''
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def forLoopRecursion(self,candidates,target,pivot,pairList):
        
        # base-case
        if target < 0:
            return 
        
        if target == 0:
            cp_pairList = pairList[:]
            self.resultList.append(cp_pairList)
            return
        
        # logic-case
        for i in range(pivot,len(candidates)):
            
            # create a copy of pairList and then append
            pairList_cpy = pairList[:]
            pairList_cpy.append(candidates[i])
            
            # recursicve call, call by value
            self.forLoopRecursion(candidates,target-candidates[i],i,pairList_cpy)
            
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.forLoopRecursion(candidates,target,0,[])
        # print(self.resultList)
        return self.resultList