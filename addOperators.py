# Time complexity: Exponential
# Space complexity: O(n^3) where n is the length of nums


class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if num is None or len(num) == 0:
            return self.result

        self.helper(num,0,target,0,0,"")
        return self.result


    def helper(self,num,ind,target,calc,tail,path):
        #terminating case
        if ind == len(num) and target == calc:
            self.result.append(path)

        # logic
        for i in range(ind,len(num)):
            if i != ind and num[ind] == "0":
                continue
            curr = float(num[ind:i+1])
            if ind == 0:
                self.helper(num,i+1,target, curr,curr,path+str(int(curr)))
            else:
                self.helper(num,i+1,target, calc + curr, curr, path+"+"+str(int(curr)))
                self.helper(num,i+1,target, calc - curr,-curr,path+"-"+str(int(curr)))
                self.helper(num,i+1,target, calc - tail + (curr * tail),curr * tail,path+"*"+str(int(curr)))
                
                
