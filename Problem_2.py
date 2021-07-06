class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if num == None or len(num) == 0:
            return self.result
        self.helper(num, target, 0, 0, 0, "")
        return self.result
    
    def helper(self, num: str, target: int, index: int, cal: int, tail: int, path: str) -> None:
        # base
        if index == len(num):
            if cal == target:
                self.result.append(path)
            return
        
        for i in range(index, len(num)):
            
            if num[index] == '0' and index != i:
                continue
            curr = int(num[index: i+1])
            if index == 0:
                self.helper(num, target, i + 1, curr, curr, path + str(curr))
            else:
                self.helper(num, target, i + 1, cal + curr, curr, path + '+' + str(curr))
                self.helper(num, target, i + 1, cal - curr, -curr, path + '-' + str(curr))
                self.helper(num, target, i + 1, cal - tail + (tail * curr), tail * curr, path + '*' + str(curr))




# Backtracking Solution
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if num == None or len(num) == 0:
            return self.result
        self.helper(num, target, 0, 0, 0, [])
        return self.result
    
    def helper(self, num: str, target: int, index: int, cal: int, tail: int, path: List[str]) -> None:
        # base
        if index == len(num):
            if cal == target:
                self.result.append(''.join(path))
            return
        
        for i in range(index, len(num)): 
            if num[index] == '0' and index != i:
                break
            curr = int(num[index: i+1])
            l = len(path)
            if index == 0:
                path.append(str(curr))
                self.helper(num, target, i + 1, curr, curr, path)
                path.pop()
            else:
                
                path.append('+')
                path.append(str(curr))
                self.helper(num, target, i + 1, cal + curr, curr, path)
                path.pop()
                path.pop()
                
                path.append('-')
                path.append(str(curr))
                self.helper(num, target, i + 1, cal - curr, -curr, path)
                path.pop()
                path.pop()
                
                path.append('*')
                path.append(str(curr))
                self.helper(num, target, i + 1, cal - tail + (tail * curr), tail * curr, path)
                path.pop()
                path.pop()


# Time Complexity : Exponential