class Solution:
	def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
		if not candidates:
			return []
		result, temp = [], []
		curr_sum = 0
		index = 0
		self.recursive(candidates, target, result, temp, index, curr_sum)
		return result
	
	def recursive(self,candidates, target, result, temp, index, curr_sum):
		if curr_sum>target or index == len(candidates):
			return
		if curr_sum==target:
			result.append(temp.copy())
			return
		
		#not choose
		self.recursive(candidates, target, result, temp.copy(), index+1, curr_sum)
		#choose
		temp.append(candidates[index])
		self.recursive(candidates, target, result, temp.copy(), index, curr_sum+candidates[index])

#time complexity - O(2^n) as we go through every choice

#space complexity - O(n*2^n) ~ O(2^n) as a new list is created at every decision made

#all testcases passed