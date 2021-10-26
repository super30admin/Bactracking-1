class Solution:
    # TC O(len(nums)^target) or O(n^m)
# SC O(m)
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates  is None or len(candidates) == 0:
            return None
        result = []
        
   
        def recurse(candi, target, ind, path):
            
            #base
            if target == 0:
                new_path = list(path)
                result.append(new_path)
                return
            if target < 0:
                return
      
            #Logic
            
            for i in range( ind, len(candi)):
                # if target - candi[i] < 0:
                #     break
                #action
                path.append(candi[i])
                              
                #recurse
                recurse(candi, target - candi[i], i, path)
                #backtrac
                path.pop()              
        
        
        recurse( candidates, target, 0, [])
        return result
