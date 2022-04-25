class Solution:
    
    def combinationSum(self, candidates, target):
        '''
        T = O(N^( (T/M)+1) )  )
        S = O(T/M)
        N be the number of candidates
        T be the target value
        M be the minimal value among the candidates.
        '''

        def helper( candidates , i , target , path  ):
            #base
            if target < 0  :
                return
            if target == 0:
                r.append(list(path))
                return  
            
            # logic
            for idx in range(i , len(candidates)):
                #action
                path.append( candidates[idx] )
                #recurse
                helper( candidates , idx , target-candidates[idx] , path   )
                #backtrack
                path.pop()
                
            return r
        
        r = []
        path = [] 
        return helper( candidates , 0 , target , path  )
    
    def RecurrsiveSolutioncombinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        '''
        https://www.youtube.com/watch?v=S_NxQDRlWcc&list=PLWtKyKogBpBCIwYoD3sbtD_-e9vVqlZnV&index=26&t=367s
        1 hour 17 mins to 1 hour 24 mins - important recursion conecpt 
        '''
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

        
