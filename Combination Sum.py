# Time Complexity: O(2**n)
# Space Complexity: O(m+n) n being len(candidates) and m being the target
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        global result
        result = []

        # Choose / Don't Choose Recursion
        # def recursion(idx,target, path):
        #     global result

        #     # Base Case
        #     if target < 0 or idx >= len(candidates): return
        #     if target == 0:
        #         result.append(copy.deepcopy(path))
        #         return

        #     # Logic
        #     # Don't choose
        #     recursion(idx+1, target, path)

        #     # Choose
        #     path.append(candidates[idx])
        #     recursion(idx, target - candidates[idx], path)

        #     # Backtracking
        #     path.pop()

        # recursion(0, target, [])
        # return result

        # For loop based recursion
        def recursion(pivot, target, path):
            global result
            # Base Case
            if target < 0: return
            if target == 0:
                result.append(copy.deepcopy(path))

            # Logic
            for i in range(pivot, len(candidates)):
                # Action
                path.append(candidates[i])
                # Recurse
                recursion(i, target - candidates[i], path)
                # Backtrack
                path.pop()

        recursion(0, target, [])
        return result


