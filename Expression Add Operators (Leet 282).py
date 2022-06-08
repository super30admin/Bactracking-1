# Time Complexity: Exponential

# using recursion (python strings so no bactracking)
class Solution:
    res = list()
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res = list()
        self.helper(num, target, 0, 0, '', 0)
        return self.res
    
    def helper(self, num, target, calc, tail, path, index):
        # Base
        if index == len(num):
            if calc == target:
                self.res.append(path)
            return
        
        # Logic
        for i in range(index, len(num)):
            
            curr = int(num[index:i+1])
            
            if str(num)[index] == '0' and index != i:
                continue
            
            # preceeding zero
            if index == 0:
                self.helper(num, target, curr, curr, path + str(curr), i+1)
            else:
                
                self.helper(num, target, calc+curr, curr, path + '+' + str(curr), i + 1)
                self.helper(num, target, calc-curr, -curr, path + '-' + str(curr), i + 1)
                self.helper(num, target, calc-tail+(tail*curr), tail*curr, path + '*' + str(curr), i + 1)