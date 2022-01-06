# Time: Exponential
# Space: Exponential
class Solution(object):
    def __init__(self):
        self.ans = []
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.helper(num, 0, 0, target, 0, '')
        return self.ans
    def helper(self, num, prev_sum, tail, target, ind, path):
        #print(path, prev_sum)
        if ind == len(num):
            if prev_sum == target:
                #print('YES')
                self.ans.append(path)
            return
        for i in range(ind, len(num)):
            if num[ind] == '0' and ind != i:
                continue
            curr = int(num[ind:i+1])
            if ind == 0:
                self.helper(num, prev_sum+curr, curr, target, i+1, path+str(curr))
            else:
                # +
                self.helper(num, prev_sum+curr, curr, target, i+1, path+'+'+str(curr))
                # -
                self.helper(num, prev_sum-curr, -1*curr, target, i+1, path+'-'+str(curr))
                # *
                #print(prev_sum, tail, curr)
                temp = (prev_sum - tail) + (tail*curr)
                #print(temp, path+'*'+str(curr))
                #print('$'*100)
                self.helper(num, temp, tail*curr, target, i+1, path+'*'+str(curr))
        
        
        
        
