#time complexity: O(n*(4^n))
#space complexity: O(max depth)= O(n)
#ran on leetcode: Yes
#loop through num. At each instance , you can have 4 different recusrsive calls, either add a +, - or * sign or just add the next integer in nums. While recusrsing for all these 4 conditions, backtrack after each recurse by deleting the last sign that was inserted. calculate the value of expression when you add the signs.
class Solution:
    
    def helper(self,path,index,num,target,val,tail):
        
        if(index==len(num)):
            #evaluate path and add to result if is equal to target
            #print(path)
            if(val==target):
                #print(path)
                self.result.append(''.join(path[:]))
            return


        curr=[]
        for i in range(index,len(num)):
            #can optimize this line by using a string builder
            curr.append(num[i])
            #curr=num[index:i+1]
            #print(curr)
            if(len(curr)!=1 and curr[0]=='0'):
                break
            res=int(''.join(curr))
            tail1=tail
            val1=val
            if(index!=0):
                if(path[-1]=='*'):
                    val1=(val1-tail1)+(tail1*res)
                    tail1=tail1*res
                elif(path[-1]=='+'):
                    val1=val1+res
                    tail1=res
                elif(path[-1]=='-'):
                    val1=val1-res
                    tail1=-res
            else:
                val1=res
                tail1=res

            path.append(''.join(curr))
            if(i==len(num)-1):
                self.helper(path,i+1,num,target,val1,tail1)
            else:
                path.append('+')
                self.helper(path,i+1,num,target,val1,tail1)
                del(path[-1])
                path.append('-')
                self.helper(path,i+1,num,target,val1,tail1)
                del(path[-1])
                path.append('*')
                self.helper(path,i+1,num,target,val1,tail1)
                del(path[-1])
            del(path[-1])
            



    def addOperators(self, num: str, target: int) -> List[str]:
        self.result=[]
        self.helper([],0,num,target,0,0)
        #print(self.result)
        return self.result
