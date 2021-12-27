# Did this code successfully run on Leetcode : YES

# approach
# backtracking
# special if condition for preceding zeros
# try every operator
# pop twice because of appending two elements: current digit and possible operator
# TC: O(4^N)
# SC: O(N)


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        
        def helper(index=0, calc=0, tail=0, path=[]):
            # print(path)
            # base
            if index == len(num):
                if calc == target:
                    # print(path)
                    result.append(''.join(path))
            # logic
            for i in range(index, len(num)):
                # preceding zero
                if index != i and num[index] == '0':
                    continue
                # no operator
                curr = num[index:i+1]
                int_curr = int(curr)
                if index == 0:
                    path.append(curr)
                    helper(i+1, int_curr, int_curr, path)
                    path.pop()
                else:
                    # addition
                    path.append('+')
                    path.append(curr)
                    helper(i+1, calc+int_curr, int_curr, path)
                    path.pop()
                    path.pop()
                    
                    # subtraction
                    path.append('-')
                    path.append(curr)
                    helper(i+1, calc-int_curr, -int_curr, path)
                    path.pop()
                    path.pop()
                    
                    # multiplication
                    path.append('*')
                    path.append(curr)
                    helper(i+1, calc-tail+tail*int_curr, tail*int_curr, path)
                    path.pop()
                    path.pop()
                    
        helper()
        return result
                    