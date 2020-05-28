#Recursive Solution:
#Time Complexity:O(4^n)
#Space Complexity:O(4^n)

#Algorithm:
# 1. Firstly we look for all the possibilities to find all the combinations. 
# 2. In our recursive call, we have index that represents the current digit we are dealing with and the expression we are working on. 
# 3. At every step we have 4 recursive calls.First one is extending the string, +,-,*
# 4. We build our expression untill the length matches the given string's length. And we check if the built expression is a valid one or not. The valid result is returned.




# class Solution(object):
#     def addOperators(self, num, target):
#         """
#         :type num: str
#         :type target: int
#         :rtype: List[str]
#         """
#         results = []
#         self.helper(0, num, 0, 0, "", target, results)
#         return results
    
#     def helper(self, k, num, ssum, prev, e, t, res):
#         print(e)
#         if k == len(num):
#             if ssum == t:
#                 res.append("".join([x for x in e]))
#             return 
        
#         for i in range(k, len(num)):
#                 left = num[k:i+1]
#                 ileft = int(left)
#                 if k!=i and num[k]=='0':
#                     continue
              
#                 # if left[0] == "0" and len(left) > 1: ### IGNORE INPUT LIKE "00", "005", "0006"
#                 #     continue
#                 if k == 0:
#                     self.helper(i+1, num, ileft, ileft, left, t, res)
#                 else:
#                     self.helper(i+1, num, ssum+ileft, ileft, e+"+"+left, t, res)
#                     self.helper(i+1, num, ssum-ileft, ileft*-1, e+"-"+left, t, res)
#                     self.helper(i+1, num, ssum-prev+ileft*prev, ileft*prev, e+"*"+left, t, res)

#Backtracking:
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:        
        def recurse(i, pre, cur, val, eq):
            
            
            if i == len(num):
                
                if val == target and cur == 0:
                    res.append(''.join(map(str, eq[1:])))
                return
            
            
            cur = cur * 10 + int(num[i])
            # i += 1
            if cur > 0:
                recurse(i+1, pre, cur, val, eq)
                
            eq += ['+', cur]
            recurse(i+1, cur, 0, val + cur, eq)
            eq.pop()
            eq.pop()
            if not eq:
                return
        
            eq += ['-', cur]
            recurse(i+1, -cur, 0, val - cur, eq)
            eq.pop()
            eq.pop()
            
            
            eq += ['*', cur]
            cur *= pre 
            recurse(i+1, cur, 0, val - pre + cur, eq)
            eq.pop()
            eq.pop()
        
        res = []
        recurse(0, 0, 0, 0, [])
        return res
                    
