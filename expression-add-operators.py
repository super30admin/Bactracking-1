#For loop based recursion preferable coz of string operations and the fact that we need to use all the characters in the string
#TC: O(n * 4^n)
#SC: O(n)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        
        def recurse(st,calc,tail,exp):
            nonlocal num,target,ans
            if st==len(num):
                if calc==target:
                    ans.append(exp)

            for i in range(st,len(num)):
                cur = num[st:i+1]
                if num[st]=='0' and i!=st: break
                if st==0: 
                    recurse(i+1,int(cur),int(cur),cur)
                else:
                    recurse(i+1,calc+int(cur),int(cur),exp+"+"+cur)
                    recurse(i+1,calc-int(cur),-int(cur),exp+"-"+cur)
                    recurse(i+1,calc-tail + tail*int(cur), tail*int(cur),exp+"*"+cur)

        ans=[]
        recurse(0,0,0,"")
        return ans