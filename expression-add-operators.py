class Solution:
    # Declare the result globally to return 
    def __init__(self):
        self.result = []
        
    def helper(self, num, target, pivot, calc, tail, path):
        # Base Case
        if pivot == len(num):
            if target == calc:
                self.result.append(path)
                return
        
        # Logic
        for i in range(pivot, len(num)):
            # Preceeding zero
            if num[pivot] == '0' and pivot != i:
                continue
            # Obtaining the substring at every point
            curr = int(num[pivot:i+1])
            
            # If pivot is zero, just add to path
            if pivot == 0:
                self.helper(num, target, i + 1, curr, curr, path + str(curr))
            else:
                # +
                self.helper(num, target, i + 1, calc + curr, curr, path + "+" + str(curr))
                # -
                self.helper(num, target, i + 1, calc - curr, -curr, path + "-" + str(curr))
                # *
                self.helper(num, target, i + 1, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))
        
        
    def addOperators(self, num: str, target: int) -> List[str]:
        # Null condition check
        if num == None or len(num) == 0:
            return self.result
        
        self.helper(num, target, 0, 0 , 0, "")
        return self.result