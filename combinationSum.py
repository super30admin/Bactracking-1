# // Time Complexity : O(2^n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Three line explanation of solution in plain english

# // Your code here along with comments explaining your approach


class solution:

    def combination(self, candidates, target):
        self.result = []
        self.helper(candidates, [], 0, target, 0)
        return self.result

    def helper(self,candidates, path, currSum, target, idx):
        '''
        In this method, at every index of candidates we have a choice of choosing the number and not choosing the number. 

        if we choose the number then we add it tot he path and increase the sum and keep the same index. and if we dont choose it. we pop the candiate from path

        keep the sum same and increase the idx by 1 to ove to next element
        '''

        ##base
        if currSum == target:
            self.result.append(copy.deepcopy(path))
            return
        
        if currSum > target or idx >= len(candidates):
            return 
        ##logic

        path.append(candidates[idx])
        new_sum = currSum+ candidates[idx]
        self.helper(candidates, path, new_sum, target, idx)
        path.pop()
        self.helper(candidates, path, currSum, target, idx+1)
    
    def forloop_helper(self, candidates, currSum, target, pos, path):
        '''
        in for loop based recursion, we recurse from idx to end of candidates. we add a new candidate to path and continue recusrion  and in case of no choose we remove the path and move to next
        element. 

        '''
        if currSum == target:
            self.result.append(copy.deepcopy(path))
        
        if currSum > target or pos >= len(candidates):
            return 

        for i in range(pos, len(candidates)):
            
            path.append(candidates[i])
            new_sum= currSum+candidates[i]
            self.forloop_helper(candidates, new_sum, target, i, path)
            path.pop()




