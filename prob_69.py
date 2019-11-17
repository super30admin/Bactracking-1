#leetcode - 282
# time complexity - O(4^N) with 4 operators at every point.
# performing 4 operations at every point(+,-,* and no operator, that is concat) and checking if the output matches the target.
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
        path="" #initialise with empty string
        index=0
        #edge case
        if not(num):
            return []
        self.backtrack(path,num,target,cal_val,tail,res,index) #"2+3*2" # call helper
        return res


    def backtrack(self,path,num,target,cal_val,tail,res,index):
        #base case
        if index==len(num):
            if cal_val==target:
                res.append(path)
            return res


        #logic
        for i in range(index,len(num)):
            if (i!=index and  str(num[index])=='0'): # if we have a preceding zero like: "0105" then ignore "0" and take it as "105"(break in that case) #preceding 0 case: '0123'
                break
            curr=int(num[index:i+1])  # to take the substring at everypoint(not using any operator)
            if (index==0):
                self.backtrack(path+str(curr),num,target,curr,curr,res,i+1)
            else:
                self.backtrack(path + "+" +str(curr),num,target,cal_val+curr,curr,res,i+1) # for add #curr sent from here to recursion becomes tail
                self.backtrack(path+"-" + str(curr),num,target,cal_val-curr,-curr,res,i+1) # for substraction #tail for recursion becomes -(curr)
                self.backtrack(path+"*" + str(curr),num,target,cal_val-tail+tail*curr,tail*curr,res,i+1) # for multiply #multiplication -- in this case we use tail ##1+2*3 -- tail is 2, cal_cal = 3(1+2), curr =3



#another sol

class Solution:
    def addOperators(self, num, target):
        if len(num) == 0: return []
        result = []
        self.backtrack(result,"", num, target, 0, 0, 0) # call helper
        return result
    def backtrack(self, result, path, num, target, index, calculated, tail):
        # Base case
        if index == len(num):
            if calculated == target:
                print(path)
                result.append(path)
            return
        # Logic
        for i in range(index, len(num)):
            # if we have a preceding zero like: "0105" then ignore "0" and take it as "105"(break in that case)
            if i != index and num[index] == "0":
                break;
            curr = int(num[index:i + 1]) # to take the substring at everypoint(not using any operator)
            if index == 0:
                self.backtrack(result, path+str(curr), num, target, i+1, curr, curr) # for no operator.
            else:
                self.backtrack(result, path + '+' + str(curr), num, target, i+1, calculated + curr, curr) # for add
                self.backtrack(result, path + '-' + str(curr), num, target, i+1, calculated - curr, -curr) # for substraction
                self.backtrack(result, path + '*' + str(curr), num, target, i+1, calculated-tail+tail*curr, tail *curr) # for multiply
