'''
Time Complexity : Going exhaustive 0(n^n)

Space Complexity:   create a new string 0(x)
                    recursion stack i.e 0(n)

Run on LeetCode: Yes
Issues Faced: (Had to check video and code along!)
'''
# tough cookie to understand
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def forLoopRecursion(self,num,target,ptrIdx,currSum,tail,pairStr):
        
        # base-case
        if ptrIdx == len(num):
            # ptrIdx is now refering outside nums
            # print('Pair String is:\t',pairStr)
            if currSum == target:
                # found the match
                self.resultList.append(pairStr)
                return

        
        # logic-case
        for i in range(ptrIdx,len(num)):
            
            # create string pairs; Example 1 12 123 1234
            currInt = int(num[ptrIdx:i+1]) # 1 [i.e. gap b/w ptr-i]
            
            '''
            Preceding zero-case
            case "105";5
             [1     0       5]
            
              1 0,5     10      105
              
              [0    05] ==> here 05 is evaluating to zero, first 0 is fine
            
            '''
            if  num[ptrIdx] == '0' and ptrIdx != i:
                #preceding zero
                continue
                
            # Create sub-pairs
            if ptrIdx == 0:
                
                # 0th index; currSum and tail will be same i.e. currInt
                self.forLoopRecursion(num,target,i+1,currInt,currInt,pairStr + str(currInt))
            
            else:
                # +
                self.forLoopRecursion(num,target,i+1,currSum + currInt, currInt, pairStr + '+' + str(currInt))
                
                # -
                self.forLoopRecursion(num,target,i+1,currSum - currInt, -currInt, pairStr + '-' + str(currInt))
                
                # *
                self.forLoopRecursion(num,target,i+1, currSum - tail + tail * currInt, tail*currInt, pairStr + '*' + str(currInt))
            
    
    def addOperators(self, num: str, target: int) -> List[str]:
        self.forLoopRecursion(num,target,0,0,0,"")
        
        #print(self.resultList)
        return self.resultList