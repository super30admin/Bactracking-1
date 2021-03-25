#Time-complexity: O(N*2^N)
#space-complexity: O(N)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        results = []

        def backtrack(remain, comb, start):
            print(comb)
            print(start)
                       # backtrack, remove the number from the combination
            if remain == 0:
                # make a deep copy of the current combination
                results.append(list(comb))
                return
            elif remain < 0:
                # exceed the scope, stop exploration.
                return

            for i in range(start, len(candidates)):
                # add the number into the combination
                comb.append(candidates[i])
                # give the current number another chance, rather than moving on
                backtrack(remain - candidates[i], comb, i)
                #print(comb)
     
                comb.pop()
                #print(comb)
        
        backtrack(target, [], 0)
        
        return results
