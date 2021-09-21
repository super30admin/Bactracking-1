# // Time Complexity :O(4^n)
# // Space Complexity :exponential
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach






class Solution:
    def __init__(self):
        self.result=[]
    def addOperators(self, num: str, target: int) -> List[str]:
        nums=list(num)
        print(nums)
        self.helper(nums,0,0,0,[],target)
        return self.result
    def helper(self,nums,index,calc,tail,path,target):
        #base
        if index==len(nums):
            
            if calc==target:
                self.result.append(''.join(path))
            return
                
        
        #logic
        #spcl
        for i in range(index,len(nums)):
            if index is not i and nums[index]=='0':
                continue
            curr=int(''.join(nums[index:i+1]))
            
            l=len(path)
            if index==0:
                path.append(str(curr))
                self.helper(nums,i+1,curr,curr,path,target)
                path=path[:(l)]
            else:
                #+
                path.append("+")
                path.append(str(curr))
                self.helper(nums,i+1,calc+curr,curr,path,target)
                path=path[:(l)]
                #-
                path.append("-")
                path.append(str(curr))
                self.helper(nums,i+1,calc-curr,-curr,path,target)
                path=path[:(l)]
                #*
                path.append("*")
                path.append(str(curr))
                self.helper(nums,i+1,calc-tail+tail*curr,tail*curr,path,target)
                path=path[:(l)]
        