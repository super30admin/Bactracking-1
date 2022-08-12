class Solution:
    result = []

    def addOperators(self, num: str, target: int):
        self.result = []
        self.helper(num, target, 0, 0, 0, path=[])
        print(self.result)
        return self.result

    def helper(self, num, target, index, calc, tail, path):
        if index == len(num):
            if calc == target:
                # print(''.join(map(str, path)), "path")
                self.result.append(''.join(map(str, path)))
            return

        for i in range(index, len(num)):
            if i != index and num[index] == "0":
                continue
            curr = int(num[index: i + 1])
            if index == 0:
                self.helper(num, target, i + 1, curr, curr, [curr])
            else:
                # print([path])
                self.helper(num, target, i + 1, calc + curr, curr, path + ["+", curr])
                self.helper(num, target, i + 1, calc - curr, -curr, path + ["-", curr])
                self.helper(num, target, i + 1, calc - tail + (tail * curr), tail * curr, path + ["*", curr])


if __name__ == "__main__":
    obj = Solution()
    obj.addOperators("123", 6)

# Time Complexity = O(4^n).
# Space complexity : O(4^n).
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
