'''
Time Complexity: O(2**n)
space Complexity: O(n)
'''
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        def myfunc(index, temp, op, target):
            if(target<0):
                return op
            if(target==0):
                t = temp.copy()
                op.append(t)
                return op
            temp.append(candidates[index])
            op = myfunc(index, temp, op, target-candidates[index])
            temp.pop()
            if(index+1<len(candidates) ):
                op = myfunc(index+1, temp, op, target)
            return op
        return myfunc(0, [], [] , target)
        