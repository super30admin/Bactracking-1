#Time complexity: O(4^n)
#Space complexity: O(h)

#Accepted on Leetcode

#Approach:
#Use for loop based recursion to test each possibility -> +, -, * and maintaining a sum (backtrack to test other possbilities) Handle edge cases for '*' by using a tail variable
#Handle edge case where current string starts with 0 and length > 1 by ignoring such strings
#Whenever iteration completed over entire path, compare currentSum with target and append if they match

class Solution:
    result = []
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []

        self.recurse(num, target, 0, 0, 0, [])
        
        return self.result

    def recurse(self, numStr, target, index, calc, tail, path):
        #base
        if index == len(numStr):
            if calc == target:
                self.result.append(''.join(path))

        #logic
        for i in range(index, len(numStr)):
            if index != i and numStr[index] == '0':
                continue
            cur = numStr[index : i + 1]
            curVal = int(cur)
            if index == 0:
                path.append(cur)
                self.recurse(numStr, target, i+1, curVal, curVal, path)
                path.pop()
            else:
                #add
                path.append('+')
                path.append(cur)
                self.recurse(numStr, target, i+1, calc + curVal, curVal, path)
                path.pop()
                path.pop()
                #subtract
                path.append('-')
                path.append(cur)
                self.recurse(numStr, target, i+1, calc - curVal, -curVal, path)
                path.pop()
                path.pop()
                #multiply
                path.append('*')
                path.append(cur)
                self.recurse(numStr, target, i+1, (calc-tail) + (tail*curVal), curVal*tail, path)
                path.pop()
                path.pop()
