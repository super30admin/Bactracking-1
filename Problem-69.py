
#Leet code- 282 - Expression Operators- https://leetcode.com/problems/expression-add-operators/
# Time complexity - O(4^N)
# Approach - backtracking - we maintain the tail and calculated_value for all the operators and if there is no operator between numbers no need to maintain any tail and calculated value. for + and - operators cal_val is given by (cal_val +curr) and tail is (+curr) whereas in case of multiplication the calculated value is (cal_val - tail + tail*curr) and tail is (tail*curr)

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        res=[]
        cal_val=0
        tail=0
        path=""
        index=0
        #edge case
        if not num: return []
        self.backtrack(path,num,target,cal_val,tail,res,index) #"2+3*2"
        return res
    
    
    def backtrack(self,path,num,target,cal_val,tail,res,index):
        #base case
        if index==len(num):
            if cal_val==target:
                res.append(path)
            return res
        
        
        #logic
        for i in range(index,len(num)):
            #preceding 0 case: '0123'
            if (i!=index and  str(num[index])=='0'):
                break
            curr=int(num[index:i+1])
            if (index==0):
                self.backtrack(path+str(curr),num,target,curr,curr,res,i+1)
            else:
                self.backtrack(path + "+" +str(curr),num,target,cal_val+curr,curr,res,i+1)
                self.backtrack(path+"-" + str(curr),num,target,cal_val-curr,-curr,res,i+1)
                self.backtrack(path+"*" + str(curr),num,target,cal_val-tail+tail*curr,tail*curr,res,i+1) #multiplication 
        
                