d# // Time Complexity : Confused about it
# // Space Complexity : Confused Still
# // Did this code successfully run on Leetcode : No I don't know what is going wrong but the limit exceeded for this 
# // Any problem you faced while coding this : Followed approach from class but have to watch the class again for better understanding 
# // Your code here along with comments explaining your approach
class Solution:
    def Util(self, num, target, ind, l, mem, exp):
        if ind == l - 1:
            exp += num[ind]
            if eval(exp) == target:
                return [exp]
        if ind >= l:
            return []
        ret1 = self.Util(num, target, ind + 1, l, mem, exp + str(num[ind]) + '+')
        ret2 = self.Util(num, target, ind + 1, l, mem, exp + str(num[ind]) + '-')
        ret3 = self.Util(num, target, ind + 1, l, mem, exp + str(num[ind]) + '*')
        if (exp and exp[-1].isdigit() is True and num[ind] == '0') or num[ind] != '0':
            ret4 = self.Util(num, target, ind + 1, l, mem, exp + str(num[ind]))
            ret = ret1 + ret2 + ret3 + ret4
        else:
            ret = ret1 + ret2 + ret3
        return ret
        
    def addOperators(self, num: str, target: int) -> List[str]:
        return self.Util(num, target, 0, len(num), dict(), '')