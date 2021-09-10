class Solution:
    """
    TC: O(total number of combinations^3)
    SC: O(total number of valid expressions + max length of an expression)
    """

    def addOperators(self, num: str, target: int) -> List[str]:

        if len(num) == 0:
            return None

        output = []

        def backtrack(num, target, index, prevSum, prevAdd, exp):

            # if all the elements are considered
            # and prevSum is equal to the target
            if index >= len(num):
                if prevSum == target:
                    output.append(exp)
                return

            for i in range(index, len(num)):

                # get the curr elem
                curr = int(num[index: i+1])

                # to avoid multiplication by 0 when it is in between other digits
                if num[index] == "0" and i != index:
                    continue

                if index == 0:
                    backtrack(num, target, i+1, curr, curr, exp + str(curr))
                else:
                    # "+"
                    backtrack(num, target, i+1, prevSum + curr, curr,
                              exp + "+" + str(curr))

                    # "-"
                    backtrack(num, target, i+1, prevSum - curr, curr * -1,
                              exp + "-" + str(curr))

                    # "*"
                    backtrack(num, target, i+1, prevSum - prevAdd + (prevAdd * curr),
                              prevAdd * curr, exp + "*" + str(curr))

        backtrack(num, target, 0, 0, 0, "")

        return output
