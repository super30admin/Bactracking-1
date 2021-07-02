#Time complexity for put and get: O(2^n)
#Space complexity: O(T/M) where T is target and M is the minimal value
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        #for loop pattern for recursion
        self.res = []
        def helper(candidates,index,target,path):
            #base
            if target == 0:
                #need to create new list so same reference is not copied
                resPath = [x for x in path]
                self.res.append(resPath)
            if target<0:
                return
            #logic
            for i in xrange(index,len(candidates)):
                #action
                path.append(candidates[i])
                #recurse
                helper(candidates,i,target-candidates[i],path)
                #backtrack
                path.pop()
        helper(candidates,0,target,[])
        return self.res
        #0-1 pattern
        # self.res = []
        # def helper(candidates,index,target,path):
        #     #base
        #     if index>=len(candidates) or target<0:
        #         return
        #     if target == 0:
        #         resPath =list(path)
        #         self.res.append(resPath)
        #         return
        #     #logic
        #     # li = [x for x in path]
        #     #not choose
        #     helper(candidates,index+1,target,path)
        #     #choose
        #     #action
        #     path.append(candidates[index])
        #     #recurse
        #     helper(candidates,index,target-candidates[index],path)
        #     #backtrack
        #     path.pop()
        # helper(candidates,0,target,[])
        # return self.res