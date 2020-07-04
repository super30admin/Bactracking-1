class Solution:
	def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
		result = []
		if not candidates:
			return result
		self.backtrack(candidates, target, [], 0, 0, result)
		return result
	
	def backtrack(self, candidates, target, temp, index, curr_sum, result):
		if curr_sum>target:
			return
		if curr_sum == target:
			result.append(temp.copy())
			return
		
		for i in range(index, len(candidates)):
			#action
			temp.append(candidates[i])
			#recurse
			self.backtrack(candidates, target, temp, i, curr_sum+candidates[i], result)
			#backtrack
			temp.pop()

#time complexity - O(2^n) as at every step we have 2 choices to choose or not choose

#space complexity - O(2^n) as we maintain a temp at every stage

#all test cases passed