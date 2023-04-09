# TC: O(N * 4^N)
# SC: O(N)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        def backtrack(idx, total, last, string):
            if idx == len(num):
                if total == target:
                    res.append(string)
                    return

            for i in range(idx, len(num)):
                n = int(num[idx:i+1])
                if idx == 0:
                    backtrack(i+1, n, n, str(n))
                else:
                    backtrack(i+1, total + n, n, string + '+' + str(n))
                    backtrack(i+1, total - n, -n, string + '-' + str(n))
                    backtrack(i+1, total - last + last * n, last * n, string + '*' + str(n))
                if n == 0:
                    break

        backtrack(0, 0, 0, "")
        return res