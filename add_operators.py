#Time Complexity :  O(exponential))
#Space Complexity : O(exponential)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        result = []
        n  = len(num)

        def helper(index,val,tail,path):
            #base
            if index == n:
                if target == val:
                    result.append(path)

                return

            #logic
            for i in range(index,n):
                if num[index] =='0' and i!=index:
                    break
                curr = int(num[index:i + 1])

                if index==0:
                    
                    helper(i+1,curr,curr,path+str(curr))

                else:
                    # +
                    helper(i+1,val+curr,curr,path+"+"+str(curr))
                    # -
                    helper(i+1,val-curr,-curr,path+'-'+str(curr))
                    # *
                    helper(i+1,(val-tail+(curr*tail)),curr*tail,path+'*'+str(curr))

        helper(0,0,0,'')
        return result