class Solution:
	# Time complexity : exponential but what is the exact value : n^k or k^n if so what is n and what is k?
	def combinationSum(self, candidates, target):
		if len(candidates) == 0:
			return []
		result = []
		candidates.sort()
		def helper(result, candidates, path, target, index):
			if target == 0:
				result.append(path[:])
			for i in range(index, len(candidates)):
				if candidates[i] > target:
					break
				path.append(candidates[i])
				helper(result, candidates, path, target - candidates[i], i)
				path.pop()
		helper(result, candidates, [], target, 0)
		return result

if __name__ == '__main__':
	cs = Solution()
	print(cs.combinationSum([2,3,6,7], 7))