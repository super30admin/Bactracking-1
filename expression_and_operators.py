# Time Complexity :
# O(2^(N)) - N is the number of numbers

# Space Complexity :
# O(N) - max Stack depth

# Did this code successfully run on Leetcode :
#Yes

# At each location - we have 4 choices, we can either add one of the 3 expressions, or we can just combine the numbers
#We check each of these possibilites through recursion. While doing so, we also maintain a current sum that is tracking what the current value of the expressoion is. If we reach the target, we add the current expression to the result

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []
        if len (num) == '':
            return self.result
        self.get_path(num,"",0,0,0,target)
        return self.result
        
    def get_path(self,num,curr_path,curr_val,tail,pivot,target):
        if pivot == len(num) :
            if curr_val == target :
                self.result.append(curr_path[:])
            return

        for i in range(pivot,len(num)):
            curr_num = int(num[pivot:i+1])
            if i != pivot and num[pivot] == '0' : 
                continue
            if pivot == 0 :
                self.get_path(num, curr_path+str(curr_num) ,  curr_num,curr_num,i+1,target)
            else :
                # + 
                curr_path = curr_path+ "+"+str(curr_num)
                self.get_path(num, curr_path  ,  curr_val + curr_num,curr_num,i+1,target)
                curr_path = curr_path[:-len(("+"+str(curr_num))) ]

                # - 
                curr_path = curr_path+ "-"+str(curr_num)
                self.get_path(num, curr_path,  curr_val - curr_num,-1 * curr_num,i+1,target)
                curr_path = curr_path[:-len(("-"+str(curr_num))) ]

                # *
                curr_path = curr_path+ "*"+str(curr_num)
                self.get_path(num, curr_path,  curr_val - tail + curr_num*tail, curr_num * tail,i+1,target)
                curr_path = curr_path[:-len(("*"+str(curr_num))) ]
