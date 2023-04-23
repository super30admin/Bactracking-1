# Time Complexity: 
# Space Complexity:
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
This problem is solved using backtracking. We use a helper function to recursively call itself with an index. 
We of course use the different calls to meet the +, -, * operations. The for loop takes care of the possibility of 
having taking multiple numbers within one term. And the first if condition after the for loop stops the code from 
taking terms that start with a 0. There is also a problem of not adhering to BODMAS rules, so we use the tail variable 
to be able to remove the tail before we multiply and then add it back in.
"""

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if num == None or len(num) == 0: return []

        self.answer = []
        self.helper(num, target, 0 ,0 ,0, '')

        return self.answer

    def helper(self, num, target, calc, tail, index, path):
        #base
        if index == len(num):
            if calc == target:
                self.answer.append(path)
            
            return 

        #logic
        for i in range(index, len(num)):
            if index != i and num[index] == '0':
                continue
            curr = int(num[index: i+1])

            if index == 0:
                self.helper(num, target, curr, curr, i+1, path + str(curr))
            else:
                #recursive call for + 
                self.helper(num, target, calc + curr, +curr, i + 1, path + "+" + str(curr))
                # recursive call for -
                self.helper(num, target, calc - curr, -curr, i + 1, path + "-" + str(curr))
                # recursive call for *
                self.helper(num, target, calc - tail + tail * curr, tail * curr, i + 1, path + "*" + str(curr))