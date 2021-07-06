"""
Approach: Do a DFS traversal and decide if the element of the array needs to used in your result

TC: O(n * 2^n) since we are making 2 decisions (choose/not choose) at each element of the array
SC: O(n * 2^n) since we are making a new path at each traversal/node
"""

from copy import copy
class Solution:
    # approach 1: recursion
    """
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, target):
        #base
        if target == 0:
            return self.result.append(path)

        if target < 0 or index >= len(candidates): return

        #logic
        #choose
        path_copy = deepcopy(path)
        path_copy.append(candidates[index])
        self.helper(candidates, index, path_copy, target - candidates[index]) # since you can use the same candidate again, you do not increment the index


        #not choose
        self.helper(candidates, index + 1, deepcopy(path), target)
    """

    # approach 1.1: recursion - using not choose option first.... TC, SC same as approach 1
    """
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, target):
        #base
        if target == 0:
            return self.result.append(path)

        if target < 0 or index >= len(candidates): return

        #logic
        #not choose
        self.helper(candidates, index + 1, deepcopy(path), target)

        #choose
        path.append(candidates[index])
        self.helper(candidates, index, deepcopy(path), target - candidates[index]) # since you can use the same candidate again, you do not incremnet the index
    """

    # approach 2: Backtracking
    """
    Instead of using a new path array for every traversal, it'd be space efficient to undo the action of appending into
     the path i.e. backtrack once the element is popped out of the recursive stack
    TC: O(2^n)
    SC: O(n) since we are reusing the path list 
    """
    """
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, target):
        #base
        if target == 0:
            return self.result.append(deepcopy(path))

        if target < 0 or index >= len(candidates): return

        #logic
        #not choose
        self.helper(candidates, index + 1, path, target)

        #choose
        path.append(candidates[index])
        self.helper(candidates, index, path, target - candidates[index]) # since you can use the same candidate again, you do not incremnet the index

        #backtrack
        path.pop()
    """

    # approach 2.1: Backtracking - using choose first. TC, SC same as approach 2
    """
    def __init__(self):
        self.result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, target):
        #base
        if target == 0:
            return self.result.append(deepcopy(path))

        if target < 0 or index >= len(candidates): return

        #logic
        #choose
        path.append(candidates[index])
        self.helper(candidates, index, path, target - candidates[index]) # since you can use the same candidate again, you do not incremnet the index

        #backtrack
        path.pop()

        #not choose
        self.helper(candidates, index + 1, path, target)
    """

    # approach 3: For loop recursion
    #TC: O(n * 2^n)
    #SC: O(n * 2^n)
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, target):
        # base
        if target == 0:
            return self.result.append(path)

        if target < 0: return

        for i in range(index, len(candidates)):
            copy_path = deepcopy(path)
            copy_path.append(candidates[i])
            self.helper(candidates, i, copy_path, target - candidates[i])

    # approach 3.1: For loop recursion with Backtracking
    #TC: O(2 ^ n)
    #SC: O(n)
    def __init__(self):
        self.result = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.helper(candidates, 0, [], target)
        return self.result

    def helper(self, candidates, index, path, target):
        # base
        if target == 0:
            return self.result.append(deepcopy(path))

        if target < 0: return

        for i in range(index, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, i, path, target - candidates[i])
            path.pop()












