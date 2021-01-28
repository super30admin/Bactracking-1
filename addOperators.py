# Time Complexity : O(4^n)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Had to figure out a work around when doing 
# the math operations.. class went over the BODMAS and utilizing the calc/tail variables


# Your code here along with comments explaining your approach

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
        Can use recursion or backtracking.
        Have a calc and tail var. 
                         calc                    tail
                   '+'   calc+curr               +curr
                   '-'   calc - curr             -curr
                   '*'  calc-tail + (tail*curr) tail*curr
        """
        res = [] 
                
        if not num:
            return res 
        
        self.helper(num, [], 0,0,0 ,target, res)
        return res
    
    def helper(self, num, path, calc, tail, index, target,res):
        if index == len(num):
            if calc == target:
                res.append("".join(path))        
            return
    
        for i in range(index, len(num)):
            #specific case for example "105"
            if index != i and num[index] == '0':
                continue
            curr = int(num[index: i+1])

            if index == 0:
                self.helper(num, [str(curr)], curr, curr, i+1, target, res)
            else:
                #three cases '+, -, *'
                path.append('+')
                path.append(str(curr)) 
                self.helper(num, path, calc+curr, curr, i+1, target, res)
                #backtrack
                path.pop()
                path.pop()

                path.append('-')
                path.append(str(curr)) 
                self.helper(num, path, calc - curr, -curr, i+1, target, res)
                #backtrack
                path.pop()
                path.pop()

                
                path.append('*')
                path.append(str(curr)) 
                self.helper(num, path, (calc-tail) +(tail*curr), tail * curr, i+1, target, res)
                #backtrack
                path.pop()
                path.pop()
        return









# class Solution:
#     def addOperators(self, num: str, target: int) -> List[str]:
#         res = [] 
        
#         targ = target
        
#         if not num:
#             return res 
        
#         self.helper(num, "", 0,0,0 ,target, res)
#         return res
    
#     def helper(self, num, path, calc, tail, index, target,res):
#         if index == len(num):
#             if calc == target:
#                 res.add(path)        
#             return
        
#         for i in range(index, len(num)):
#             curr = num[index: i+1]
#             if index == 0:
#                 self.helper(num, path+curr, curr, curr, i+1, target, res)
#             else:
#                 #three cases '+, -, *'
#                 self.helper(num, path + "+" + str(curr), curr+calc, curr, i+1, target, res)
#                 self.helper(num, path + "-" + str(curr), calc - curr, -1 * curr, i+1, target, res)
#                 self.helper(num, path + "*" + str(curr), calc-tail + tail * curr, tail* curr, i+1, target, res)

                
        
    