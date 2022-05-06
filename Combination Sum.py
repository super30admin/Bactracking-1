class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        res = []
        def helper(arr, slate,target):
            if target == 0:
                res.append(sorted(slate[:])) 
                return
            if target <=0:
                return 
            for i in range(len(candidates)):
                slate.append(arr[i])
                helper(arr,slate, target-arr[i])
                slate.pop()

        helper(candidates,[],target)
        
        to_return = set()
        for item in res:
            to_return.add(tuple(item))
        return to_return