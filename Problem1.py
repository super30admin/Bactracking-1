# Time Complexity : O(LxN) (Where L is length of array and M is target value)
# Space Complexity : O(LxN) (Where L is length of array and M is target value)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Make helper function to find the solution using backtrack.
# - Try every element combination to see if that combination sums up to target. 
# - make three cases. first: if combination is eqaul to target apend it to the answer, second: If combination is greater than target return. Third: If combination is less than target try next combination.
class Solution(object):
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
#       Initilize answer List
        answer = []
#       Call helper function with list of number, answer list, temp list, target and starting index 0.
        self.backtrack(candidates, answer, [], target, 0)
#       Return answer list
        return answer
    
    def backtrack(self, candidates, answer, temp, remain, index):
#       If target becomes less than zero that means combination of number exceeds target so return
        if remain < 0:
            return
#       If target is 0 that means combination of number makes up the target so add it to answer list.
        elif remain == 0:
            answer.append(temp)
#       In else case combination of number is less than target
        else:
#       Run for loop on all the number starting with index to last element
            for i in range(index, len(candidates)):
#               Call backtrack function on each of this element, add that element to the temp list and reduce target by that element. Provide starting index same as i because we want to repeat the same element too.
                self.backtrack(candidates, answer, temp + [candidates[i]], remain - candidates[i], i)
        
