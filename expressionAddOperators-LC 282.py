# Time Complexity = exponential, (or 4^n), 4 choices depending upon the length of the string


# For loop based Recursion
class Solution:
    def addOperators(self, num: str, target: int) -> list[str]:
        if num == None:
            return []
        
        self.result = []
        
        self.helper(num, target, 0, "", 0, 0)
        
        
        return self.result
    
    
    def helper(self, num, target, index, exprsn, calc, tail):
        # Base Case
        if index == len(num):
            if calc == target:
                self.result.append(exprsn)
                
            return
        
        a = "+"
        s = "-"
        m = "*"
        
        
        # Logic
        for i in range(index, len(num)):
            
            # Handling the leading zero case, eg - 105, targhet = 5
            if index != i and num[index] == '0':
                continue
            
            curr = num[index: i + 1]
            
            # int values
            currI = int(curr)
            calcI = int(calc)
            tailI = int(tail)
            
            
            if index == 0:
                self.helper(num, target, i + 1, exprsn + curr, currI, currI)
                
                
            else:
                # + Case
                self.helper(num, target, i + 1, exprsn + a + curr, calcI + currI, currI)
                
                # - Case
                self.helper(num, target, i + 1, exprsn + s + curr, calcI - currI, -currI)
                
                # * Case
                self.helper(num, target, i + 1, exprsn + m + curr, (calcI - tailI) + (tailI * currI), tailI * currI)