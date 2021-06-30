'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 282. Expression Add Operators

# Given a string num that contains only digits and an integer target, 
# return all possibilities to add the binary operators '+', '-', or '*' 
# between the digits of num so that the resultant expression evaluates to 
# the target value.


# The same number may be chosen from candidates an unlimited number of times. 
# Two combinations are unique if the frequency of at least one of the chosen numbers 
# is different.

# It is guaranteed that the number of unique combinations that sum up to target is 
# less than 150 combinations for the given input.

    

#-----------------
# Time Complexity: 
#-----------------
# O() - 

#------------------
# Space Complexity: 
#------------------
# O(target): 

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num, target, "", 0,  0 , 0)
        return self.result

    def helper(self, num, target, path, index, calc, tail):
        if index== len(num):
            if calc == target:
                self.result.append(str(path))
                
        for i in range(index, len(num)):
            #preceeding 0 case
            if num[index] == "0" and index != i:
                continue
            #usual case
            curr = int(num[index:i+1])
            if index == 0:
                self.helper(num, target, path + str(curr), i + 1, curr, curr)
            else:
                # +
                self.helper(num, target, path + "+" + str(curr), i + 1, calc+curr, curr)

                # -
                self.helper(num, target, path + "-" + str(curr), i + 1, calc-curr, -curr)

                # * 
                self.helper(num, target, path + "*" + str(curr), i + 1, ((calc-tail) + (tail * curr)), (tail * curr))


