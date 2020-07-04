class Solution:
	def addOperators(self, num: str, target: int) -> List[str]:
		result = []
		if not num:
			return result
		calc, tail, index = 0,0,0
		path = ''
		self.recursive(num, target, path, calc, tail, index, result)
		return result
	
	def recursive(self, num, target, path, calc, tail, index, result):
		#base
		if index==len(num):
			if target == calc:
				result.append(path)
			return
		#logic
		for i in range(index, len(num)):
			#preceeding zero
			if num[index]=='0' and index!=i:
				break
			curr = int(num[index:i+1])
			if index == 0:
				self.recursive(num, target, path+str(curr), curr, curr, i+1, result)
			else:
				#+
				self.recursive(num, target, path+'+'+str(curr), calc+curr, curr, i+1, result)
				#-
				self.recursive(num, target, path+'-'+str(curr), calc-curr, -curr, i+1, result)
				#*
				self.recursive(num, target, path+'*'+str(curr), (calc-tail)+(tail*curr), (tail*curr), i+1, result)


#time complexity - O(4^n) as there's 4 choices for every step

#space complexity - O(n) as there's temp path for every iteration

#all test cases passed