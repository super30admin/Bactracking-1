class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
    
        ## T.C = O(2^n)
        ## S.C = O(n)
    
    
        ## for loop based recursion with backtracking

        result = []
        i = 0
        n = len(candidates)

        def recurse(candidates, i, target, path):
            
            if i == n or target<0:
                return

            if target == 0:
                result.append(list(path))
                return

            for x in range(i, n):
                ## action
                path.append(candidates[x])

                ## recurse
                recurse(candidates, x, target - candidates[x], path)

                ## backtrack
                path.pop()


        recurse(candidates, i, target, [])
        return result
        
        
        ###########################################################
        ## for loop based recursion

        result = []
        i = 0
        n = len(candidates)

        def recurse(candidates, i, target, path):
            
            if i == n or target<0:
                return

            if target == 0:
                result.append(path)
                return

            for x in range(i, n):
                npath = list(path)
                npath.append(candidates[x])
                recurse(candidates, x, target - candidates[x], npath)

        recurse(candidates, i, target, [])
        return result
    
        ###########################################################
        ## 0-1 recursion with backtrack solution
        
        result = []
        i = 0
        n = len(candidates)

        def recurse(candidates, i, target, path):
            # base
            if i == n or target<0:
                return
            
            if target == 0:
                result.append(list(path))
                return

            # logic
            # not choose
            recurse(candidates, i+1, target, path)

            # choose
            # action 
            path.append(candidates[i])

            # recurse
            recurse(candidates, i, target-candidates[i], path)

            # backtrack
            path.pop()
            

        recurse(candidates, i, target, [])
        return result

        ###########################################################
        ## 0-1 recursion
        result = []
        i = 0
        n = len(candidates)

        def recurse(candidates, i, target, path):
            # base
            if i == n or target<0:
                return
            
            if target == 0:
                result.append(path)
                return

            # logic
            # not choose
            recurse(candidates, i+1, target, list(path))

            # choose
            path.append(candidates[i])
            recurse(candidates, i, target-candidates[i], list(path))

        recurse(candidates, i, target, [])
        return result
