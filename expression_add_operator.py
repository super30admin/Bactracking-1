class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        result =[]
        def helper(input,target,expr,prev,curr,index):
            #Base Case
            if index ==len(input):
                if curr == target:
             #       result.append("".join(expr[1:]))
                    result.append(expr)
                return
                
            #make a choice
            for i in range(index,len(input)):
                
                if index!=i and input[index]=='0':
                    break
                #calculating sum
                elem = input[index:i+1]
                
                if (index==0):
                    helper(input,target,expr+elem,int(elem),int(elem),i+1)
                else:
                    # +
                    helper(input,target,expr + '+'+elem,int(elem),curr+int(elem),i+1)
                    
                    #  *
                    helper(input,target,expr + '*'+elem,prev*int(elem),curr-prev+(prev*int(elem)),i+1)
                    
                    # -
                    helper(input,target,expr + '-' + elem,-int(elem),curr-int(elem),i+1)
                    
                    
        helper(num,target,'',0,0,0)
        return result
        
        
        #tc ---> o(n x 4^n) we have 4 different choices --> +,-,*,nothing
        #sc ----> o(n) for recursion stack, o(n) for expression --> o(n) 
                                
            
        
                
                                
            
        
