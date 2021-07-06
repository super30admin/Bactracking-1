class Solution:
    # Approach 1: Recursive....
    """
    TC: O(N*4^N)
    SC: O(N)
    """
    """
    def __init__(self):
        self.result = []
        self.target = None
    def addOperators(self, num: str, target: int) -> List[str]:
        self.target = target
        self.helper(num, 0, "", 0, 0)
        return self.result

    def helper(self, num, index, path, calc, tail):
        #base
        if index == len(num) and calc == self.target:
            self.result.append(path)
            return

        #logic
        for i in range(index, len(num)):
            # preceeding zero edge case
            if num[index] == '0' and i != index: continue

            curr = num[index:i+1]
            if index == 0:
                #root node
                self.helper(num, i+1, path + curr, int(curr), int(curr))
            else:
                # + operator
                self.helper(num, i+1, path + '+' + curr, calc + int(curr) , int(curr))
                # - operator
                self.helper(num, i+1, path +  '-' + curr, calc - int(curr) , -1*int(curr))
                # * operator
                self.helper(num, i+1, path +  '*' + curr, calc-tail + tail * int(curr), tail * int(curr))
    """

    # Approach 2: Backtracking...

    def __init__(self):
        self.result = []
        self.target = None

    def addOperators(self, num: str, target: int) -> List[str]:
        self.target = target
        self.helper(num, 0, [], 0, 0)
        return self.result

    def helper(self, num, index, path, calc, tail):

        # base
        if index == len(num) and calc == self.target:
            self.result.append("".join(path))
            return

        # logic
        for i in range(index, len(num)):
            # preceeding zero edge case
            if num[index] == '0' and i != index: continue

            curr = num[index:i + 1]

            if index == 0:
                # root node
                path.append(curr)  # action
                self.helper(num, i + 1, path, int(curr), int(curr))  # recurse
                path.pop()
            else:
                # + operator
                path.append('+')  # action
                path.append(curr)  # action
                self.helper(num, i + 1, path, calc + int(curr), int(curr))
                path.pop()
                path.pop()

                # - operator
                path.append('-')  # action
                path.append(curr)  # action
                self.helper(num, i + 1, path, calc - int(curr), -1 * int(curr))
                path.pop()
                path.pop()

                # * operator
                path.append('*')  # action
                path.append(curr)  # action
                self.helper(num, i + 1, path, calc - tail + tail * int(curr), tail * int(curr))
                path.pop()
                path.pop()