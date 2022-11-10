# TC:4^n
# SC:4^n

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        n=len(num)
        output=[]
        
        def dfs(i,so_far_list,res,prev):
            if i>=n:
                #print(so_far_list,res)
                if res==target:
                    output.append("".join(so_far_list))
                    #ouptut.append("".join(so_far_list))
                return
            
            for j in range(i,n):
                cand=int(num[i:j+1])
                if not so_far_list:
                    dfs(j+1,[num[i:j+1]],cand,cand)
                else:
                    dfs(j+1,so_far_list+["+"]+[num[i:j+1]],res+cand,cand)
                    dfs(j+1,so_far_list+["-"]+[num[i:j+1]],res-cand,-cand)
                    dfs(j+1,so_far_list+["*"]+[num[i:j+1]],res-prev+cand*prev,cand*prev)
                if num[i]=="0":
                    break
        
        dfs(0,[],0,None)
        return output