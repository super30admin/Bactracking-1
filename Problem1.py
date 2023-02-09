## Time Complexity is exponential i.e.O(n^n)
## Space Complexity : It is the recursive stack space which is O(2^n)
class Solution:
    mainList = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.mainList = []
        self.helper(candidates, 0, target, [])
        return self.mainList

    def helper(self, candidates, index, target, tempArr):
        if target <0 or index == len(candidates):
            return 
        if target == 0:
            self.mainList.append(tempArr.copy())
            return
        # not choose:
        self.helper(candidates, index+1, target, tempArr)

        #choose:
        tempArr.append(candidates[index])
        self.helper(candidates, index, target-candidates[index], tempArr)
        tempArr.pop()

## Iterative recursive without backtracking
class Solution:
    mainList = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.mainList = []
        self.helper(candidates, 0, target, [])
        return self.mainList

    def helper(self, candidates, index, target, tempArr):
        
        if target < 0:
            return
        if target == 0 :
            self.mainList.append(tempArr)
        
        for i in range(index, len(candidates)):
            newList = tempArr.copy()
            newList.append(candidates[i])
            self.helper(candidates, i, target-candidates[i], newList)

## Iterative BackTracking approach : 
class Solution:
    mainList = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.mainList = []
        self.helper(candidates, 0, target, [])
        return self.mainList

    def helper(self, candidates, index, target, tempArr):
        
        if target < 0:
            return
        if target == 0 :
            self.mainList.append(tempArr.copy())
        
        for i in range(index, len(candidates)):
            
            tempArr.append(candidates[i])
            self.helper(candidates, i, target-candidates[i], tempArr)
            tempArr.pop()




sol = Solution()
candidates =[2,3,5]
target =  8
result = sol.combinationSum(candidates, target)
print(result)