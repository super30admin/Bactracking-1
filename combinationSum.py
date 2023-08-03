#Time: O(n^(t/m)); n is number of candidates, target t and min of candidates m
#space: O(target/min(candidates)) which is the max depth of the recursionn tree
#Did the code run successfully on leetcode? yes
#Approach:
#using recursion explore all paths.
#backtrack a path when adding a selected candidate exceeds the target.
#to avoid redundant computations, pass only the candidates array from that candidate's index

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        result = set()
        #candidates.sort()
        def backtrack(candidates, target, combination):
            for idx in range(len(candidates)):
                candidate = candidates[idx]
                if target - candidate >= 0: #is_valid(candidate)
                    combination.append(candidate) #place candidate
                    if target - candidate == 0:
                        result.add(tuple(combination))
                    else:
                        backtrack(candidates[-len(candidates)+idx:], target-candidate, combination) #recursion
                    combination.remove(candidate) #backtrack
                else:
                    break
        
        backtrack(candidates, target, [])
        return result