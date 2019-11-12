# Passed on leetcode(282)
# time complexity - O(4^N) as we have 4 operators at every point.
# Here we are doing 4 operations at every point(+,-,* and no operator) and checking if the output matches the target.
class Solution:
    def addOperators(self, num: str, target: int):
        if len(num) == 0: return []
        result = []
        self.backtrack(result,"", num, target, 0, 0, 0) # call helper
        return result
    def backtrack(self, result, path, num, target, index, calculated, tail):
        # Base case
        if index == len(num):
            if calculated == target:
                print(path)
                result.append(path)
            return
        # Logic
        for i in range(index, len(num)):
            # if we have a preceding zero like: "0105" then ignore "0" and take it as "105"(break in that case)
            if i != index and num[index] == "0":
                break;
            curr = int(num[index:i + 1]) # to take the substring at everypoint(not using any operator)
            if index == 0:
                self.backtrack(result, path+str(curr), num, target, i+1, curr, curr) # for no operator.
            else:
                self.backtrack(result, path + '+' + str(curr), num, target, i+1, calculated + curr, curr) # for add
                self.backtrack(result, path + '-' + str(curr), num, target, i+1, calculated - curr, -curr) # for substraction
                self.backtrack(result, path + '*' + str(curr), num, target, i+1, calculated-tail+tail*curr, tail *curr) # for multiply

sol = Solution()
print(sol.addOperators("123", 6))