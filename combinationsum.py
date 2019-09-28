
#leetcode- error


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        # templist=[]
        self.backtrack(result, list(), candidates, target, 0)
        return result

    def backtrack(self, result, templist, candidates, remaining, start):
        #         base case
        if remaining == 0:
            print(result)
            result.append((templist))
            return

        for i in range(0, len(candidates)):
            if candidates[i] <= remaining:
                print(candidates[i])
                templist.append(candidates[i])
                # print(templist)
                print(result)
                self.backtrack(result, templist, candidates, remaining - candidates[i], i)
                templist.pop()

        # return result

