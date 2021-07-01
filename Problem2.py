# Time Complexity : O(3**n)
# Space Complexity : O(len(string))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#maintaining the previous change and removing it if present option is multiplication
# doing for loop to take the case of no operator
#preceding zero can be handled by ignoring all the cases in for loop 
class Solution:
    
    def __init__(self):
        self.out = []
    def addOperators(self, num: str, target: int) -> List[str]:
        self.helper(num,target,[],0,0,0)
        return self.out
        
    
    def helper(self,num,target,path,index,calc,tail):
        #baseint
        if index == len(num):
            if calc == target:
                self.out.append("".join(path))
            return;
        #logic
        for i in range(index,len(num)):
            if num[index] == "0" and index != i:
                break
                
            curr = int(num[index:i+1])
            if index == 0:
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,curr,curr)
                path.pop()
            else:
                # + case
                path.append("+")
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,calc+curr,curr)
                path.pop()
                path.pop()
                
                #-case
                path.append("-")
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,calc-curr,-curr)
                path.pop()
                path.pop()
                
                # * case
                path.append("*")
                path.append(num[index:i+1])
                self.helper(num,target,path,i+1,calc-tail + tail*curr,tail*curr)
                path.pop()
                path.pop()
        
            