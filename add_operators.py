# Doesn't run on leetcode

# Could you help me with this


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if not num:
            return []
        self.result = []
        self.helper(num, target, "", 0, 0, 0)
        return self.result
    
    def helper(self, num, target, path, index, calculated, tail):
        if index > len(num):
            return
        if calculated == target and index == len(num):
            self.result.append(path)
        if calculated > target:
            return

        for i in range(index,len(num)):
            if i != index and num[index] == '0':
                break
            cur = num[index:i+1]
            if index == 0:
                self.helper(num, target, num[0], i+1, int(cur), int(cur))
            self.helper(num, target, path+'+'+cur, i+1, calculated+int(cur), int(cur))
            self.helper(num, target, path+'-'+cur, i+1, calculated-int(cur), -int(cur))
            self.helper(num, target, path+'*'+cur, i+1, (calculated-tail)+(tail*int(cur)), int(cur))
