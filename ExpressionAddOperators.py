class Solution:
    """BackTracking
    As python strings are immutable, we can use list to initially store the path and 
    then when the target value is acheived, store the path in global list using .join operation where a new string will be craeted and added to result."""
    def __init__(self):
        self.result=[]
    def addOperators(self, num: str, target: int) -> List[str]:
        string=[]
        self.helper(num,string, 0, 0, 0, target)
        return self.result
 
    def helper(self, num, string, index, prev, tail, target):
        if index==len(num):
            if target==prev:
                self.result.append("".join(string))
                return
        for i in range(index, len(num)):
            if num[index]=="0" and index!=i:
                continue
            curr=int(num[index:i+1])
            if index==0:
                string.append(str(curr))
                self.helper(num, string, i+1, curr, curr, target)
                string.pop()
            else:
                string.append("+")
                string.append(str(curr))
                self.helper(num, string, i+1, curr+prev, curr, target)
                string.pop()
                string.pop()
                
                string.append("-")
                string.append(str(curr))
                self.helper(num, string, i+1, -curr+prev, -curr, target)
                string.pop()
                string.pop()
                
                string.append("*")
                string.append(str(curr))
                self.helper(num, string, i+1, -tail+prev+(tail*curr),curr*tail, target)
                string.pop()
                string.pop()
      
    
    """Recursive Approach
    Time complexity- Exponential"""
    
    # def helper(self, num, string, index, prev, tail, target):
    #     if index==len(num):
    #         if target==prev:
    #             self.result.append(string)
    #             return
    #     for i in range(index, len(num)):
    #         if num[index]=="0" and index!=i:
    #             continue
    #         curr=int(num[index:i+1])
    #         if index==0:
    #             self.helper(num, string+str(curr), i+1,curr, curr, target)
    #         else:
    #             self.helper(num, str(string)+"+"+str(curr),i+1, curr+prev,curr, target)
    #             self.helper(num, str(string)+"-"+str(curr),i+1, -curr+prev,-curr, target)
    #             self.helper(num, str(string)+"*"+str(curr),i+1, -tail+prev+(tail*curr),curr*tail, target)
                

        
        
        