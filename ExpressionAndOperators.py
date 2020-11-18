#Time Complexity : O(4^n) where n is the length of input string
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Three line explanation of solution in plain english:

class Solution:
    def helper(self, num, temp, tail, currTotal, index):
        if index == len(num):
            if currTotal == self.target:
                self.result.append(copy.deepcopy("".join(temp)))
            return

        for i in range(index, len(num)):
            if index != i and num[index] == '0':
                continue

            curr = int(num[index:i+1])

            if index == 0:
                temp.append(str(curr))
                self.helper(num, temp, curr, curr, i+1)
                temp.pop()
            else:
                temp.append("+")
                temp.append(str(curr))
                self.helper(num, temp, curr, currTotal+curr, i+1)
                temp.pop()
                temp.pop()

                temp.append("-")
                temp.append(str(curr))
                self.helper(num, temp, -curr, currTotal-curr, i+1)
                temp.pop()
                temp.pop()

                temp.append("*")
                temp.append(str(curr))
                self.helper(num, temp, tail*curr, currTotal-tail+tail*curr, i+1)
                temp.pop()
                temp.pop()

    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.target = target

        if len(num) == 0 or num is None:
            return self.result

        self.helper(num, [], 0, 0, 0)
        return self.result
