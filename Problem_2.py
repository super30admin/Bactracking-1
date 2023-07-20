"""
Problem : 2

Time Complexity : O(3^n)
Space Complexity : O(n)



Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Keeping track of the last processed number to use for future immediate multiplication operations, and a path string to keep track of the actual string formed
if the pivot approaches end of the num string, checking if we have achieved the target, if yes, then appending the target to the result, and returning
"""

# Expression Add Operator

# Approach - 1
# Recursion

class Solution(object):
    def __init__(self):
        self.result=[]
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.helper(num,target,0,0,0,"")
        return self.result
    
    def helper(self,num,target,pivot,calc,tail,path):
        # base
        if pivot==len(num):
            if calc==target:
                self.result.append(path)
            return


        # logic
        for i in range(pivot,len(num)):
            
            curr=int(num[pivot:i+1])
            # preceding zero case
            # if int(num[pivot])==0 and i!=pivot:
            # if num[pivot]=='0' and i!=pivot:
            #     continue
            l=len(path)
            if len(str(curr))==len(num[pivot:i+1]):
                if pivot==0:
                    # action
                    
                    path+=str(curr)
                    # recurse
                    self.helper(num,target,i+1,curr,curr,path+str(curr))
                    # backtrack
                    path=path[:l]
                else:
                    # 3 options
                    path+="+"
                    path+=str(curr)
                    self.helper(num,target,i+1,calc+curr,curr,path)
                    path=path[]
                    self.helper(num,target,i+1,calc-curr,-curr,path)
                    self.helper(num,target,i+1,calc-tail+tail*curr,tail*curr,path)

# Approach - 2
# Backtracking

class Solution(object):
    def __init__(self):
        self.result=[]
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.helper(num,target,0,0,0,"")
        return self.result
    
    def helper(self,num,target,pivot,calc,tail,path):
        # base
        if pivot==len(num):
            if calc==target:
                self.result.append(path)
            return


        # logic
        for i in range(pivot,len(num)):
            
            curr=int(num[pivot:i+1])
            # preceding zero case
            # if int(num[pivot])==0 and i!=pivot:
            # if num[pivot]=='0' and i!=pivot:
            #     continue
            l=len(path)
            if len(str(curr))==len(num[pivot:i+1]):
                if pivot==0:
                    # action
                    
                    path+=str(curr)
                    # recurse
                    self.helper(num,target,i+1,curr,curr,path)
                    # backtrack
                    path=path[:l]
                else:
                    # 3 options
                    path+="+"
                    path+=str(curr)
                    self.helper(num,target,i+1,calc+curr,curr,path)
                    path=path[:l]

                    path+="-"
                    path+=str(curr)
                    self.helper(num,target,i+1,calc-curr,-curr,path)
                    path=path[:l]

                    path+="*"
                    path+=str(curr)
                    self.helper(num,target,i+1,calc-tail+tail*curr,tail*curr,path)
                    path=path[:l]
