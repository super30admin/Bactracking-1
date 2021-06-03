class Solution:
    def __init__(self):
        self.result = []
    
    def addOperators(self, num: str, target: int) -> List[str]:
        
        if not num:
            return self.result
        
        self.helper(num, target, "", 0,0,0)
        return self.result
    
    def helper(self, num, target, path,calc, tail, index):
        #base
        if index==len(num):
            if target == calc:
                self.result.append(path)
                return
        #logic
        for i in range(index, len(num)):
            if num[index] == '0' and index!=i:
                continue
            curr = int(num[index: i+1])
            if index==0:
                self.helper(num, target, path+str(curr), calc+curr, curr, i+1)
            else:
                #+
                self.helper(num, target, path +"+"+str(curr), calc+ curr, curr, i+1)
                #-
                self.helper(num, target, path + "-" +str(curr), calc-curr, -curr, i+1)
                #*
                self.helper(num, target, path + "*" +str(curr), calc-tail+tail*curr, tail*curr, i+1)
        
