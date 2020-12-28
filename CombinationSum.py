# Approach: Recursive

# Thinking process for this problem is same as the coin change problem with one little difference. We need to find all the combinations instead of minimum number of combinations.  So any combination that leads to our target will be added to our resultant list. 

# So if we solve this problem using recursion then at every point we need to check for two answers/paths:
# 1) Will choosing the candidate will lead to a solution
# 2) Will not choosing the candidate and moving ahead will lead to solution

# For every path above we will maintain a list that will give us a map of the numbers we have included to reach that paticular point. If those numbers add upto target than add that list numbers to resultant list


# Time complexity: Exponential 
# Space complexity: O(n * n);

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates) == 0:
            return self.result
        
        self.helper(candidates, target, 0, 0, [])
        return self.result
    
    def helper(self, candidates, target, index, cursum, temp):
        
        # base
        if index >= len(candidates) or cursum > target:
            return 
        
        if cursum == target:
            self.result.append(temp)
            return
        
        # logic
        # Do not choose
        self.helper(candidates, target, index + 1, cursum, temp.copy())
        
        # choose
        temp.append(candidates[index])
        self.helper(candidates, target, index, cursum + candidates[index], temp.copy())
        
# Approach: Backtracking (Template 1)

# Now the backtracking approach comes with little changes but it makes a big difference in space complexity. In the recurssive apporach we are maintaining/passing a different list(copy list) for each choice we make which shoots up the space complexity. 

# With backtracking we can avoid that. We can just use the same list(reference to list) again and again, which will make the space complexity capped at certain limit.

# To achieve this we what needs to happen is whenever we encounter a base condition we need to backtrack and then consider another choice. 

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates) == 0:
            return self.result
        
        self.helper(candidates, target, 0, 0, [])
        return self.result
    
    def helper(self, candidates, target, index, cursum, temp):
        
        # base
        if index >= len(candidates) or cursum > target:
            return 
        
        if cursum == target:
            self.result.append(temp.copy())
            return
        
        # logic
        # Do not choose
        self.helper(candidates, target, index + 1, cursum, temp)
        
        # choose
        temp.append(candidates[index])
        self.helper(candidates, target, index, cursum + candidates[index], temp)
        
        # backtracking
        temp.pop()

        
# Approach: Backtracking (Template 2)

# Just another way to perform backtracking. Its a standard scalable template.
# Time complexity: Exponential 
# Space complexity: O(n + m) ; n = length of given array, m = target

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        self.result = []
        if candidates == None or len(candidates) == 0:
            return self.result
        
        self.helper(candidates, target, 0, 0, [])
        return self.result
    
    def helper(self, candidates, target, index, cursum, temp):
        if cursum > target:
            return  
        
        if cursum == target:
            self.result.append(temp.copy())
            return
        
        for i in range(index, len(candidates)):
            temp.append(candidates[i])
            print("Index:", index, end= " ")
            print("Sum: ", cursum)
            self.helper(candidates, target, i, cursum + candidates[i], temp)
            temp.pop()
        

# Here if we observe closely, we have changed the structure of the tree. Here we keep choosing the element and if we hit the base condition, we will return. So our structure look something like this now

#                       [2  ,   3,      6       7]
#                       /
#                      [2]
#                      /
#                   [2,2]
#                     /
#                  [2,2,2], [2,2,3]*, [2,2,6], [2,2,7]
#                     /
#                 [2,2,2,2], [2,2,2,3], [2,2,2,6], [2,2,2,7]
#                               
#  So as soon as it exhausts all the solutions in the bottom part, it moves up explore other solutions.
        