'''
Solution:
1.  This can be solved using either recursion or backtracking.
2.  Using recursion, we create a new list each time we call recursion, once choosing the element and once not choosing
    the element.
3.  Using backtracking, we update the same list we call backtracking each time and whenever we have to append the result,
    we create a copy of the list and add.

Time Complexity:    O(2^n) for both the cases
Space Complexity:   O(n x 2^n) for recursion and O(n) for Backtracking

--- Passed all testcases on Leetcode successfully
'''

class CombinationSum_Recursion(object):

    def __init__(self):
        self.finalList = []

    def __recursionHelper(self, candidates, target, idx, currSum, tempList):

        #   base case 1
        if (target == currSum):
            self.finalList.append(tempList)
            return

        #   base case 2
        if (idx >= len(candidates) or currSum > target):
            return

        #   don't choose the element
        self.__recursionHelper(candidates, target, idx + 1, currSum, list(tempList))

        #   choose the element
        tempList.append(candidates[idx])
        self.__recursionHelper(candidates, target, idx, currSum + candidates[idx], list(tempList))

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        #   edge case check
        if (candidates == None or len(candidates) == 0):
            return self.finalList

        #   main call to the helper function
        self.__recursionHelper(candidates, target, 0, 0, list())

        #   return the final list
        return self.finalList


class CombinationSum_Backtracking(object):

    def __init__(self):
        self.finalList = []
        self.tempList = []

    def __backtrack(self, candidates, target, currentIndex, currentSum):

        #   base case 1
        if (currentSum == target):
            self.finalList.append(list(self.tempList))
            return
        #   base case 2
        if (currentSum > target):
            return

        #   from current index to total length
        for idx in range(currentIndex, len(candidates)):

            #   action -- appending the current element to the list
            self.tempList.append(candidates[idx])

            #   recursion -- check whether the updated list has target sum
            self.__backtrack(candidates, target, idx, currentSum + candidates[idx])

            #   backtrack -- removing the current element from the list
            self.tempList.pop()

    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        #   edge case check
        if (candidates == None or len(candidates) == 0):
            return self.finalList

        #   main call to the helper function
        self.__backtrack(candidates, target, 0, 0)

        #   return the final list
        return self.finalList