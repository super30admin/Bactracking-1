# TC - O(4^n) because, for each digit in the input num, the algorithm explores four possibilities: addition, subtraction, and multiplication.
# SC - O(n + 3^(n-1)) 

# The code uses a recursive depth-first search (DFS) approach to explore all possible combinations of operators between digits.
# It considers three operators: addition (+), subtraction (-), and multiplication (*)
# The DFS function (dfs) is called recursively for each choice of operator, and the current expression is updated accordingly.
# The base case of the recursion is when all digits in num are processed (i == len(num)), and the current expression evaluates to the target.
    
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def dfs(i, path, cur_num, prevNum):
            if i == len(num):
                if cur_num == target:
                    res.append(path)
                return

            for j in range(i, len(num)):
                # starting with zero?
                if j > i and num[i] == '0':
                    break
                n = int(num[i:j+1])

                # if cur index is 0 then simple add that number
                if i == 0:
                    dfs(j + 1, path + str(n), cur_num + n, n)
                else:
                    dfs(j + 1, path + "+" + str(n), cur_num + n, n)
                    dfs(j + 1, path + "-" + str(n), cur_num - n, -n)
                    dfs(j + 1, path + "*" + str(n), cur_num - prevNum + prevNum * n, prevNum * n)

        dfs(0, "", 0, 0)
        return res