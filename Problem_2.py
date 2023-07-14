# Time Complexity: O(n * (4^(n-1)))
# Space Complexity: O(n^2)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        ans = []
        def dfs(start, prev, eval, path):
            if start == len(num):
                if eval == target:
                    ans.append(''.join(path))
                return
            for i in range(start, len(num)):
                if (i > start) and (num[start] == '0'):
                    return
                s = num[start:(i + 1)]
                curr = int(s)
                if start == 0:
                    path.append(s)
                    dfs((i + 1), curr, curr, path)
                    path.pop()
                else:
                    for op in ['+', '-', '*']:
                        path.append(op + s)
                        if op == '+':
                            dfs((i + 1), curr, (eval + curr), path)
                        elif op == '-':
                            dfs((i + 1), -curr, (eval - curr), path)
                        else:
                            dfs((i + 1), (prev * curr), ((eval - prev) + (prev * curr)), path)
                        path.pop()
        dfs(0, 0, 0, [])
        return ans