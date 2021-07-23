# Time Complexity: O(4^n), where n is the length of the string
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num or len(num) == 0:
            return []

        self.result = []
        self.helper(num, target, [], 0, 0, 0)
        return self.result

    def helper(self, num: str, target: int, path: List[str], calc: int, tail: int, index: int) -> None:
        # base
        if index == len(num):
            if target == calc:
                self.result.append("".join(path))
            return

        # logic
        for i in range(index, len(num)):
            curr = int(num[index:i + 1])

            # To ignore 0 before the number
            if index != i and num[index] == "0":
                continue

            if index == 0:
                path.append(str(curr))
                self.helper(num, target, path, curr, curr, i + 1)
                path.pop()

            else:
                # add
                path.append("+")
                path.append(str(curr))
                self.helper(num, target, path, calc + curr, curr, i + 1)
                path.pop()
                path.pop()

                # subtract
                path.append("-")
                path.append(str(curr))
                self.helper(num, target, path, calc - curr, -curr, i + 1)
                path.pop()
                path.pop()

                # multiply
                path.append("*")
                path.append(str(curr))
                self.helper(num, target, path, calc - tail + tail * curr, tail * curr, i + 1)
                path.pop()
                path.pop()