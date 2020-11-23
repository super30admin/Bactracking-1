"""
Time Complexity : O(4^n)- as we have 4 paths at every point
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
Here, at every point, we have 4 paths, either we do not use any opertor and concatenate new number to the previous
one, or use +,- or *. At every point in recursion,we are keeping a track of the calculated value and a tail
till then. This is because, in case of multiplication, if we on a wrong path and try to nullify it, we would need
to know what wrong did we do in the previous step.
"""


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.target = target
        if not num:
            return self.result
        self.helper(num, [], 0, 0, 0)
        return self.result

    def helper(self, num, temp, tail, calc, index):
        if index == len(num):
            if calc == self.target:
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
                self.helper(num, temp, curr, calc+curr, i+1)
                temp.pop()
                temp.pop()

                temp.append("-")
                temp.append(str(curr))
                self.helper(num, temp, -curr, calc-curr, i+1)
                temp.pop()
                temp.pop()

                temp.append("*")
                temp.append(str(curr))
                self.helper(num, temp, tail*curr, calc-tail+tail*curr, i+1)
                temp.pop()
                temp.pop()
