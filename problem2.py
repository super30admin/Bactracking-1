# Time Complexity: O(4^N)  N is the length of the string.
# Space Complexity: O(N)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.target = target
        self.helper(num, 0, 0, 0, "")
        return self.result

    def helper(self, num: str, index: int, calc: int, tail: int, path: str):
        # Base Case
        if index == len(num):
            if calc == self.target:
                self.result.append(path)
            return

        # Recursive Logic
        for i in range(index, len(num)):
            if i > index and num[index] == '0':
                break

            curr_str = num[index:i+1]
            curr_num = int(curr_str)

            if index == 0:
                self.helper(num, i + 1, curr_num, curr_num, curr_str)
            else:
                # Addition
                self.helper(num, i + 1, calc + curr_num, curr_num, path + '+' + curr_str)
                # Subtraction
                self.helper(num, i + 1, calc - curr_num, -curr_num, path + '-' + curr_str)
                # Multiplication
                self.helper(num, i + 1, calc - tail + tail * curr_num, tail * curr_num, path + '*' + curr_str)

