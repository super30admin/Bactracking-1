  def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans=[]
        candidates.sort()
        def DFS(arr,sm,target,j):
            if sm==target:
                if arr not in ans:
                    ans.append(arr)
                return
            for i in range(j,len(candidates)):
                if sm+candidates[i]>target:
                    return
                DFS(arr+[candidates[i]],sm+candidates[i],target,i)
        DFS([],0,target,0)
        return ans