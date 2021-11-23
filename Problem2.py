# Leetcode 282: Add operators
# Time - exponential
# space - O(n)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        result = []
        
        def helper(num, target, prevSum, tail, path, index):
            
            if index == len(num):
                
                if prevSum == target:
                    
                    result.append(path)
                    return
                
            for i in range(index, len(num)):
                
                if num[index] == '0' and index != i:
                    
                    return
                
                currString = num[index: i + 1]
                
                if index == 0:
                    
                    helper(num, target, prevSum + int(currString), int(currString), path + currString, i + 1)
                
                else:
                    
                    
                    # +
                    helper(num, target, prevSum + int(currString), int(currString), path +"+"+ currString, i + 1)
                    # -
                    helper(num, target, prevSum - int(currString), -int(currString), path+ "-" + currString, i + 1) 
                    
                    # *
                    new_multiply = prevSum - tail + (tail * int(currString))
                    
                    helper(num, target, new_multiply, tail * int(currString), path +"*"+ currString, i + 1)
        
        helper(num, target, 0, 0, "", 0)
        
        return result