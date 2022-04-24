class Solution:
    result =[]
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if not candidates:
            return []
        self.result = []

        def helper(candidates, index, target, arr_list):
            # base case
            if index==len(candidates) or target<0:
                return
            
            if target==0:
                
                self.result.append(arr_list)
                return
            
            # logic
            helper(candidates, index+1, target, arr_list)
            new_li = list(arr_list)
            new_li.append(candidates[index])
            helper(candidates, index, target - candidates[index], new_li)
            
        
        
        helper(candidates, 0, target, [])
        return self.result

        
