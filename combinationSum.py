## Approach 1: Similar to the coin change problem we are exploring all the oaths that add up to target sum with infinte supply of the numbers
# We can apply the approach of choose and dont choose with recursion.

# Time - Exponential ( 2 ^ ()) since we are always creating deep copies of the path. This is O(N) and for N number of such iterations -- O(N^2)
# Space - Exponential maintaining deep copies at every level

# we would need deep copies as the lists as passed by references and not by values, and without doing so, we end up populating to the same list
# When we decide to climb back up on the recursion path we will have all values in the list -- hence we need deep copies

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        self.result = []

        # edge case check
        if not candidates or len(candidates) == 0:
            return self.result

        self.helper(candidates, 0, [], target)
        return self.result


    def helper(self, candidates, i, path, target):

        # base check
        if i == len(candidates) or target < 0:
            return 

        if target == 0:
            self.result.append(path)
            return

        # logic

        # dont choose case
        self.helper(candidates, i+1, path.copy(), target)

        # choose case
        path.append(candidates[i])
        self.helper(candidates, i, path.copy(), target - candidates[i])


## Approach 2: Optimize recursion with backtracking where we only maintain a single list but always remove the elements after visiting them to explore choices
# Time - O(N)
# Space - O(N)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []

        # edge case check
        if not candidates or len(candidates) == 0:
            return self.result

        self.helper(candidates, 0, [], target)
        return self.result


    def helper(self, candidates, i, path, target):

        # base check
        if i == len(candidates) or target < 0:
            return 

        if target == 0:
            self.result.append(path.copy())
            return

        # logic

        # dont choose case
        self.helper(candidates, i+1, path, target)


        # choose case
        # action
        path.append(candidates[i])

        # recurse
        self.helper(candidates, i, path, target - candidates[i])
        
        # backtrack
        path.pop()
        



## Approach 3: Similar to above choose dont choose case, we can represent the technique with a pivot + for loop method
# Backtracking solution
# Time  - O(N)
# Space= - O(N)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []

        # edge case check
        if not candidates or len(candidates) == 0:
            return self.result

        self.helper(candidates, 0, [], target)
        return self.result


    def helper(self, candidates, pivot, path, target):

        # base check
        if target < 0:
            return 

        if target == 0:
            self.result.append(path.copy())
            return

        # logic
        for i in range(pivot, len(candidates)):
            path.append(candidates[i])
            self.helper(candidates, i, path, target - candidates[i])
            path.pop()
        



## Approach 3: Similar to above choose dont choose case, we can represent the technique with a pivot + for loop method
# Backtracking solution
# Time  - O(N)
# Space - O(N)

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []

        # edge case check
        if not candidates or len(candidates) == 0:
            return self.result

        self.helper(candidates, 0, [], target)
        return self.result


    def helper(self, candidates, pivot, path, target):

        # base check
        if target < 0:
            return 

        if target == 0:
            self.result.append(path.copy())
            return

        # logic
        for i in range(pivot, len(candidates)):
            # for the current iteration the function is at, it will i keep changing to explore all numbers while pivot is still same for example, initially 2
            # then once the recurse function completes, pivot moves to next value
            path.append(candidates[i])
            self.helper(candidates, i, path, target - candidates[i])
            path.pop()





















### Tried changing the order of choose and dont choose
## If choose is done prior to not choose case
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        
        self.result = []

        # edge case check
        if not candidates or len(candidates) == 0:
            return self.result

        self.helper(candidates, 0, [], target)
        return self.result


    def helper(self, candidates, i, path, target):

        # base check
        if i == len(candidates) or target < 0:
            return 

        if target == 0:
            self.result.append(path)
            return

        # logic

        temp_list = path.copy() ## here we take a temp list and add the path, so that the original path is passed to the dont choose case
        # without this step, we would be already adding to original path even when we dont want to choose the candidate at the given level

        # choose case
        temp_list.append(candidates[i])
        self.helper(candidates, i, temp_list.copy(), target - candidates[i])
        
        # dont choose case
        self.helper(candidates, i+1, path.copy(), target)
        