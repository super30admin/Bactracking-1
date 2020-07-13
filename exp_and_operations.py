

# Time Complexity : Add - O(4^n)
# Space Complexity :O(4^n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. There are 4 choices : 1. Just concatanate, 2. Add '+' , 3. Subtract '-', 4. Multilply '*'
2. For each operation we maintain current and tail. For 1st operation the current and tail is same as number
3. We keep on adding the path, and updating the calc, and tail
4. When index==len(num), and calculated value == target, we store the path to global list and return
'''

class Solution:
    
    result = []
    def addOperators(self, num: str, target: int) -> List[str]:
        
        if not num or len(num) < 1:
            return
        
        self.result = []
        self._backtrack(num, target, "", 0,0,0)
        return self.result
        
        
    def _backtrack(self, num, target, path, calc, tail, index):
        
        if index == len(num):
            if calc == target:
                self.result.append(path)
                
            return
        
        for i in range(index, len(num)):
            
            if num[index] == '0' and index != i:
                break
                
            cur_cal = int(num[index:i+1])
            if index == 0:
                self._backtrack(num, target, path+str(cur_cal), cur_cal, cur_cal, i+1)
                
            else:
                
                self._backtrack(num, target, path+"+"+str(cur_cal), calc + cur_cal, cur_cal, i+1)
                
                self._backtrack(num, target, path+"-"+str(cur_cal), calc-cur_cal, -cur_cal, i+1)
                
                self._backtrack(num, target, path+"*"+str(cur_cal), (calc - tail)+(tail * cur_cal), tail * cur_cal, i+1)
        