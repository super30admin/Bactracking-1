# Time Complexity - O(N * 4^N)
# Space Complexity - O(N)
class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        self.backtrack(num, target, 0, result, "", 0, 0)
        return result
        
    def backtrack(self, num, target, index, result, expression, pre_sum, pre_addition):
        if index >= len(num):
            if target == pre_sum:
                result.append(expression)
        
        for i in range(index, len(num)):
            current = int(num[index:i+1])
            if num[index] == "0" and i != index:
                continue
            if index == 0:
                self.backtrack(num, target, i+1, result, expression + str(current), current, current)
            else:
                # For addition 
                self.backtrack(num, target, i+1, result, expression + "+" + str(current), current + pre_sum, current)
                # For subtraction
                self.backtrack(num, target, i+1, result, expression + "-" +  str(current), pre_sum - current, current * (-1))
                # For multiplication
                self.backtrack(num, target, i+1, result, expression + "*" +  str(current), (pre_sum - pre_addition) + (pre_addition * current), pre_addition * current)
        