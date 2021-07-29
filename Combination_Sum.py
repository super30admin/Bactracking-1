#Time:O(2^N +N)  as we chose/unchose at each value and N for checking  a string is palindrome or not
#Space:O(N) max depth of the recursion is equal to length of list
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.ans = []
        
        def helper(index,list_val,rem_val):
            # print(index,rem_val)
            if rem_val>target:
                return
            # if index == len(candidates):
            if rem_val == target:
                # print(rem_val,list_val)
                self.ans.append(list_val)
                return
            if index==len(candidates):
                return
            helper(index+1,list_val,rem_val)
            helper(index,list_val+[candidates[index]],rem_val+candidates[index])
        helper(0,[],0)
        return self.ans