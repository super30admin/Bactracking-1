class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if len(num)==0:
            return []
        self.result = []
        self.helper(num,target,"",0,0,0)
        return self.result
    def helper(self,num,target,path,calc,tail,index):
        if index == len(num) and target == calc:
            self.result.append(path)
            return


        for i in range(index,len(num),1):
            curr = num[index:i+1]
            if int(num[index]) == 0 and i != index:
                print(num[i])
                print(curr)
                continue
            if(index == 0):
                self.helper(num,target,path+curr,int(curr),int(curr),i+1)
            else:
                self.helper(num,target,path+"+"+curr,calc+int(curr),int(curr),i+1)

                self.helper(num,target,path+"-"+curr,calc-int(curr),-1*int(curr),i+1)

                self.helper(num,target,path+"*"+curr,(calc-tail)+(tail*int(curr)),(tail*int(curr)),i+1)

                    
