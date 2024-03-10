'''
TC: O(L*3^L) where L is the length of the word
SC: O(L) since we are going through the stack for length of string
'''
from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res = []

        def backtrack(pivot, path, calc, tail):
            #base
            if pivot == len(num):
                if calc == target:
                    self.res.append(path)
                    return

            #logic
            for i in range(pivot, len(num)):
                if num[pivot]=='0' and i!=pivot:
                    break
                curr = int(num[pivot:i+1])
                if pivot==0:
                    backtrack(i+1, path+str(curr), calc+curr, tail+curr)
                else:
                    #'+'
                    backtrack(i+1, path+'+'+str(curr), calc+curr, curr)

                    #'-'
                    backtrack(i+1, path+'-'+str(curr), calc-curr, -curr)

                    #'*'
                    backtrack(i+1, path+'*'+str(curr), calc-tail+tail*curr, tail*curr)


        backtrack(0,"",0,0)
        return self.res
s = Solution()
print(s.addOperators("123", 6))
print(s.addOperators("232", 8))
print(s.addOperators("3456237490", 9191))
print(s.addOperators("105", 5))