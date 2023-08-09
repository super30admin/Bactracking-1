#Time Complexity: O(4^n) n=>no of digits 4 => no of operations performed
#Space Complexity: O(n) Recursion depth
#Two things to take care:
#1. Apply BODMAS when it comes to multiplication. Hence the equation is complex for *
#2. In case of leading zeroes. Convert to double sees "05" as 5. For 1+5 = 6(target), Even if it adds up to the value, we can't add it to output as we have to be exhaustive(1+5 != 1+05)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.outputList=[]
        self.helper(num,target,0,0,0,"")
        return self.outputList

    def helper(self,num,target, pivot, calculated, tail, path):
        #Base
        if pivot==len(num):
            if calculated==target:
                self.outputList.append(path)
            return
        #Logic
        for i in range(pivot,len(num)):
            sub_str=str(num[pivot:i+1])
            current=float(sub_str)
            if(sub_str[0]=="0" and len(sub_str)>1):
                continue
            if pivot==0:
                self.helper(num,target,i+1, current, current, path+sub_str)
            else:
                #Case +
                self.helper(num,target,i+1, calculated+current, current, path+"+"+sub_str)
                #Case -
                self.helper(num,target,i+1, calculated-current, -current, path+"-"+sub_str)
                #Case *
                self.helper(num,target,i+1, calculated-tail + tail*current, tail*current, path+"*"+sub_str)


                
