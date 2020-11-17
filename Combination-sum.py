class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if candidates == []:
            return None
        result = []

        #         def reccursion(candidates,target,summ,temp,i):
        #             if i>=len(candidates) or summ>target:
        #                 return
        #             if summ==target and temp not in result:
        #                 # ab=temp
        #                 result.append(list(temp))
        #                 # print(result)
        #             # temp=[]
        #             reccursion(candidates,target,summ,list(temp),i+1)

        #             temp.append(candidates[i])
        #             # temp=[]
        #             reccursion(candidates,target,summ+candidates[i],list(temp),i)

        #         reccursion(candidates,target,0,[],0)
        #         return result

        def backtrack(candidates, target, summ, temp, i):
            if summ == target and temp not in result:
                result.append(list(temp))
                return
            elif summ > target:
                return
            for j in range(i, len(candidates)):
                # action
                # temp1=list(temp)
                temp.append(candidates[j])
                # recurr
                backtrack(candidates, target, summ + candidates[j], temp, j)
                temp.pop()

        backtrack(candidates, target, 0, [], 0)
        return result
        # backtracking and recc- time-exponential
        # space-recc- O(n**M) space=backtracking-O(T/min(elements))