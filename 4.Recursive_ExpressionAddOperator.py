# Recursive Approach without dictionary
# // Time Complexity : O(2^N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this 
class Solution:
    result = list()
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num,"",0,0,0,target)
        return self.result
    
    def helper(self,num,path,index,calc,tail,target):
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
            if(index==0):
                self.helper(num, path+str(curr), i+1, curr, curr,target)
            
            else:
                # +
                self.helper(num, path+ "+" + str(curr), i+1, calc+curr, curr, target)
                # -
                self.helper(num, path+ "-"+ str(curr), i+1, calc-curr, -curr, target)
                # *
                self.helper(num, path+ "*" + str(curr), i+1, calc - tail + (tail*curr), tail*curr, target)



        