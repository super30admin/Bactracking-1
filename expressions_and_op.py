#Problem: Expression Add Operators
#Time Complexity: O(n4^n)
#Space Complexity: O(n), length of str_now
#Worked on leetcode? Yes

'''
Main idea: We keep a global str_now array that is the state of our string in our tree. Now we give a starting
index for the recusrive function to indicate what's left to process. We call recursively for EACH possible
operation and each possible concatenated string we can get from our index onward. For example my starting
string is "1234". Then let's say I processed 1 and 2 (The value stored in prev). Then I call recursively
for every operation for "3" and for every operation for "34". We do that for each starting index so
we've covered every operation (3) and every concatenation only one time. So this is exactly the same
as having a tree with the 4 choices (add,substract, multiply,concatenate) and takes O(4^n) time
to traverse everything. The last thing is to add a copy of str_now to res, which takes O(n) time
for each.
'''

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        str_now=[]
        res=[]
        def helper(idx,target,prev):
            if idx==len(num):
                if target==0:
                    return res.append("".join(str_now))
                return
            #We iterate all the rest of the string for all possible concatenation
            for i in range(1, len(num)-idx+1):
                #We don't want to use string such as 01,012,but 0 is valid
                if num[idx]=="0" and i>1:
                    continue
                #concatenated string starting from num[idx]
                pres=int(num[idx:idx+i])

                for op,to_add in [('+', pres), ('-', -pres), ('*', prev * pres)] if str_now else [('', pres)]:
                    if op=="*":
                        str_now.append(op)
                        str_now.append(str(pres))
                        helper(idx+i,target+prev-to_add,to_add)
                        #backtrack
                        str_now.pop()
                        str_now.pop()
                    else:
                        str_now.append(op)
                        str_now.append(str(pres))
                        #we call recursively from the number following our
                        #concatenated string
                        helper(idx+i,target-to_add,to_add)
                        #backtrack
                        str_now.pop()
                        str_now.pop()
        helper(0,target,0)
        return res
