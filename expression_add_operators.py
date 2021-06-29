class Solution:
    '''
    Time Complexity: O(4^n) for each operand
    Space Complexity: O(n)
    '''
    def addOperators(self, num: str, target: int) -> List[str]:
        n = len(num)
        
        res = []
        
        def recursion_helper(index, prev, curr, value, string):
            
            # you are at the end
            if index == n:
                
                if value == target and curr == 0:
                    res.append("".join(string[1:]))
                return
            
            # extend operand by one digit
            curr = curr * 10 + int(num[index])
            str_op = str(curr)
            
            if curr > 0:
                
                recursion_helper(index + 1, prev, curr, value, string)
            
            string.append('+')
            string.append(str_op)
            
            recursion_helper(index + 1, curr, 0, value + curr, string)
            string.pop()
            string.pop()
            
            
            if string:
                
                string.append('-')
                string.append(str_op)
                
                recursion_helper(index + 1, -curr, 0, value - curr, string)
                string.pop()
                string.pop()
                
                string.append('*')
                string.append(str_op)
                
                recursion_helper(index + 1, curr * prev, 0, value - prev + (curr * prev), string)
                string.pop()
                string.pop()
        
        recursion_helper(0, 0, 0, 0, [])
        return res