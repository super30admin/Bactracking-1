class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        '''
        Time Complexity: O(2^n)
        Space Complexity: O(n) since we are backtracking
        '''
        o = []
        
        # backtrack solution
        def combinationSum1(path,i,target):
            
            nonlocal o
            if(target==0):
                o.append(path[:])
                return
            if(i==len(candidates) or target<0):
                return
            
            # choose element
            path.append(candidates[i])
            combinationSum1(path,i,target-candidates[i])
        
            # not choose
            # backtrack
            path.pop()
            combinationSum1(path,i+1,target)
        
        
        combinationSum1([],0,target)
        
        return o
