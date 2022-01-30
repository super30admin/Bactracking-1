
# Recursive Approach without dictionary
# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this 

class Solution:
    result = list()
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num,target,"",0,0,0)
        return self.result
    
    def helper(self,num,target,path,calc,tail,index):
        # base
        if index == len(num):
            if calc == target:
                self.result.append(path)
                return
        # logic
        for i in range(index,len(num)):
            # preceding zeros
            if (i != index and num[index]=='0'):
                continue
            curr = int(num[index:i+1])
            length = len(path)
            if(index==0):
                path += str(curr)
                self.helper(num,target, path, curr, curr,i+1)
                path = path[:length]
            
            else:
                # +
                path += "+"
                path += str(curr)
                self.helper(num, target, path, calc+curr, curr, i+1)
                path = path[:length]
                    
                # -
                path += "-"
                path += str(curr)
                self.helper(num, target, path, calc-curr, -curr, i+1)
                path = path[:length]
                
                # *
                path += "*"
                path += str(curr)
                self.helper(num, target,path, calc - tail + (tail*curr), tail*curr, i+1)
                path = path[:length]


        