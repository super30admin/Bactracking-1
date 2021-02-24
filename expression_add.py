// Time Complexity: O(n* 4^n)
// Space Complexity: O(n)
// Passed all Test cases on Leetcode: Yes
// Approach: Use backtracking to to make recursive calls for + - *. Keep track of previous add and previous sum as this is 
// needed for multiplication to maintain precedence. Keep appending exp when we match target. 

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        
        self.op=[]
        
        self.backtrack(num,target,0,0,0,"")
        
        return(self.op)
    
    def backtrack(self, num, target, index, prevSum, prevAdd, exp):
        print("index:", index, prevSum, prevAdd, exp)
        if(index>=len(num)):
            if(prevSum==target):
                self.op.append(exp)
        
        
        for i in range(index,len(num)):
            curEle=int(num[index:i+1])
            
            print("curEle:", curEle)
            
            if(num[index]=='0' and index!=i):
                continue
        
            if(index==0):
                self.backtrack(num,target,i+1, curEle, curEle, exp+ str(curEle))
            else:
                # +
                self.backtrack(num,target, i+1, prevSum+curEle, curEle,exp + "+" + str(curEle))

                # -
                self.backtrack(num,target,i+1, prevSum-curEle, curEle*-1, exp + "-" + str(curEle))

                # *

                self.backtrack(num,target,i+1,prevSum-prevAdd + prevAdd*curEle, prevAdd* curEle, exp + "*" + str(curEle))

                print("***********")
        
        
                
        