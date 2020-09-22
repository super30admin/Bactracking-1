# Time Complexity : O(N*(3^N)), 3 branches going N times
# Space Complexity : O(1), without recursive stack
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach

class Solution:
    
    def addOperators(self, num: str, target: int) -> List[str]:
            
        output = []
        #using backtracking to find all possibilities, multiple outputs 
        self.backTracking(output, num, 0, target, '', 0, 0)
        
        return output
        
        
    def backTracking(self, output, num, index, target, expr, prevSum, prevAdd):
        
        #base case
        if index >= len(num):
            if prevSum == target:
                output.append(expr)
            return 
        
        #for all possible combination of numbers, iterate:
        for i in range(index, len(num)):
            
            curr = int(num[index:i+1])
            
            #skipping the cases where not all strings are being used
            if num[index] == '0' and i !=index:
                continue
            
            #case when there is only root in the tree, no other digit to +/-/*
            if index == 0:
                self.backTracking(output, num, i+1, target, expr+str(curr), curr, curr)
            else:
                
                # operators
                # +, simply add
                self.backTracking(output, num, i+1, target, expr+'+'+str(curr), prevSum + curr, curr)

                # -, simply subtract
                self.backTracking(output, num, i+1, target, expr+'-'+str(curr), prevSum - curr, curr*-1)

                # *, subtract the value of prevAdd from prevSum, multiply current valueto the prevAdd
                # this is done as we do not have the list of all strings till that point, hence direct 
                # multiplication with prevSum would result in incorrect sum
                self.backTracking(output, num, i+1, target, expr+'*'+str(curr), prevSum - prevAdd + prevAdd*curr, prevAdd*curr)
        