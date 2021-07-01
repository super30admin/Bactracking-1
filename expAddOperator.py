# Time Complexity : O(2^N)
# Space Complexity : O(2^N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.result = []
    def addOperators(self, num: str, target: int) -> List[str]:
        self.helper(num,target,[],0,0,0)
        return self.result


    def helper(self,num,target,path,index,calc,tail):
        if index == len(num):
            if calc == target:
                self.result.append("".join(path))
            return
        for i in range(index,len(num)):
            if num[index] == "0" and index != i:
                break

            curr = int(num[index:i+1])
            if index == 0:
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,curr,curr)
                path.pop()
            else:
                #+ 
                path.append("+")
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,calc+curr,curr)
                path.pop()
                path.pop()
                #-
                path.append("-")
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,calc-curr,-curr)
                path.pop()
                path.pop()
                #* 
                path.append("*")
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,calc-tail + tail*curr,tail*curr)
                path.pop()
                path.pop()
