class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def backtrack(num, target, index, calc, tail, path):
            
            # base condition
            
            if index == len(num):
                if calc == target:
                    result.append(path)   
                return
            
            
            for i in range(index, len(num)):
                if num[index] == "0" and index != i:
                    continue
                
                curr = int(num[index: i+1])
                
                if index == 0:
                    backtrack(num, target, i + 1, curr, curr, path + str(curr))
                else:
                    
                    # + operator case
                    backtrack(num, target, i + 1, calc + curr, curr, path + "+" + str(curr))
                    
                    # - operator case
                    backtrack(num, target, i + 1, calc - curr, -curr, path + "-" + str(curr))
                    
                    # * operator case
                    
                    backtrack(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + str(curr))
                    
                    
                    
        result = []
        backtrack(num, target, 0, 0, 0, "")
        return result
    
#TIME COMPLEXITY: O(4^n) 4 for 4 possible operation and n is the length of the string
                    