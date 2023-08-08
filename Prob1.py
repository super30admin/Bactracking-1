# Time Complexity : O(4^n). Each point we have 4 possible operators -> +,-,*,nothing
# Space Complexity : O(len of num + 3)

# Create all the possible numbers starting from a pivot and add expressions on them.
# The do nothing operation is done by the for loop itself.
# Calculate value of a node in usual way for add and sub operators. 
# Specifically for mul operator *, remove the previously added element (tail) from the current sum, multiply current value with the tail and add it to the current sum. 
# Update tail to tail * current value. 

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res=[]
        def helper(num,target,pivot,calc,tail,path):
           #base
            if pivot==len(num):
                if calc==target:
                   res.append(path)
                return

           #logic
            for i in range(pivot,len(num)):
                sub=num[pivot:i+1]
                # Below, we Handle preceding 0 edge case by not considersing numbers that start with a 0. -> 05 is not valid, but 0 (just 0) is valid.
                if num[pivot] == '0' and i != pivot:continue
                curr=int(sub) #string to int for math operations
                if pivot==0:
                    helper(num,target,i+1,curr,curr,path+str(curr)) #while adding back to path, make it string
                else:
                    helper(num,target,i+1,calc+curr,curr,path+'+'+str(curr))
                    helper(num,target,i+1,calc-curr,-1*curr,path+'-'+str(curr))
                    helper(num,target,i+1,calc-tail+(tail*curr),tail*curr,path+'*'+str(curr))
        helper(num,target,0,0,0,'')
        return res     



        