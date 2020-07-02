"""
// Time Complexity : o(4^n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
class Solution:
    def helper(self, num, path, calc, tail, idx):
        #base
        if idx == len(num):
            if calc == self.targ:
                self.res.append(path)
            return
        
        #logic
        
        for i in range(idx, len(num)):
            if num[idx] == '0' and idx != i: #handling leading zeroes
                break
            curr = int(num[idx:i+1])
            
            if idx == 0:
                self.helper(num, path + str(curr), curr, curr,i + 1) #the no operator case
                
            else:
                self.helper(num, path + "+" + str(curr), calc + curr, curr, i + 1) # + case
                self.helper(num, path + "-" + str(curr), calc - curr, -curr, i + 1) # - case
                self.helper(num, path + "*" + str(curr), calc - tail + tail * curr, tail * curr, i + 1) # * case, undo the previous operation so as to maintain the precedence of multiplication
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res = []
        self.targ = target
        
        if not num:
            return self.res
        
        self.helper(num, "", 0,0,0)
        
        return self.res