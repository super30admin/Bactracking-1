class Solution:
    def __init__(self):
        self.result = []
        self.goal = -1

    """
    Recursive approach
    TC - O(n^2)
    SC - O(n)
    """

    def approach1(self, num: str, index: int, calc: int, tail: int, path: str):
        if index == len(num):
            if calc == self.goal:
                self.result.append(path)
            return
        for i in range(index, len(num)):
            if num[index] == '0' and index != i:
                continue
            curr = int(num[index:i + 1])
            if index == 0:
                self.approach1(num, i + 1, curr, curr, path + str(curr))
            else:
                self.approach1(num, i + 1, calc + curr, curr, path + "+" + str(curr))
                self.approach1(num, i + 1, calc - curr, -curr, path + "-" + str(curr))
                self.approach1(num, i + 1, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))

    def addOperators(self, num: str, target: int) -> List[str]:
        if num == None or len(num) == 0:
            return self.result
        self.goal = target
        self.approach1(num, 0, 0, 0, "")
        return self.result

