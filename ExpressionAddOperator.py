# TC: O(4 ^ N) where N is the number of operators + 1. Since for every operand, we will be exploring 4 options. 
# SC: O(N) + O(H) where N is the length of the substring we create and H is the height of the recursive tree. 

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num or len(num) == 0:
            return 
        
        self.result = []
        
        def helper(index, calc, tail, path):
            if index == len(num) and target == calc:
                self.result.append(path)
                return
            
            for i in range(index + 1, len(num) + 1):
                curr_str = num[index:i]
                curr = int(curr_str)
                if num[index] == '0' and curr_str != '0':
                    continue
                
                if index == 0:
                    helper(i, curr, curr, curr_str)
                else:
                    helper(i, calc + curr, curr, path + '+' + curr_str)
                    helper(i, calc - curr, -curr, path + '-' + curr_str)
                    helper(i, (calc - tail) + (tail * curr), tail * curr, path + '*' + curr_str)
        
        helper(0, 0, 0, "")
        return self.result
                
