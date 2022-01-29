class Solution:
    def __init__(self):
        self.res = list()
        
    def helper(self, num, idx, target, calc, tail, path):
        if idx >= len(num):
            if calc == target:
                self.res.append(path)
            return
        
        for i in range(idx, len(num)):
            if i != idx and num[idx] == '0':
                continue
            curr = int(num[idx:i+1])
            if idx == 0:
                self.helper(num, i + 1, target, curr, curr, path + str(curr))
            else:
                # +
                self.helper(num, i + 1, target, calc + curr, curr, path + "+" + str(curr))
                # -
                self.helper(num, i + 1, target, calc - curr, -1 * curr, path + "-" + str(curr))
                # *
                self.helper(num, i + 1, target, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))
        
    
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num:
            return self.res
        
        self.helper(num, 0, target, 0, 0, "")
        
        return self.res
        
        
        