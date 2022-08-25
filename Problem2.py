# Time complexity : O(4 ^n)
# 4 - 1(+), 1(-), 1(*), 1(no op)
# Space complexity : O(n * 4 ^ n)
# Leetcode : Solved and submitted

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.res = []
        # if num is empty, then return an empty list
        if not num:
            return self.res
        # call the recursive function with empty path
        self.helper(num, 0, 0, 0, [], target)
        return self.res
    
    def helper(self, num, pivot, calc, tail, path, target):
        # if we have the calculated value = target and we have reached the end of the string, only then we add the path to result
        if calc == target and pivot == len(num):
            self.res.append(''.join(path))
            return
        
        # logic
        # for loop based recursion starting from pivot till then end of string length
        for i in range(pivot,len(num)):
            # if we have preceding zero, where pivot is 0, and i which is moving, that is not pivot, then we simply continue
            if num[pivot] == '0' and i != pivot:
                continue
            # making substr as curr which starts from pivot till i + 1
            curr = int(num[pivot:i+1])
            
            # for the first level, we simply increment the i by 1
            if pivot == 0:
                self.helper(num, i+1, curr, curr, [str(curr)], target)
            else:
                # + case
                # we append the expression + and the value of curr, then for calc, we pass calc + curr as the new value, and for tail, which is the last
                # value, it will be +curr
                # action
                path.append('+')
                path.append(str(curr))
                # recurse
                self.helper(num, i+1, calc + curr, +curr, path, target)
                # backtrack
                path.pop(); path.pop()
                
                # - case
                # we append the expression - and the value of curr, then for calc, we pass calc + curr as the new value, and for tail, which is the last
                # value, it will be -curr
                # action
                path.append('-')
                path.append(str(curr))
                # recurse
                self.helper(num, i+1, calc - curr, -curr, path, target)
                #backtrack
                path.pop(); path.pop()
                
                # * case
                # we append the expression * and the value of curr, then for calc, we pass (calc - tail) + (tail * curr) 
                # as the new value, and for tail, which is the last value, it will be tail * curr
                # action
                path.append('*')
                path.append(str(curr))
                # recurse
                self.helper(num, i+1, (calc - tail) + (tail * curr), (tail * curr), path, target)
                # backtrack
                path.pop(); path.pop()
