# NOT SURE ABOUT TIME COMPLEXITY
class Solution:
    def combinationSum(self, candidates, target):
        return self.findCombinations(candidates,0,0,target,[],[])
    
    def findCombinations(self,candidates,index,currentSum,target,currentCombination,output):
        if index >= len(candidates) or currentSum > target:
            return output
        if currentSum == target:
            output.append(currentCombination[:])
        
        for i in range(index,len(candidates)):
            currentCombination.append(candidates[i])
            self.findCombinations(candidates,i,currentSum + candidates[i],target,currentCombination,output)
            currentCombination.pop()
        return output