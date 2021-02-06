'''
    Time Complexity:
        O(N*4^N) (where N = length of the num string)

    Space Complexity:
        O(N^N) (where N = length of the num string)
        (because we build substrings and then convert them into int)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Backtracking.
        Add/Subtract the current number to the already calculated number.
        Keep track of tail to handle multiplication case.
        Handle the case for '05', '005', etc getting converted to 5.
'''

class Solution:
    def __init__(self):
        self.num = ''
        self.target = 0
        self.possibilities = []

    def addOperators(self, num: str, target: int) -> List[str]:
        self.num = num
        self.target = target
        self.generate_possibilities(0, 0, 0, [])
        return self.possibilities

    def generate_possibilities(self, idx, calculated, tail, possibility):
        if idx == len(self.num):
            if calculated == self.target:
                self.possibilities.append(''.join(possibility))

            return

        for i in range(idx, len(self.num)):
            if i != idx and self.num[idx] == '0':
                break

            curr = int(self.num[idx:i+1])

            if idx == 0:
                self.perform_operation(i + 1, curr, curr, curr, possibility)
                continue

            self.perform_operation(i + 1, curr, calculated, tail, possibility, '+')
            self.perform_operation(i + 1, curr, calculated, tail, possibility, '-')
            self.perform_operation(i + 1, curr, calculated, tail, possibility, '*')


    def perform_operation(self, idx, curr, calculated, tail, possibility, operator=None):
        if operator: possibility.append(operator)
        possibility.append(str(curr))

        if operator == '+':
            calculated = calculated + curr
            tail = curr

        elif operator == '-':
            calculated = calculated - curr
            tail = -curr

        elif operator == '*':
            calculated = calculated - tail + tail * curr
            tail = tail * curr

        self.generate_possibilities(idx, calculated, tail, possibility)

        possibility.pop()
        if operator: possibility.pop()
