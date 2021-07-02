class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        #Time complexity: O(N*4^N) 4 choices and N for string concat
        #Space complexity: O(N) for stack
        self.res = []
        def helper(num,target,index,path,calc,tail):
            #base
            # if all nums have been considered and we are at the end
            if index == len(num):
                #if target == calculated value
                if calc == target:
                    self.res.append(path)
                    return
            #logic
            # pivot is at index, move pivot, to consider options and recursively call the children
            for i in xrange(index,len(num)):
                # edge case, when number has 0 in it, gives wrong result as '05' is considered as 5 and not separately
                if num[index] == '0' and i != index:
                    continue
                curr = int(num[index:i+1])
                # when starting, initialise everything, keeping curr as curr and tail as curr
                if index == 0:
                    helper(num,target,i+1,path+str(curr),curr,curr)
                else:
                    #maintaining curr and tail to handle bodmas condition for *
                    # try +
                    helper(num,target,i+1,path+'+'+str(curr),calc+curr,curr)
                    # try -
                    helper(num,target,i+1,path+'-'+str(curr),calc-curr,-curr)
                    # try *
                    # we remove the mess created earlier by doing a - tail and then multiplying
                    helper(num,target,i+1,path+'*'+str(curr),calc-tail+tail*curr,tail*curr)
        helper(num,target,0,'',0,0)
        return self.res