class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        def backtrack(c,t,summ,temp,index):
            #base
            if summ>target or index >= len(c):
                return
            if summ==target:
                res.append(temp[:])

            for i in range(index,len(c)):
                temp.append(c[i])
                backtrack(c,t,summ+c[i],temp,i)
                temp.pop()

        if candidates is None or len(candidates)==0:
            return []
        res=[]

        backtrack(candidates,target,0,[],0)
        return res
