class Solution:
    def __init__(self):
        self.res=[]
    def addOperators(self, num: str, target: int) -> List[str]:
        # key idea: compute calculated and tail value 
        # operator   cal          tail
        # '+'       cal+curr      curr
        # '-'       cal-curr      -curr
        # '-'       cal-tail       tail*curr
        #           +(tail*curr).   
        # TC:exponential 
        # SC:exponential
        
        self.helper(num, target, 0, "", 0, 0)
        return self.res
    
    def helper(self, num, target, index, path, calc, tail):
        # base
        # string are immuatble DS so we do not need to create different paths
        if index==len(num):
            if calc==target:
                self.res.append(path)
                return
        
        # logic
        # index = pivot
        for i in range(index, len(num)):
            # preceding zero
            if num[index]=='0' and index!=i:
                break
            cur = int(num[index:i+1])   # 1
            if index==0:
                self.helper(num, target, i+1, str(path)+str(cur), cur, cur  )
            else:
                # + case
                self.helper(num, target, i+1, str(path) + "+" + str(cur), calc+cur, cur  )
                # - case
                self.helper(num, target, i+1, str(path) + "-" + str(cur), calc-cur, -cur  )
                # * case
                self.helper(num, target, i+1,str(path) + "*" + str(cur), calc-tail + (tail*cur), tail*cur  )
                
                
        
        
    
    