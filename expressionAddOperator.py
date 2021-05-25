"""282. Expression Add Operators
Time Complexity: O(4^N)
Space Complexity: O(N) 
Approach - Backtracking"""
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        self.backtrack(result,num,0,target,"",0,0)
        return result
    
    def backtrack(self,result,num,index,target,path,calc,tail):
        if index >= len(num):
            if calc == target:
                result.append(path)
            return 
        
        for i in range(index,len(num)):
            curr =int(num[index:i+1]) #substring
            # eg case: 105 where zero is not at index
            if num[index] == '0' and i !=index:
                continue
            if index == 0:
                #skip zero if its at index start point
                self.backtrack(result, num, i+1, target, path+str(curr), curr, curr)
            else:
                #+expression
                self.backtrack(result, num, i+1, target, path+'+'+str(curr), calc + curr, curr)
                #-expression
                self.backtrack(result, num, i+1, target, path+'-'+str(curr), calc - curr, curr*-1)
                 #*expression -> keeep track of precedence
                self.backtrack(result, num, i+1, target, path+'*'+str(curr), calc - tail + tail*curr, tail*curr)
