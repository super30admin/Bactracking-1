# Recursive Solution:
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        output = []
        def helper(i, target, temp):
            nonlocal output
            if target<0 or i>=len(candidates):
                return 
            elif target == 0:
                output.append(temp[:])
            else:
                helper(i+1, target, temp)
                newTemp = temp.copy()
                newTemp.append(candidates[i])
                helper(i, target-candidates[i], newTemp)
            return output
                
        return helper(0, target, [])
                

# Backtracking Solution

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        output = []
        def helper(i, target, temp):
            nonlocal output
            if target<0 or i>=len(candidates):
                return 
            elif target == 0:
                output.append(temp[:])
            else:
                helper(i+1, target, temp)
                temp.append(candidates[i])
                helper(i, target-candidates[i], temp)
                temp.pop()
            return output
                
        return helper(0, target, [])
            
#For loop with backtracking

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        output = []
        
        def helper(curr, index, path):
            # nonlocal output
            if curr == target:
                output.append(path[:])
            elif curr>target:
                return
            else:
                for i in range(index, len(candidates)):
                    path.append(candidates[i])
                    helper(curr+candidates[i], i, path)
                    path.pop()
            return output
                
        return helper(0, 0, [])
Space: O(N) + O(T/M)
Time: Copying takes linear time O(N) + Each node -> N possible branches worst case and hieght of T/M = N^(T/m+1)