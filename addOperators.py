class Solution:
    def addOperators(self, num: str, target: int):
        self.result = []
        def helper(index, calc, tail, path):
            if index == len(num):
                if calc == target:
                    self.result.append(path)
            
            for i in range(index,len(num)):
                if num[index] == "0" and i != index:
                    continue
                curr = int(num[index:i+1])
                if index == 0:
                    helper(i+1, curr, curr, path + str(curr))
                else:
                    helper(i+1, calc+curr, +curr, path + "+" + str(curr))
                    helper(i+1, calc-curr, -curr, path + "-" + str(curr))
                    helper(i+1, calc-tail+tail*curr, tail*curr, path + "*" + str(curr))
        
        helper(0,0,0,"")
        return self.result
    
#TC: O(3^n)