class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates==None or len(candidates)==0:
            return []
        result=[]
        remaining=0
        index=0
        curval=[]
        self.helper(candidates, target, result, target, index, curval)
        return result

    def helper(self, nums, target, result, remaining, index, curval):
        if index ==len(nums) or remaining <=0:
            if remaining==0:
                result.append(list(curval))
                return
            else:
                return

        for i in range(index, len(nums)):
            curval.append(nums[i])
            self.helper(nums, target, result, remaining-nums[i], i, curval)
            curval.pop()
