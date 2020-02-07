# Time Complexity : Expnential
# Space Complexity : Recusrive Stack O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.result = []
        self.__helper('', num, target, 0, 0, 0)
        return self.result
    
    
    def __helper(self, path, num, target, index, calculated, tail):
        # Base Case
        if index == len(num) and calculated == target:
            self.result.append(path[:])
            return
        

        # Logic
        for i in range(index, len(num)):
            if i!=index and num[index] == '0':
                break
            curr = int(num[index:i+1])
            if index == 0:
                self.__helper(path + str(curr), num, target, i+1, curr, curr)
            else:
                # print(path + '+' + curr)
                self.__helper(path + '+' + str(curr), num, target, i+1, calculated+curr, +curr)
                self.__helper(path + '-' + str(curr), num, target, i+1, calculated-curr, -curr)
                self.__helper(path + '*' + str(curr), num, target, i+1, calculated-tail + tail*curr, tail*curr)