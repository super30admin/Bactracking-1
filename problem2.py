// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.output=[]
        if not num or len(num)==0:
            return self.output
        self.backtracking(num,0,target,0,0,"")
        return self.output
        
    
    def backtracking(self,num,index,target,prevSum, preAddition,exp):
        if index>=len(num):
            if prevSum==target:
                self.output.append(exp)
            return
                
        for i in range(index,len(num)):
            if num[index]=='0' and i!=index:
                break 
            
            currElement=int(num[index:i+1])


            
            if index==0:
                self.backtracking(num,i+1,target, currElement, currElement, exp+str(currElement))
            else:
                #call the backtrack for +
                self.backtracking(num,i+1,target,prevSum+currElement,currElement,exp+'+'+str(currElement))

                #call the backtrack for -
                self.backtracking(num,i+1,target,prevSum-currElement,currElement*-1,exp+'-'+str(currElement))

                #call the backtrack for *
                self.backtracking(num,i+1, target, (prevSum-preAddition) + (preAddition*currElement), preAddition*currElement ,exp+'*'+str(currElement))
