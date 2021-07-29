class Solution:
    def addOperators(self, num, target) :
        result = []
        if len(num) == 0:
            return result
        self.helper(result, num, target, "", 0, 0, 0)
        return result

    def helper(self, result, num, target, path, index, calc, tail):
        # Base
        if index == len(num):
            if calc == target:
                result.append(path)
                return

        # logic
        for i in range(index, len(num)):
            # Preeceeding 0
            if index != i and num[index] == "0":
                break

            curr = int(num[index:i + 1])
            if index == 0:
                self.helper(result, num, target, path + str(curr), i + 1, curr, curr)
            else:
                # "+"
                self.helper(result, num, target, path + "+" + str(curr), i + 1, calc + curr, curr)

                # "-"
                self.helper(result, num, target, path + "-" + str(curr), i + 1, calc - curr, -curr)

                # "*"
                self.helper(result, num, target, path + "*" + str(curr), i + 1, calc - tail + tail * curr, tail * curr)