# Created by Aashish Adhikari at 9:07 AM 1/29/2021
'''
Time Complexity:

The minimum element in the input is 1. Hence, the height of the recursion tree can be a maximum of target / minimum element = t/min
The upper bound of the number of nodes of a binary tree is 2 ^ (height of the tree) = 2 ^ (t/min)
At each node, we have a new copy of the current solution. Assuming n is the length of the input array, the upper bound to make such copies for
 all the nodes is O(n).
 Hence time complexity = O ( n . (2 ^ (t/min)) )

 Space Complexity:
 Just as the time complexity, we create a new array for each node. Hence the space complexity is the same as the time complexity. O ( n . (2 ^ (t/min)) )

'''


class Solution(object):

    def recursion(self, candidates, target, next_position, current_solution):

        # base case
        if target == 0:
            self.sol.append(current_solution)
        elif target < 0 or next_position == len(candidates):
            pass
        else:

            # not choose
            copy1 = copy.deepcopy(current_solution)#                    <-------pass a new copy to the child to preserve the state of the parent
            self.recursion(candidates, target, next_position+1, copy1)


            # choose
            copy2 = copy.deepcopy(current_solution)#                        <-------pass a new copy to the child to preserve the state of the parent
            copy2.append(candidates[next_position])
            self.recursion(candidates, target - candidates[next_position], next_position, copy2)



    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """

        if len(candidates) == 0:
            return []

        self.sol = []
        self.recursion(candidates, target, 0, [])
        return self.sol