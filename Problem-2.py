import copy
class Solution:

        def backtrack(self, num, temp, tail, currTotal, index):
            if index == len(num):
                if currTotal == self.target:
                    self.result.append(copy.deepcopy("".join(temp)))
                return
            for i in range(index, len(num)):
                if index != i and num[index] == '0':
                    continue
                curr = int(num[index:i+1])
                l = len(str(curr))
                if index == 0:
                    temp.append(str(curr))
                    self.backtrack(num, temp, curr, curr, i+1)
                    temp.pop()
                else:
                    temp.append("+")
                    temp.append(str(curr))
                    self.backtrack(num, temp, curr, currTotal+curr, i+1)
                    temp.pop()
                    temp.pop()
                    temp.append("-")
                    temp.append(str(curr))
                    self.backtrack(num, temp, -curr, currTotal-curr, i+1)
                    temp.pop()
                    temp.pop()
                    temp.append("*")
                    temp.append(str(curr))
                    self.backtrack(num, temp, tail*curr, currTotal-tail+tail*curr, i+1)
                    temp.pop()
                    temp.pop()

        def addOperators(self, num: str, target: int) -> List[str]:
            self.result = []
            self.target = target
            if len(num) == 0 or num is None:
                return self.result
            self.backtrack(num, [], 0, 0, 0)
            return self.result
