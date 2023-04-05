#TC-O(2**n)
#SC-O(m+n) m is length of candidates,n is target
#logic- recurse through each element by choosing or not choosing it

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        # result = []
        # def helper(candidates,idx,target,path):
        #     #base
        #     if idx==len(candidates) or target<0:
        #         return
        #     if target==0:
        #         p = path.copy()
        #         result.append(p)  
        #         return          
        #     #dont choose
        #     helper(candidates,idx+1,target,path)
        #     #choose
        #     path.append(candidates[idx])
        #     helper(candidates,idx,target-candidates[idx],path)
        #     #backtrack
        #     path.pop(-1)

        # helper(candidates,0,target,[])
        # return result
        result = []
        def helper(candidates,idx,target,path):
            #base
            if idx==len(candidates) or target<0:
                return
            if target==0:
                p = path.copy()
                result.append(p)  
                return          
            for i in range(idx,len(candidates)):
                path.append(candidates[i])
                helper(candidates,i,target-candidates[i],path)
                path.pop(-1)

        helper(candidates,0,target,[])
        return result
        
        