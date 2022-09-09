# TC : O(4^n) 
# SC : O(n)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.n = len(num)
        self.target = target
        self.num = num
        self.result = []
        self.backtrack(0,0,0,0,"")
        return self.result
    
    
    def backtrack(self,idx, prev,curr,value,s):
        #base
        if idx == self.n:
            if value == self.target and curr == 0:
                self.result.append(s)
            return

        #logic
        curr = curr * 10 + int(self.num[idx])

        if curr > 0:
            self.backtrack(idx+1, prev,curr,value,s)

        if not s:
            self.backtrack(idx+1, curr, 0, value+curr, str(curr))
        else:
            self.backtrack(idx+1, curr, 0, value+curr, s+"+"+str(curr))
            self.backtrack(idx+1, -curr, 0, value-curr, s+"-"+str(curr))
            self.backtrack(idx+1, prev*curr, 0, value-prev+prev*curr, s+"*"+str(curr))