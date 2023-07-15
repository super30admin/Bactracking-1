#Time complexity is O(3^n) where n is the number of elements int he candidates array
#Space complexity is O(3^n) where n is the number of elements int he candidates array
#Code ran successfully on leet code
#No issues faced while coding

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        #creating a result list to give the output
        self.result=[]
        self.helper(num,target,0,0,0,"")
        return self.result

    def helper(self,num,target,pivot,calc,tail,path):
        #base
        #If the pivot is equal to length of the num array and if the calculated value is equal to target,
        #we will append the path to the final result
        if(pivot==len(num)):
            if(calc==target):
                self.result.append(path)
            return

        #logic
        for i in range(pivot,len(num)):
            #We will take the substring from pivot to i
            curr=int(num[pivot:i+1])
            #placeholder preceeding 0
            if(int(num[pivot])==0 and i!=pivot):
                continue
            #If it is first level, we will just continue
            if(pivot==0):
                self.helper(num,target,i+1,curr,curr,path+str(curr))
            else:
                #We will have 3 options at each node as subnodess
                #addition
                self.helper(num,target,i+1,calc+curr,curr,path+"+"+str(curr))
                #subtraction
                self.helper(num,target,i+1,calc-curr,-curr,path+"-"+str(curr))
                #multiplication
                self.helper(num,target,i+1,calc-tail+tail*curr,tail*curr,path+"*"+str(curr))
