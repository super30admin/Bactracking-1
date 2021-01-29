# Time Complexity :
# Space Complexity :
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res = []
        self.target = target
        if not num:
            return self.res
        self.helper(num, "", 0, 0, 0)
        return self.res

    def helper(self, num, path, calc, tail, index):
        #base
        if index == len(num):
            if calc == self.target:
                self.res.append(path)
            return

        #logic
        for i in range(index, len(num)):
            #Skip leading zero number

            if index != i and num[index] == '0':
                continue
            current = int(num[index:i + 1])
            #placeholder preceeding 0 at root
            if index == 0:
                #First num, pick it without adding any operator
                self.helper(num, path + str(current), calc + current, current,
                            i + 1)
            else:
                self.helper(num, path + "+" + str(current), calc + current,
                            current, i + 1)
                self.helper(num, path + "-" + str(current), calc - current,
                            -current, i + 1)
                self.helper(num, path + "*" + str(current),
                            calc - tail + tail * current, tail * current,
                            i + 1)  # Can imagine with example: 1+2*3*4
