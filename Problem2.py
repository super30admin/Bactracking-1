# Time Complexity : O(4^n),  as we have 4 operations, do nothing and add substring, plus, minus and * 
# Space Complexity : O(4^n), as we have 4 operations, do nothing and add substring, plus, minus and * 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# 1) If we have a zero in our string, doing an int(curr) will elimate the zero, and we dont want to skip any element
#    so for this case, if our num[index] is pointing to a zero, and i is iterating like 02,03,04 , just break 
#    We dont want to do any operation as doing so will elimated the zero. 
# 2) for any operation, we need a head and a tail. Head being the calc. This is to follow BODMAS rule to maintain the 
#    operator precedence. 

class Solution:
    result = None
    def addOperators(self,num,target):
        self.result = []
        if not num or len(num) == 0:
            return self.result 
        self.dfs(num,target,0,0,0,'')
        return self.result 
    
    def dfs(self,num,target,calc,tail,indx,path):
        # Base case 
        if indx == len(num):
            if calc == target:
                self.result.append(path)
                return 
        # logic 
        for i in range(indx,len(num)):
            curr = int(num[indx:i+1])
            if indx != i and num[indx] == '0':
                break 
            if indx == 0:
                self.dfs(num, target, curr, curr, i+1, path + str(curr))
            else:
                self.dfs(num, target, calc + curr, +curr, i+1, path + '+' + str(curr))
                self.dfs(num,target, calc - curr, -curr, i+1, path + '-' + str(curr))
                self.dfs(num, target, calc - tail + tail * curr, tail * curr, i+1, path + '*' +str(curr))
                # self.dfs(num, target, calc-tail + tail/curr, tail/curr, i+1, path + '/'+str(curr)) # Division 
    
    
    
if __name__ == "__main__":
    s = Solution()
    num = "162"
    target = 4
    res = s.addOperators(num,target)
    print(res)