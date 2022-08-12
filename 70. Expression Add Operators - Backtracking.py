# Backtracking
class Solution:
    result = []

    def addOperators(self, num: str, target: int):
        self.result = []
        self.helper(num, target, 0, 0, 0, path=[])
        return print("Output:", self.result)

    def helper(self, num, target, index, calc, tail, path):
        if index == len(num):
            if calc == target:
                print(path)
                self.result.append("".join(map(str, path)))
            return

        for i in range(index, len(num)):
            if i != index and num[index] == "0":
                continue
            curr = int(num[index: i + 1])
            le = len(path)

            if index == 0:
                path.append(curr)
                self.helper(num, target, i + 1, curr, curr, [curr])
                del path[le:]
            else:
                # '+'
                path.append("+")  # action
                path.append(curr)  # action
                self.helper(num, target, i + 1, calc + curr, curr, path)  # recurse
                del path[le:]  # backtrack

                # "-"
                path.append("-")  # action
                path.append(curr)  # action
                self.helper(num, target, i + 1, calc - curr, -curr, path)  # recurse
                del path[le:]  # backtrack

                # "*"
                path.append("*")  # action
                path.append(curr)  # action
                self.helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path)  # recurse
                del path[le:]  # backtrack

if __name__ == "__main__":
    obj = Solution()
    obj.addOperators("105", 5)

# Time Complexity = O(4^n).
# Space complexity : O(4^n).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
