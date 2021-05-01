class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if not num :
            return result
        self.helper(num,target,"",0,0,0)
        return self.result
        
    def helper(self,num,target,path,calc,tail,index):
        #base
        if index==len(num):
            if target == calc:
                self.result.append(path)
                
        #logic
        for i in range(index,len(num)):
            # preceding zero # case 05 = 5
            if num[index] == '0' and index != i:
                break
            curr = int(num[index:i+1])
            if index==0:
                self.helper(num,target,path+str(curr),curr,curr,i+1)
            else:
                #+
                self.helper(num, target, path + "+" + str(curr), calc+ curr, curr, i+1 )
                #-
                self.helper(num, target, path + "-" + str(curr), calc-curr, -curr, i+1 )                
                #*
                self.helper(num, target, path + "*" + str(curr), calc-tail+curr*tail, curr*tail, i+1 )
