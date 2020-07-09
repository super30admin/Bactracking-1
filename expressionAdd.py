# Time Complexity : O(3^n), where n is the length of the num array.
# Space Complexity : O(3^n), because a new string is created with each recursive call.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This is recursive approach, where all possible paths are explored.
# For any path, when finished exploring, if it's computation is equal
# to the target, it is added to the result. Otherwise discarded.
class Solution(object):
    def __init__(self):
        self.retVal = []
        self.num = None
        self.target = None
        self.n = None

    def addOperatorsRecursive(self, num, target):
        if not num:
            return self.retVal
        self.num, self.target, self.n = num, target, len(num)
        self.helper("", 0, 0, 0)
        return self.retVal

    def helper(self, path, calc, tail, idx):
        # base case
        if idx == self.n:
            if calc == self.target:
                self.retVal.append(path)
            return
        # logic
        for i in range(idx, self.n):
            # preceding zero # case 05 = 5
            if self.num[idx] == '0' and idx != i:
                break
            curr = int(self.num[idx:i + 1])
            # recursive call for first number
            if idx == 0:
                self.helper(path + str(curr), calc + curr, curr, i + 1)
            else:
                # Addition (+)
                self.helper(path + "+" + str(curr), calc + curr, curr, i + 1)
                # Subtraction (-)
                self.helper(path + "-" + str(curr), calc - curr, curr * -1, i + 1)
                # Multiplication (x)
                self.helper(path + "*" + str(curr), calc - tail + tail * curr, tail * curr, i + 1)

#------------------------------------------------------x---------------------------------------------------------------#

# Time Complexity : O(3^n), where n is the length of the num array.
# Space Complexity : O(n), where n is the length of the num array, only one string used throughout.
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This approach uses backtracking where every possible solution is added
# and removed after consideration to be a included in the result.
class Solution(object):
    def __init__(self):
        self.retVal = []
        self.num = None
        self.target = None
        self.n = None

    def addOperatorsBacktracking(self, num, target):
        if not num:
            return self.retVal
        self.num, self.target, self.n = num, target, len(num)
        self.backtrack([], 0, 0, 0)
        return self.retVal

    def backtrack(self, path, calc, tail, idx):
        # base case
        if idx == self.n:
            if calc == self.target:
                self.retVal.append("".join(path))
            return
        # logic
        for i in range(idx, self.n):
            # preceding zero # case 05 = 5
            if self.num[idx] == '0' and idx != i:
                break
            curr = int(self.num[idx:i + 1])
            # recursive call for fist number
            if idx == 0:
                path.append(str(curr))
                self.backtrack(path, calc + curr, curr, i + 1)
                path.pop()
            else:
                # Addition (+)
                path.append("+")
                path.append(str(curr))
                self.backtrack(path, calc + curr, curr, i + 1)
                path.pop()
                path.pop()

                # Subtraction (-)
                path.append("-")
                path.append(str(curr))
                self.backtrack(path, calc - curr, curr * -1, i + 1)
                path.pop()
                path.pop()

                # Multiplication (x)
                path.append("*")
                path.append(str(curr))
                self.backtrack(path, calc - tail + tail * curr, tail * curr, i + 1)
                path.pop()
                path.pop()
