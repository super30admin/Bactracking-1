"""
Problem2
Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []


"""

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        """
        using exhautive approach and taking all the possible inputs. Using for loop recursion.
        Time Complexity :O(N4^N) N: len of num array
        Space Complexity: O(N)
        """
        if len(num) == 0: return 0
        
        result = []
        
        
        def helper(num, idx, calc, tail, path, target):
            # base condition
            if idx == len(num):
                if calc == target:
                    result.append(path)
                return
                
            
            # logic
            for i in range(idx, len(num)):
                # preceeding zero
                if num[idx] == "0" and idx!=i: continue
                
                # creating all the possible numbers, starting from the pivot onwards
                curr = int(num[idx: i+ 1 ])
                if (idx == 0):
                           helper(num, i + 1, curr, curr, path+str(curr), target)
                else:
                           
                    # Add +
                    helper(num, i + 1, calc + curr, +curr, path + "+" + str(curr), target)
                           
                    # substract -
                    helper(num, i + 1, calc - curr, -curr, path + "-" + str(curr), target)
                        
                    # multiply *
                    helper(num, i + 1, (calc - tail) + (tail * curr) , tail*curr, path + "*" +  str(curr), target)
        
        
        helper(num, 0, 0, 0, "", target)
        return result
        