
""""// Time Complexity : O(L*4^l) --> exponential.
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
"""
class Solution:
    def addOperators(self, num, target):
        self.resultList = []
        self.helper(num, target, 0, 0, 0, [])
        return self.resultList

    def helper(self, num, target, Idx, currSum, tail, path):

        # base-case
        if Idx == len(num):
            if currSum == target:
                self.resultList.append(''.join(path))
                return

        # logic-case 
        for i in range(Idx, len(num)):
            curr = num[Idx:i + 1]  # 1 [i.e. gap b/w Idx-i]

            if num[Idx] == '0' and Idx != i:
                continue

            if Idx == 0:
                path.append(curr)
                self.helper(num, target, i + 1, int(curr), int(curr), path)
                path.pop()

            else:
                # +
                path.append('+')
                path.append(curr)
                self.helper(num, target, i + 1, currSum + int(curr), int(curr), path)
                path.pop()
                path.pop()

                # -
                path.append('-')
                path.append(curr)
                self.helper(num, target, i + 1, currSum - int(curr), -int(curr), path)
                path.pop()
                path.pop()

                # *
                path.append('*')
                path.append(curr)
                self.helper(num, target, i + 1, currSum - tail + (tail * int(curr)), tail * int(curr), path)
                path.pop()
                path.pop()

# class Solution:
#     def addOperators(self, num: str, target: int) -> List[str]:
#         self.resultList = []
#         self.helper(num,target,0,0,0,"")
#         return self.resultList

#     def helper(self,num,target,Idx,currSum,tail,pairStr):

#         # base-case
#         if Idx == len(num):
#             if currSum == target:
#                 self.resultList.append(pairStr)
#                 return


#         # logic-case
#         for i in range(Idx,len(num)):

#             # create string pairs
#             currInt = int(num[Idx:i+1]) # 1 [i.e. gap b/w Idx-i]

#             if  num[Idx] == '0' and Idx != i:
#                 #preceding zero
#                 continue

#             # Create sub-pairs
#             if Idx == 0:

#                 # 0th index; currSum and tail will be same i.e. currInt
#                 self.helper(num,target,i+1,currInt,currInt,pairStr + str(currInt))

#             else:
#                 # +
#                 self.helper(num,target,i+1,currSum + currInt, currInt, pairStr + '+' + str(currInt))

#                 # -
#                 self.helper(num,target,i+1,currSum - currInt, -currInt, pairStr + '-' + str(currInt))

#                 # *
#                 self.helper(num,target,i+1, currSum - tail + (tail * currInt), tail*currInt, pairStr + '*' + str(currInt))