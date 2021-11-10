# Time Complexity : O(4^n) exponential as we also creating new string at every node
# Space Complexity : O(4^n) for normal recursion as we maintain new string at every node,
# for backtracking -  O(length of result array) as only one result array 
# and one path (string builder like functionality)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, was tricky to implement string builder like functionality in Python
# Your code here along with comments explaining your approach

# normal recursion: preceding zero case, no operation, plus, minus, multiply cases
# maintain tail and calc for each of +, -, *
# for backtracking, we use for loop based recursion and pop last(no operation)
#  or last two elements from path


# normal recursion
# class Solution:
#     def addOperators(self, num: str, target: int) -> List[str]:
        
#         result = [] 

#         def helper(index=0, calc=0, tail=0, path=''):

#             # base case
#             if index ==len(num):
#                 if calc == target:
#                     result.append(path)
#                     return
            
#             for i in range(index, len(num)):
#                 # preceding zero case
#                 if index != i and num[index] == '0':
#                     continue


#                 curr = num[index: (i+1)]
#                 int_curr = int(curr)

#                 if index == 0:
#                     # no operation 
#                     helper(i+1, int_curr, int_curr, path + curr)
                
#                 else:

#                     # addition
#                     helper(i+1, calc + int_curr, int_curr, path + "+" + curr)
                  
#                     # subtraction
#                     helper(i+1, calc - int_curr, -int_curr, path + "-" + curr)

#                     # multiplication
#                     helper(i+1, calc - tail + tail*int_curr, tail*int_curr, path + "*" + curr)
#         helper()
#         return result


# backtracking
class Solution:

    def addOperators(self, num: str, target: int):

        result = [] 

        def helper(index=0, calc=0, tail=0, path=[]):

            # base case
            if index ==len(num):
                if calc == target:
                    result.append(''.join(path))
                    return
            
            for i in range(index, len(num)):
                # preceding zero case
                if index != i and num[index] == '0':
                    continue


                curr = num[index: (i+1)]
                int_curr = int(curr)

                if index == 0:
                    # no operation 
                    path.append(curr)
                    helper(i+1, int_curr, int_curr, path)
                    path.pop()

                else:

                    # addition
                    path.append("+")
                    path.append(curr)
                    helper(i+1, calc + int_curr, int_curr, path)
                    path.pop()
                    path.pop()

                    # subtraction
                    path.append("-")
                    path.append(curr)
                    helper(i+1, calc - int_curr, -int_curr, path)
                    path.pop()
                    path.pop()

                    # multiplication
                    path.append("*")
                    path.append(curr)
                    helper(i+1, calc - tail + tail * int_curr, tail * int_curr, path)
                    path.pop()
                    path.pop()
        helper()
        return result



            
