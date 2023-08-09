class Solution:
    # Time Complexity: O(3^n)
    # Space Complexity: O(3^n)
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num, target, 0, 0, 0, "")
        return self.result

    def helper(self, num, target, pivot, calc, tail, path):
        if pivot == len(num):
            if target == calc:
                self.result.append(path)

        for i in range(pivot, len(num)):
            if num[pivot] == "0" and i != pivot:
                break
            curr = int(num[pivot : i + 1])
            if pivot == 0:
                self.helper(num, target, i + 1, curr, curr, path + str(curr))
            else:
                self.helper(
                    num, target, i + 1, calc + curr, curr, path + "+" + str(curr)
                )
                self.helper(
                    num, target, i + 1, calc - curr, -curr, path + "-" + str(curr)
                )
                self.helper(
                    num,
                    target,
                    i + 1,
                    calc - tail + tail * curr,
                    tail * curr,
                    path + "*" + str(curr),
                )
