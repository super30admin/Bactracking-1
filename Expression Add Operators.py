# time complexity is o(n * 4^n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
#(Recursive stack space is o(n) and List used for "path" is o(n))
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = list()
        self.helper(num, 0, 0, 0, [], target, res)
        return res
    
    def helper(self, num, ind, calc, tail, path, target, res):     
        #base
        if(ind == len(num)):
            if(calc == target):
                res.append(''.join(path))
            return
        
        #logic
        for i in range(ind, len(num)):
            if(i != ind and num[ind] == '0'):
                continue
            currnum = int(num[ind:i+1])
            
            if(ind == 0):
                path.append(str(currnum))
                self.helper(num, i+1, currnum, currnum, path, target, res)
                path.pop()
            else:
                #for +
                path.append('+')
                path.append(str(currnum))
                self.helper(num, i+1, calc+currnum, currnum, path, target, res)
                path.pop()
                path.pop()
                
                #for -
                path.append('-')
                path.append(str(currnum))
                self.helper(num, i+1, calc-currnum, -currnum, path, target, res)
                path.pop()
                path.pop()
                
                #for *
                path.append('*')
                path.append(str(currnum))
                self.helper(num, i+1, calc-tail + tail*currnum, tail*currnum, path, target, res)
                path.pop()
                path.pop()
                
        
        
        

        
        
        
        
#         #base
#         if(ind == len(num)):
#             if(calc == target):
#                 res.append(path)
#             return
        
#         #logic
#         for i in range(ind, len(num)):
#             if(i != ind and num[ind] == '0'):
#                 continue
#             currnum = int(num[ind:i+1])
            
#             if(ind == 0):
#                 self.helper(num, i+1, currnum, currnum, path + str(currnum), target, res)
#             else:
#                 #for +
#                 self.helper(num, i+1, calc+currnum, currnum, path + '+' + str(currnum), target, res)
#                 #for -
#                 self.helper(num, i+1, calc-currnum, -currnum, path + '-' + str(currnum), target, res)
#                 #for *
#                 self.helper(num, i+1, calc-tail + tail*currnum, tail*currnum, path + '*' + str(currnum), target, res)
        
        