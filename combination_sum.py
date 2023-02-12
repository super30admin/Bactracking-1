# Time Complexity :
# O(2^(M+N)) - N is the number of candidates and M is the target

# Space Complexity :
# O(M+N) - max Stack depth

# Did this code successfully run on Leetcode :
#Yes

#For each candidate - we have 2 choices, we either select it or we don't. When we select it, we reduce the target and call the same function on the reduced target
#If we do not select a candidate, we increase index(thereby reducing the options in candidates) and we call the recursion on the same target but smaller number of candidates
#If out target sum is 0, we create a new array and add it to the result. If target is negative or we are out of candidates, then it is not possible to find a sequence of numbers in this path so we return

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        self.get_path(candidates,target,[],0)
        return self.result

    def get_path(self,candidates,target,curr_path,curr_index):
        #Base case 
        if target == 0 :
            self.result.append(curr_path[:])
            return 

        if target < 0 or curr_index == len(candidates):
            return

        #Normal case 
        #not selecting 
        self.get_path(candidates,target,curr_path[:],curr_index+1)

        #selecting
        curr_path.append(candidates[curr_index])
        self.get_path(candidates,target-candidates[curr_index],curr_path,curr_index)
        curr_path.pop(-1)
