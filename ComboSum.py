#TC: O(2^n)
#SC: O(n x 2^n) -> Recursion
#    O(n) -> Backtracking

class Solution(object):

    def __init__(self):
        self.finalList = []

    def __recursionHelper(self, candidates, target, idx, currSum, tempList):

        if (target == currSum):
            self.finalList.append(tempList)
            return

        if (idx >= len(candidates) or currSum > target):
            return

        self.__recursionHelper(candidates, target, idx + 1, currSum, list(tempList))

        tempList.append(candidates[idx])
        self.__recursionHelper(candidates, target, idx, currSum + candidates[idx], list(tempList))

    def combinationSum(self, candidates, target):
    
        if (candidates == None or len(candidates) == 0):
            return self.finalList

        self.__recursionHelper(candidates, target, 0, 0, list())

        return self.finalList


class CombinationSum_Backtracking(object):

    def __init__(self):
        self.finalList = []
        self.tempList = []

    def __backtrack(self, candidates, target, currentIndex, currentSum):

        if (currentSum == target):
            self.finalList.append(list(self.tempList))
            return
        if (currentSum > target):
            return

        for idx in range(currentIndex, len(candidates)):

            self.tempList.append(candidates[idx])

            self.__backtrack(candidates, target, idx, currentSum + candidates[idx])

            self.tempList.pop()

    def combinationSum(self, candidates, target):
        
        if (candidates == None or len(candidates) == 0):
            return self.finalList

        self.__backtrack(candidates, target, 0, 0)

        return self.finalList