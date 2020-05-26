#Problem 1: Combination Sum
#Time Complexity: O(n)
#Space complexity: O(h) , size of the memory array
#Worked on leetcode? Yes

'''
Very similar to coin change problem. We can visualize the problem as a binary Tree
with each children node being a boolean choice of the first candidate in array.
If we choose to no use that candidate, we don't use it anymore for the rest of the
tree. We do it this way to avoid duplicates in the tree.
'''
'''
The brute force solution
would be to visit traverse each branch from the top, if it adds up to target
at some point we add the branch to res.
'''

'''
A better way to do this would be to backtrack in the tree as soon as we exceed or is equal
to 11 while keeping a memory of what's in the present branch and add to result to res.
This way we only visit each node once and don't visit useless branches. We will
keep a local sum variable,local candidate idx and a global array variable that
will be poped and appended accordingly (we make a copy of it when we append to res).
'''

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        #edge case:
        if not candidates or not target:
            return []

        res=[]
        memory=[]
        def helper(target,candidate_idx,choose):
            if candidate_idx==len(candidates):
                return
            if choose:
                memory.append(candidates[candidate_idx])
                next_target=target-candidates[candidate_idx]
                if next_target==0:
                    #crucial that we append a copy of memory and not reference!!!
                    res.append(memory[:])
                    memory.pop()
                    return
                if next_target<0:
                    memory.pop()
                    return
            else:
                next_target=target
            helper(next_target,candidate_idx,True)
            helper(next_target,candidate_idx+1,False)
            if choose:
                memory.pop()


        helper(target,0,False)

        return res
