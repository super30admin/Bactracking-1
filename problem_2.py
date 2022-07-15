# Time Complexity : O(L*4^l) --> exponential.
# Space Complexity : O(L);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def helper(self, num, target, index, path, calculated, tail):
        # base
        if index == len(num):
            if calculated == target:
                self.result.append(''.join(path))
            return
        # logic
        for i in range(index, len(num)):
            if num[index] != '0' or index == i:
                curr = num[index:i+1]
                if index == 0:
                    path.append(curr)
                    self.helper(num, target, i + 1, path, calculated + int(curr), int(curr))
                    path.pop()
                else:
                    path.append('+')
                    path.append(num[i])
                    self.helper(num, target, i + 1, path, calculated + int(curr), int(curr))
                    path.pop()
                    path.pop()

                    path.append('-')
                    path.append(num[i])
                    self.helper(num, target, i + 1, path, calculated - int(curr), -1 * int(curr))
                    path.pop()
                    path.pop()

                    path.append('*')
                    path.append(num[i])
                    self.helper(num, target, i + 1, path, (calculated - tail) + (tail * int(curr)), tail * int(curr))
                    path.pop()
                    path.pop()

    def addOperators(self, num: str, target: int) -> list[str]:
        self.result = []
        self.helper(num, target, 0, [], 0, 0)
        return self.result


print(Solution().addOperators('123', 6))


# Using recursion
# class Solution:
#     def helper(self, num, target, index, path, calculated, tail):
#         # base
#         if index == len(num):
#             if calculated == target:
#                 self.result.append(path)
#             return
#         # logic
#         for i in range(index, len(num)):
#             if num[index] != '0' or index == i:
#                 curr = num[index:i+1]
#                 if index == 0:
#                     self.helper(num, target, i+1, path + curr, int(curr), int(curr))
#                 else:
#                     self.helper(num, target, i + 1, path + '+' + curr, calculated + int(curr), int(curr))
#                     self.helper(num, target, i + 1, path + '-' + curr, calculated - int(curr), -1*int(curr))
#                     self.helper(num, target, i + 1, path + '*' + curr, (calculated-tail)+(tail*int(curr)), tail*int(curr))

#     def addOperators(self, num: str, target: int) -> list[str]:
#         self.result = []
#         self.helper(num, target, 0, '', 0, 0)
#         return self.result
#
#
# print(Solution().addOperators('123', 6))
