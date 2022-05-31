'''
Time Complexity : 0(2^n) -- two possibilites i.e. choose and not choose

Space Complexity: recursion stack i.e 0(n)

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
            # Append the copy of pairList
            cpy_pairList = pairList[:]
            self.resultList.append(cpy_pairList)
            return 
        
        elif target < 0 or index >= len(candidates):
            # My target is -ve, go back to the parent
            # Index is out of bounds
            return
        
        # Case 2: logic-case
        
        # choose
        pairList.append(candidates[index])
        self.chooseNotChoose(candidates,target-candidates[index],index,pairList)
        
        # not choose
        pairList.pop()
        self.chooseNotChoose(candidates,target,index+1,pairList)
        
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.chooseNotChoose(candidates,target,0,[])
        
        # print(self.resultList)
        return self.resultList