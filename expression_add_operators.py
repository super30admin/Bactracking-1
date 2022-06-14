# Time Complexity : O(2 ^ (3 * N)) where is N is number of elements and we have operations addition, substraction, multiplication
# Space Complexity : O(N) where N is number of elements
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def addOperators(self, num: str, target: int) -> List[str]:
        self.expressionBuilder(num, target, 0, 0, 0, [])
        
        return self.result
    
    def expressionBuilder(self, num, target, cal, tail, index, path):
        #base
        if index == len(num):
            if target == cal:
                self.result.append("".join(path[:]))
            return
        #logic
        for i in range(index, len(num)):
            if index != i and num[index] == '0': 
                continue
            curr = int(num[index: i+1])
            if index == 0:
                path.append(str(curr))
                self.expressionBuilder(num, target, curr, curr, i + 1, path)
                path.pop()
            else:
                #addition
                path.append('+')
                path.append(str(curr))
                self.expressionBuilder(num, target, cal + curr, curr, i + 1, path)
                path.pop()
                path.pop()
                #substraction
                path.append('-')
                path.append(str(curr))
                self.expressionBuilder(num, target, cal - curr, -curr, i + 1, path)
                path.pop()
                path.pop()
                #multiplication
                path.append('*')
                path.append(str(curr))
                self.expressionBuilder(num, target, cal - tail + tail * curr, tail * curr, i + 1, path)
                path.pop()
                path.pop()