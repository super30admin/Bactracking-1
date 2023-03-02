"""
Rasika Sasturkar
Time Complexity: O(n*(3)^l), l is length of input string.
Space Complexity: O(l)
"""


class Solution:
    """
    Logic is to use for-loop recursion to generate combinations of value strings between
    which operators can be inserted. We also kept track of calculated value and tail value
    which can be used in next iterations.
    """
    result = []

    def addOperators(self, num: str, target: int):
        self.result = []
        self.helper(num, 0, target, [], 0, 0)
        return self.result

    def helper(self, num, pivot, target, path, calculated_val, tail_val):
        # base case
        if pivot == len(num):
            if calculated_val == target:
                self.result.append("".join(path))

        # logic - for loop recursion
        for i in range(pivot, len(num)):
            # preceding 0
            if num[pivot] == "0" and i != pivot:
                continue
            length = len(path)
            curr = int(num[pivot:i + 1])
            # need to handle first level separation (no operators)
            if pivot == 0:
                path.append(str(curr))  # action
                self.helper(num, i + 1, target, path, curr, curr)  # recurse
                path = path[:length]  # backtrack
            else:
                # case +
                path.append("+")  # action
                path.append(str(curr))
                self.helper(num, i + 1, target, path, calculated_val + curr, +curr)  # recurse
                path = path[:length]  # backtrack
                # case -
                path.append("-")  # action
                path.append(str(curr))
                self.helper(num, i + 1, target, path, calculated_val - curr, -curr)  # recurse
                path = path[:length]  # backtrack
                # case *
                path.append("*")  # action
                path.append(str(curr))
                self.helper(num, i + 1, target, path, calculated_val - tail_val + tail_val * curr,
                            tail_val * curr)  # recurse
                path = path[:length]  # backtrack


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    s = Solution()
    print(s.addOperators(num="123", target=6))  # return ['1+2+3', '1*2*3']
    print(s.addOperators(num="232", target=8))  # return ['2+3*2', '2*3+2']
    print(s.addOperators(num="3456237490", target=9191))  # return []


if __name__ == "__main__":
    main()
