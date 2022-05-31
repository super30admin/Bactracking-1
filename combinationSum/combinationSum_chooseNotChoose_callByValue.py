'''
Time Complexity : 0(x) -- copy the pair list
                  0(2^n) -- two possibilites i.e. choose and not choose

Space Complexity: (2^n) * (2* 0(x)) -- copy the pairList, 
                                       call by value for choose and not choose
                                       2^n for going exhaustive
                  0(n) -- recursion stack
Run on LeetCode: Yes
Issues Faced: No
'''
# approach choose - not choose approach and go exhaustive 
# call by value approach
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def chooseNotChoose(self,candidates,target,index,pairList):
        
        # Case 1: base-case
        if target == 0:
            # I have my pairList
            self.resultList.append(pairList)
            return 
        
        elif target < 0 or index >= len(candidates):
            # My target is -ve, go back to the parent
            # Index is out of bounds
            return
        
        # Case 2: logic-case
        
        # choose
        pairList.append(candidates[index])
        cpy_pairList = pairList[:]
        self.chooseNotChoose(candidates,target-candidates[index],index,cpy_pairList)
        
        # not choose
        pairList.pop()
        cpy_pairList = pairList[:]
        self.chooseNotChoose(candidates,target,index+1,cpy_pairList)
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.chooseNotChoose(candidates,target,0,[])
        
        # print(self.resultList)
        return self.resultList