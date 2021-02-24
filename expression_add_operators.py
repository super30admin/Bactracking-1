'''
Time complexity: O(n^n)
Space complexity: O(n)
'''
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.output = []
        if num is None or len(num) == 0:
            return self.output
        self.backtracking(num, 0, target, 0, 0, "")
        return self.output
    
    def backtracking(self, num, index, target, prevSum, prevAddition, exp):

        if index >= len(num):
            if prevSum == target:
                self.output.append(exp)
            return
        
        for i in range(index, len(num)):
            currElem = int(num[index: i+1])
            if num[index] == '0' and i != index:
                continue
            if index == 0:
                self.backtracking(num, i + 1, target, currElem, currElem, exp + str(currElem))
            else:
                # +
                self.backtracking(num, i + 1, target, prevSum + currElem, currElem, exp + '+' + str(currElem))
                # -
                self.backtracking(num, i + 1, target, prevSum - currElem, currElem * -1, exp + '-' + str(currElem))
                # *
                self.backtracking(num, i + 1, target, prevSum - prevAddition + prevAddition * currElem, prevAddition * currElem, exp + '*' + str(currElem))