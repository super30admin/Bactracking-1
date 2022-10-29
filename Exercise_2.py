# Time Complexity: O(n*2^n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No


class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        
        if num == None or len(num) == 0:
            return result
        
        def helper(index, path, calc, tail):
            #base
            if index==len(num):
                if calc==target:
                    result.append(path)
                return
            
            #logic
            for i in range(index, len(num)):
                if index!=i and num[index]=='0':
                    continue
                curr = int(num[index:i+1])
                if index==0:
                    helper(i+1, path+str(curr), curr, curr)
                else:
                    helper(i+1, path+ '+' +str(curr), calc+curr, curr)
                    helper(i+1, path+ '-' +str(curr), calc-curr, (-1)*curr)
                    helper(i+1, path+ '*' +str(curr), calc-tail+tail*curr, tail*curr)
        
        helper(0, '', 0, 0)
        
        return result
                    