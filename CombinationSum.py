"""
The approach here is to keep a sub-array where all the eligible elements get appended, for every element
we check all the combinations using which we can get to the target, then we move to the next element considering
the previous elements and check if can get the target using the combination. all the eligible elements are
appended in the stack array, the base condition for recusion is when the deductant value is 0. 

LeetCode - Running
Time complexity - O()
"""
def combinationSum(self, candidates, target):
        results = []
        candidates = sorted(candidates)
        
        def dfs(remain, stack):
            
            if remain == 0:
                results.append(stack)
            
            for item in candidates:
                if item > remain:
                    break
                
                if stack and item < stack[-1]:
                    continue
                else:
                    dfs(remain-item, stack+[item])
        dfs(target,[])
        
        return results