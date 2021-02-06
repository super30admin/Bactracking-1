'''
    Time Complexity:
        O(N^N) (where N = length of the candidates array)

    Space Complexity:
        O(N) (where N = length of the candidates array)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking.
'''

class Solution:
    def __init__(self):
        self.candidates = []
        self.combinations = []

    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.candidates = candidates
        self.generate_combinations(target, [], 0)
        return self.combinations

    def generate_combinations(self, curr_sum, curr, idx):
        if curr_sum < 0:
            return

        if curr_sum == 0:
            self.combinations.append(copy.deepcopy(curr))
            return

        for i in range(idx, len(self.candidates)):
            num = self.candidates[i]
            curr.append(num)
            self.generate_combinations(curr_sum - num, curr, i)
            curr.pop()
