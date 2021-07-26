class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        ret = []
        def dfs(subtotal, last, path, start):
            if start == len(num):
                if subtotal == target:
                    ret.append(''.join(path))
                return
            for i in range(start, len(num)):
                ch = num[start:i + 1]
                if len(ch) > 1 and ch[0] == '0':
                    continue
                integer = int(ch)
                if not path:
                    dfs( integer, integer, [ch], i + 1 )
                else:
                    dfs( subtotal + integer, integer, path + ['+', ch], i + 1 )
                    dfs( subtotal - integer, -integer, path + ['-', ch],i + 1 )
					# the most interesting part:
					# e.g. 1+2*3, we record last as 2, so: 3-2+2*3 = 7
                    dfs( subtotal - last + last * integer, last * integer, path + ['*', ch], i + 1 ) 
        dfs(0, 0, [], 0)
        return ret