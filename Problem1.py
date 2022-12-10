#Time complexity: O(n *(2^n)) where n is number of elements in 'candidates'
#Space complexity: O(h) where h is the height of the recursive tree 

#Accepted on Leetocde

#Approach
#Use for-loop based recursion or 0/1 recursion to perform an exhaustive search for all combinations
#Use single array to maintain current path traversed -> backtrack and remove/add other elements when a given recursive call ends
#When a successful path found -> copy over elements to a new list and append to final soln (if list appended by reference wrong ans as same list is being used to track path everywhere)

class Solution:
    result = []
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.helper(candidates, 0, [], target)
        return self.result


    def helper(self, A, index, path, target):
        #base case
        if target == 0:
            self.result.append([x for x in path])
            return

        if target < 0 or index > len(A) - 1:
            return

        #logic
        for i in range(index, len(A)):
            path.append(A[i])
            self.helper(A, i, path, target - A[i])
            path.pop()