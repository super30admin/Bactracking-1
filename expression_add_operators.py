# Time Complexity: O(2^n) where n is the length of the str
# Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num, target, 0, 0, "", 0)
        return self.result
    
    def helper(self, num, target, calc, tail, path, index):
        #base
        if index == len(num):
            if calc == target:
                print(calc, target)
                self.result.append(str(path))
                return
        for i in range(index, len(num)):
            if i != index and num[index] == "0":
                    continue
            curr = int(num[index:i+1])
            if index == 0:
                self.helper(num, target,  curr, curr, path + str(curr), i+1)
            else:
                self.helper(num, target, calc + curr, curr, path + "+" + str(curr), i+1)
                self.helper(num, target, calc - curr, -curr, path + "-" + str(curr), i+1)
                self.helper(num, target, calc - tail + (curr * tail), tail*curr, path + "*" + str(curr), i+1)
