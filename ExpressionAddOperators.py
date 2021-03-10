# TC: O(4^N)
# SC: O(N)
# LeetCode: Y(https://leetcode.com/problems/expression-add-operators/)
# Approach: Consider 4 cases
#           no operation: concatenate operators
#           + add path, update calc
#           - subtract path, update calc
#           * undo last operation and perform multiplication on tail and current

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        self.result = []
        
        self.helper(num, target, [], 0, 0, 0)
        
        return self.result
    
    def helper(self, num, target, path, calc, tail, currentIndex):
        
        # if entire num string is traversed 
        if currentIndex == len(num):
            # if calculated value equals target then a required expression is found
            if calc == target:
                self.result.append("".join(path))
            return
        
        for i in range(currentIndex, len(num)):
            # ignore the case of leading zeros
            if num[currentIndex] == '0' and i > currentIndex:
                continue
            
            # keep the operands togther perform no operation
            current = int(num[currentIndex: i + 1])
            
           
            
            # start exhaustive search
            if currentIndex == 0:
                path.append(str(current))
                self.helper(num, target, path, current, current, i + 1)
                path.pop()
            else:
                # case: +
                path.append('+') 
                path.append(str(current))
                self.helper(num, target, path , calc + current, current, i + 1)
                path.pop()
                path.pop()
                
                # case -
                path.append('-') 
                path.append(str(current))
                self.helper(num, target, path , calc - current, -current, i + 1)
                path.pop()
                path.pop()
                
                # case *
                path.append('*') 
                path.append(str(current))
                self.helper(num, target, path, calc - tail + tail * current, tail * current, i + 1)
                path.pop()
                path.pop()
        
