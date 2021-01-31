class Solution:
    
    """
    Description: Given a string that contains only digits 0-9 and a target value.
    Return all possibilities to add binary operators (not unary) +, -, or * between the digits to get the target value
    
    Time Complexicity: O(n*4^n)
    Space Complexicity: O(n) 
    where n is the length of the string
    
    Worked in leetcode: Yes
    
    Approach: recursion (no backtracking)
    Hints: BODMAS rule (multiplication precident over addition and substraction)
           proceeding "0" (example num = "105", may result "1*5" as one of the solution)
    
    To satisfy BODMAS rule, separate substring starting from an index running in helper() as calc (by adding/substracting), 
    and tail (to keep for multiplication)
    for each operator call helper function recursively until the calculated value meets the target
    """
    
    def addOperators(self, num: str, target: int) -> List[str]:
        
        self.result = []; self.target = target
        if num == None or len(num) == 0: return self.result
        self.helper(num, 0, 0, 0, "")
        
        return self.result
    
    def helper(self, num, idx, calc, tail, path):
        
        # base
        if idx == len(num):
            if calc == self.target:
                self.result.append(path)
            return
        
        # logic
        for i in range(idx, len(num)):
            
            # skip numbers having proceeding zero 
            if i > idx and num[idx] == '0': continue
            
            # take a substring
            curr = num[idx:i + 1]
            if idx == 0: 
                self.helper(num, i + 1, int(curr), int(curr), path + curr) # no operation can be done here
            else:
                # for "+" operator
                self.helper(num, i + 1, calc + int(curr), int(curr), path + "+" + curr)
                
                # for "-" operator
                self.helper(num, i + 1, calc - int(curr), -int(curr), path + "-" + curr)
                
                # for "*" operator
                self.helper(num, i + 1, calc - tail + int(curr) * tail, tail * int(curr), path + "*" + curr)
        
