class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []  # Initialize the result list to store the combinations

        def helper(i, path):
            # Check if the sum of the current combination equals the target
            if sum(path) == target:
                # Append a copy of the current combination to the result list
                res.append(path[:])
                return

            # Iterate through the candidates starting from index 'i'
            for idx in range(i, len(candidates)):
                # Check if the remaining target is greater than or equal to the current candidate
                if target - sum(path) >= candidates[idx]:
                    # Add the current candidate to the combination
                    path.append(candidates[idx])
                    # Recursively call the helper function with the updated combination
                    helper(idx, path)
                    # Remove the current candidate from the combination after exploring all possibilities
                    path.remove(candidates[idx])

        # Start the recursive backtracking with an empty initial combination
        helper(0, [])
        return res  # Return the list of combinations
