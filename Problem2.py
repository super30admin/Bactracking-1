class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []
        
        def backtracking(i, index, prevSum, prevAdd):
            if index == len(num) and prevSum == target:
                return res.append(i)
            for j in range(index+1,len(num)+1):
                s = num[index:j]
                d = int(s)
                if num[index]=='0' and s!='0':
                    continue
                if not i:
                    backtracking(s,j,d,d)
                else:
                    backtracking(i + '+' +s, j, prevSum+d, d)
                    backtracking(i + '-' +s, j, prevSum-d, -d)
                    backtracking(i + '*' +s, j, prevSum-prevAdd+prevAdd*d, prevAdd*d)
        backtracking('', 0,0,0)
        return res
