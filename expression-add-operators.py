class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        if (len(num) == 1 and int(num) != target) or num is None:
            return []
        if (len(num) == 1 and int(num) == target):
            return [num]
        
        self.result = []
        self.targ = target
        self.helper(num, 0, 0, 0, "")
        
        return self.result
    
    def helper(self, num:str, index:int, calc:int, tail:int, path: str):
       # print(path,calc)
        #base
        if index == len(num):
            if calc == self.targ: 
                print(path,"sdd")
                self.result.append(path)
               # print(path)
               # print(self.result)
            return
        
        
        #logic
        for i in range(index,len(num)):
            if(num[index] == '0' and index != i):
                break
                
            curr = int(num[index:i+1])
            
            #print(index, i, num[index:i+1],"dddd")
            #print(curr)
            #print(type(curr))
            
                
            
            #if first element
           # print(path)
           # print(type(calc),type(tail),type(curr),curr,num,index,i)
            if index == 0:
                self.helper(num, i+1, curr, curr, path + str(curr))
            else:
                # +
                
                self.helper(num,i+1,calc + curr, curr, path + "+" + str(curr))
                self.helper(num,i+1,calc-curr,-int(curr),path + "-" + str(curr))
                self.helper(num,i+1,calc-tail+tail*int(curr),tail*int(curr),path + "*" + str(curr))
                
                            


            

             
            
        
        
        
           