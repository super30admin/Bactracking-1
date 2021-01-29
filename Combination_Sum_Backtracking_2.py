# Created by Aashish Adhikari at 9:08 AM 1/29/2021

# This is another way of backtracking.

'''
Time Complexity:
O(2^h) since a mximum of 2 ^h nodes in a binary tree.

Space Complexity:
Store the current solution at each node, but reuse the array.
O(h) where h is the height of the tree, h can be n in the worst case.

'''

class Solution(object):

    def backtracking_2(self, candidates, target, position_to_start, current_sol):

        # base case
        if target == 0:
            self.sols.append(copy.deepcopy(current_sol))

        elif target < 0 or position_to_start == len(candidates):
            pass
        else:

            for idx in range(position_to_start, len(candidates)):

                # take the element at the position_to_start index and then traverse all the possible solutions from there

                current_sol.append(candidates[idx])
                self.backtracking_2(candidates, target - candidates[idx], idx, current_sol)

                # pop the taken element
                current_sol.pop()

                # not take the element at the position_to_start index
                #self.backtracking_2(candidates, target, position_to_start+1, current_sol)




    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        if len(candidates) == 0:
            return []

        self.sols = []
        self.backtracking_2(candidates, target, 0, [])
        return self.sols