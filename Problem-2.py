# Time Complexity :O(4^n)
# Space Complexity :O(4^n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def backtrack(self,num,path,calc,tail,index,res,target):
        #base reached leafe and got the target
        if index == len(num):
            if calc == target:
                res.append(path)
            return
        #logic backtrack through the loop
        for i in range(index,len(num)):
            #preciding zero take all numbers in all combinations
            if num[index] == '0' and index != i: 
                break
            #get current and type cast it
            curr = int(num[index:i+1])
            if index == 0:
                #if first number just take it without doing anything
                self.backtrack(num,path+str(curr),curr,curr,i+1,res,target)
            else:
                # addition and -ve are nurmal
                self.backtrack(num,path+"+"+str(curr),calc+curr,curr,i+1,res,target)
                self.backtrack(num,path+"-"+str(curr),calc-curr,-curr,i+1,res,target)
                # to give the multiplication the presidence remove tail then multiply current with tail the new tail = tail*curr
                self.backtrack(num,path+"*"+str(curr),(calc-tail)+ tail*curr,tail*curr,i+1,res,target)
            #action
            
            #recurse
            
            #backtrack
            
            
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        res = []
        #edge case
        if not num:
            return res
        #backtrack
        self.backtrack(num,"",0,0,0,res,target)
        return res
        