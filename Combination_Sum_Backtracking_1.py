# Created by Aashish Adhikari at 5:13 PM 1/26/2021

'''
Time Complexity:
O(2^h) since a mximum of 2 ^h nodes in a binary tree.

Space Complexity:
Store the current solution at each node, but reuse the array.
O(h) where h is the height of the tree, h can be n in the worst case.
'''


class Solution(object):


    def helper(self, candidates, target, index, curr_path):

        # base cases
        if target == 0:
            self.sol.append(copy.deepcopy(curr_path))

        elif target < 0:
            # do not further traverse
            pass

        elif index == len(candidates):



        # logic
        else:

            # left path : dont choose the element
            self.helper(candidates, target, index + 1, curr_path) # <-------------Not passing a deep copy but the same array of the parent

            # right path : choose the element
            curr_path.append(candidates[index])
            self.helper(candidates, target - candidates[index], index, curr_path)#<-------------Not passing a deep copy but the same array of the parent

            # after the right side finishes, remove the last element that was appended to as we need to return the execution to the upper level
            curr_path.pop()






    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        if len(candidates) == 0:
            return []

        self.sol = []
        curr_path = []
        self.helper(candidates, target, 0, curr_path)

        return self.sol


        