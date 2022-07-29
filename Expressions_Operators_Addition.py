class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result=[]
        
        
        def operators_add(start,path,target,calculated,tail):
            if start==len(num) and target==calculated:
                result.append(path[:])
                return
            
            for i in range(start,len(num)):
                if start!=i and num[start]=='0':
                    continue
                    
                curr=int(num[start:i+1])
                if start==0:
                    operators_add(i+1,path+str(curr),target,curr,curr)
                else:
                    
                    operators_add(i+1,path+'+'+str(curr),target,calculated+curr,curr)
                    operators_add(i+1,path+'-'+str(curr),target,calculated-curr,-curr)
                    operators_add(i+1,path+'*'+str(curr),target,calculated-tail+tail*curr,tail*curr)
                    
        operators_add(0,"",target,0,0)     
        
        return result
        
                    
        
                    
                    