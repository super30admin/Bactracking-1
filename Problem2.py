class Solution:
	# Time complexity : exponential but what is the exact value : n^k or k^n if so what is n and what is k?
	def addOperators(self, num: str, target: int) -> List[str]:
		res = []
		if len(num) == 0:
			return res
		self.helper(res, num, "", target, 0, 0, 0)
		return res
	
	def helper(self, res, num, path, target, index, calculatedValue, tail):
		if index == len(num):
			if calculatedValue == target:
				res.append(path)
			return
		for i in range(index, len(num)):
			if i != index and num[index] == "0":
				break
			cur = int(num[index:i + 1])
			if index == 0:
				self.helper(res, num, path + str(cur), target, i + 1, cur, cur)
			else:
				self.helper(res, num, path + "+" + str(cur), target, i + 1, calculatedValue + cur, cur)
				self.helper(res, num, path + "-" + str(cur), target, i + 1, calculatedValue - cur, -cur)
				self.helper(res, num, path + "*" + str(cur), target, i + 1, calculatedValue - tail + tail * cur, cur * tail)