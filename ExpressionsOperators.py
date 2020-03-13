'''
Solution:
1.  This can be solved using either recursion or backtracking.
2.  Using recursion, we create a new path list each time we call recursion, once choosing each one of the operators from
    ['+', '-', '*', 'no operation']
3.  Using backtracking, we update the same path list we call backtracking each time and whenever we have to append the result,
    we create a copy of the path list and add.

Time Complexity:    O(4^n) for both the cases
Space Complexity:   O(n x 4^n) for recursion and O(n) for Backtracking

--- Passed all testcases on Leetcode successfully and solved through backtracking
'''

class ExpressionsAndOperators(object):

    def __init__(self):
        self.finalList = []

    def __recursion(self, num, target, calc, tail, path, index):

        #   base case, should complete the entire num string and calculated value should alse be equal to target value
        if (index == len(num)):
            if (calc == target):
                self.finalList.append(''.join(path))
                return

        #   from current index to total length
        for i in range(index, len(num)):

            #   preceding 0 case check
            if (index != i and num[index] == '0'):
                break

            #   consider number from index to i+1
            curr = long(num[index: i + 1])

            #   if index is 0, only one recursive call, else 3 recursive calls
            if (index == 0):
                self.__recursion(num, target, curr, curr, [str(curr)], i + 1)
            else:
                #   case 1 - addition
                path.append('+'); path.append(str(curr))                        #   action
                self.__recursion(num, target, calc + curr, curr, path, i + 1)   #   recursion
                path.pop(); path.pop()                                          #   backtrack

                path.append('-'); path.append(str(curr))                        #   action
                self.__recursion(num, target, calc - curr, -curr, path, i + 1)  #   recursion
                path.pop(); path.pop()                                          #   backtrack

                path.append('*'); path.append(str(curr))                                                   #   action
                self.__recursion(num, target, (calc - tail) + (tail * curr), (tail * curr), path, i + 1)   #   recursion
                path.pop(); path.pop()                                                                     #   backtrack

        return

    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        #   edge case check
        if (num == None or len(num) == 0):
            return self.finalList

        #   main call to the helper function
        self.__recursion(num, target, 0, 0, [], 0)

        #   return the final list
        return self.finalList