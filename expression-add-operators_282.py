#Approach: For loop Recursion
#Time Complexity O(4^n)
#Space Complexity O(n)
#It successfully runs on leetcode 

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        def helper(idx, path, curres,tail):
            if idx == len(num):
                if curres == target:
                    result.append(path)
                    return

            for i in range(idx,len(num)):
                #to handle case of preceding 0's
                if i>idx and num[idx]=='0': break
                cur = int(num[idx:i+1])
                #initial case where path is empty
                if idx==0:
                    helper(i+1, path + str(cur),curres + cur, cur)
                else:
                #sum
                    helper( i+1,path  + "+" +  str(cur), curres + cur, cur )
                #diff
                    helper( i+1, path +  "-" + str(cur),curres - cur, -cur)  
                #multiplication
                    helper(i+1, path + "*" + str(cur),curres - tail + tail * cur , tail*cur)

        result = []
        helper(0, "", 0, 0)
        return result

#outside function
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        self.helper(num, target,0, 0, 0,"")
        return self.result
        
    def helper(self, num, target, idx, curres,tail, path):
        
        if idx == len(num):
            if curres == target:
                self.result.append(path)
                return
        
        for i in range(idx,len(num)):
            cur = int(num[idx:i+1])
            if num[idx]== "0" and idx!=i:
                continue
            if idx==0:
                self.helper(num,target,i+1, cur, cur, path + str(cur))
            else:
            #sum
                self.helper(num, target, i+1, curres + cur, cur , path  + "+" +  str(cur))
            #diff
                self.helper(num, target, i+1, curres - cur, -cur, path +  "-" + str(cur))  
            #multiplication
                self.helper(num, target, i+1, curres - tail + tail * cur , tail*cur, path + "*" + str(cur))