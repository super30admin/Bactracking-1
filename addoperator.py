class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num or len(num) == 0: return List[str]
        self.result = []

        def helper(calc: int, index: int, tail: int, path: str) -> None:

            if index == len(num) and target == calc:
                self.result.append(path)
                return
            for idx in range(index, len(num) + 1):
                curr_str = num[index:idx + 1]
                cur = int(curr_str)
                if

                if index == 0:
                    helper(calc=curr, index=idx + 1, tail=curr, path=path + curr)
                else:
                    helper(calc=curr + curr, index=idx + 1, tail=curr, path=path + '+' + curr)
                    helper(calc=curr - curr, index=idx + 1, tail=curr, path=path + '-' + curr)
                    helper(calc=curr - tail + tail * curr, index=idx + 1, tail=curr * tail, path=path + '*' + curr)

        helper(calc=0, index=0, tail=0, path='')

        return self.result


