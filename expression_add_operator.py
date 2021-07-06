# Time Complexity: O(4^n)
# Space Complexity:O(n)
#  calling backtrack function where we will be mainating the path, tail and calculated value and we will update it based on possibilities as + - and *
class Solution(object):
    result = []

    def backtracking(self, num, target, index, path, tail, calv):
        #         Base Case
        if index == len(num):
            if calv == target:
                self.result.append(path)
                return

        # Logic
        for i in range(index, len(num)):
            if num[index] == '0' and index != i:
                continue
            curr = long(num[index:i + 1])
            length_current_path = len(path)

            if index == 0:
                self.backtracking(num, target, i + 1, path + str(curr), curr, curr)
            else:
                self.backtracking(num, target, i + 1, path + "+" + str(curr), curr, calv + curr)
                self.backtracking(num, target, i + 1, path + "-" + str(curr), -curr, calv - curr)
                self.backtracking(num, target, i + 1, path + "*" + str(curr), tail * curr, calv - tail + tail * curr)

    def addOperators(self, num, target):
        self.result = []
        self.backtracking(num, target, 0, "", 0, 0)
        return self.result
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
