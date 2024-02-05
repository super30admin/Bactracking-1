#Time Complexity : O(3^N), where N is the length of the input string num
#Space Complexity :O(N)
#Did this code successfully run on Leetcode : yes


from ast import List


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        self.helper(num, 0, target, "", 0, 0, result)
        return result
    
    def helper(self, num, pivot, target, path, cal, tail, result):
        if pivot == len(num):
            if cal == target:
                result.append(path)
            return
        
        for i in range(pivot, len(num)):
            if i != pivot and num[pivot] == '0':
                break
            curr = int(num[pivot:i+1])
            if pivot == 0:
                self.helper(num, i + 1, target, path + str(curr), curr, curr, result)
            else:
                self.helper(num, i + 1, target, path + '+' + str(curr), cal + curr, curr, result)
                self.helper(num, i + 1, target, path + '-' + str(curr), cal - curr, -curr, result)
                self.helper(num, i + 1, target, path + '*' + str(curr), cal - tail + tail * curr, tail * curr, result)


sol = Solution()
print(sol.addOperators("123", 6))  



