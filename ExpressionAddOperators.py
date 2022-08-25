# Time Complexity: O(4^n)
# Space Complexity: O(n)
# class Solution:
#     def addOperators(self, num: str, target: int) -> List[str]:
#         # Brute force recursion solution
#         result = []
#         # Emulate string builder instead of string for path for efficiency
#         # Use list of characters
#         # Note: In Python string is not perfectly immutable, creates a new string only if the length increases. May be using the same address space if we play with same length string, but consider them as Immutable as a Software Engineer
#         def helper(num,idx,calc,tail,path):
#             # Base
#             if idx == len(num):
#                 if calc == target:
#                     result.append(path)
#                 return
            
#             #Logic
#             for i in range(idx,len(num)):
#                 # Preceding 0
#                 if idx!=i and num[idx] == '0':
#                     continue
#                 curr = int(num[idx:i+1]) # Look at alternate to slice later as slice is not efficient
#                 # integer parsing will lead 05 to be changed to 5. So we add the preceding 0 logic
#                 if idx == 0:
#                     helper(num,i+1,curr,curr,path+str(curr))
#                 else:
#                     # For +
#                     helper(num,i+1,calc+curr,curr,path+"+"+str(curr))
                    
#                     # For -
#                     helper(num,i+1,calc-curr,-curr,path+"-"+str(curr))
                    
#                     # For *
#                     helper(num,i+1,calc-tail+tail*curr,tail*curr,path+"*"+str(curr))
        
#         helper(num,0,0,0,"")
#         return result

# Backtracking efficient solution
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        def helper(num,idx,calc,tail,path):
            # Base
            if idx == len(num):
                if calc == target:
                    result.append("".join(path))
                return
            
            #Logic
            for i in range(idx,len(num)):
                # Preceding 0
                if idx!=i and num[idx] == '0':
                    continue
                curr = ""
                for x in range(idx,i+1):
                    curr += num[x]
                curr = int(curr)
                # integer parsing will lead 05 to be changed to 5. So we add the preceding 0 logic
                if idx == 0:
                    #Action
                    path.append(str(curr))
                    #Recurse
                    helper(num,i+1,curr,curr,path)
                    #Backtrack
                    path.pop()
                else:
                    # For +
                    #Action
                    path.append("+")
                    path.append(str(curr))
                    #Recurse
                    helper(num,i+1,calc+curr,curr,path)
                    #Backtrack
                    path.pop()
                    path.pop() # Twice because we are also adding operator
                    
                    # For -
                    #Action
                    path.append("-")
                    path.append(str(curr))
                    #Recurse
                    helper(num,i+1,calc-curr,-curr,path)
                    #Backtrack
                    path.pop()
                    path.pop()
                    
                    # For *
                    #Action
                    path.append("*")
                    path.append(str(curr))
                    #Recurse
                    helper(num,i+1,calc-tail+tail*curr,tail*curr,path)
                    #Backtrack
                    path.pop()
                    path.pop()
        
        helper(num,0,0,0,[])
        return result
            
            
        