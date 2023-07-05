class Solution:
  def addOperators(self, num: str, target: int) -> List[str]:
    ans = [] # list to store all possible expressions that evaluate to the target

    # DFS function to generate all possible expressions
    # start: current index in num
    # prev: previous operand value
    # eval: current evaluated value
    # path: list to store current expression
    def dfs(start: int, prev: int, eval: int, path: List[str]) -> None:
      # base case: reached end of num
      if start == len(num):
        # check if current evaluation equals target
        if eval == target:
          # add current expression to the answer list
          ans.append(''.join(path))
        return

      # iterate over all possible operands from current index
      for i in range(start, len(num)):
        # special case: ignore operands starting with 0, except 0 itself
        if i > start and num[start] == '0':
          return
        s = num[start:i + 1]
        curr = int(s)
        # special case: first operand, simply add it to the path and evaluate
        if start == 0:
          path.append(s)
          dfs(i + 1, curr, curr, path)
          path.pop()
        # general case: iterate over all possible operators and operands
        else:
          for op in ['+', '-', '*']:
            path.append(op + s)
            # addition: add current operand to evaluated value
            if op == '+':
              dfs(i + 1, curr, eval + curr, path)
            # subtraction: subtract current operand from evaluated value
            elif op == '-':
              dfs(i + 1, -curr, eval - curr, path)
            # multiplication: multiply current operand with previous operand and update evaluated value
            else:
              dfs(i + 1, prev * curr, eval - prev + prev * curr, path)
            path.pop()

    # start DFS with initial parameters
    dfs(0, 0, 0, [])
    return ans