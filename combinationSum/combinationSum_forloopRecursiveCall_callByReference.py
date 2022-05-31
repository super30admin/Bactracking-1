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
            
            # append to the pairList
            pairList.append(candidates[i])
            
            # Test the result
            # print('Pair List are:\t',pairList)
            
            # recursicve call
            self.forLoopRecursion(candidates,target-candidates[i],i,pairList)
            
            # remove from the pairList
            pairList.pop()
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.forLoopRecursion(candidates,target,0,[])
        # print(self.resultList)
        return self.resultList