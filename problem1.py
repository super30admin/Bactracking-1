# Time Complexity :O(n*2^n) where n is number of candidates
# Space Complexity : O(n) single temp list
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Backtracking solution: After backtrack call, we append the
# candidates to a temp list and recurively call backtrack to check if the target is reached
# Once it is reached we add to result array else we remove the last candidate in temp list and
# continue

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        self.result = []
        if candidates == None or len(candidates) == None:
            return result

        self.target = target
        self.backtrack(candidates, [], 0, 0)
        return self.result

    def backtrack(self, candidates, temp, summ, index):
        if summ > self.target or index >= len(candidates):
            return

        if summ == self.target:
            self.result.append(temp)
            return
        # Note i starts from the index, that is sent from recursive backtrack
        for i in range(index, len(candidates)):

            # action

            temp.append(candidates[i])
            # recurse, here the index is i in the for loop

            self.backtrack(candidates, list(temp), summ+candidates[i], i)

            # control comes back from return in line 18
            # backtrack
            temp.pop()


# python syntax lesson: use [] to past a new array list and while calling it recursivly refer it to as list(temp)


#     # recurive solution
#     def helper(self, candidates, temp, summ, index):
#         if summ > self.target or index >= len(candidates):
#             return

#         if summ==self.target:
#             self.result.append(temp)
#             return
#         # dont choose

#         self.helper(candidates,list(temp), summ, index+1)

#         #choose

#         temp.append(candidates[index])
#         self.helper(candidates,list(temp),summ+candidates[index], index)
