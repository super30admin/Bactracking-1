public class Solution {
    public IList<string> AddOperators(string num, int target) {
        IList<string> result = new List<string>();
        if(num==null || num.Length==0) return result;
        
        DFS(num,target,new StringBuilder(),result,0,0,0);
        return result;
    }
    
    private void DFS(string num,int target,StringBuilder sb,IList<string> res,int index,long eval,long mul)
    {
        if(index==num.Length)
        {
            if(target==eval)
            {
                res.Add(sb.ToString());
            }
            return;
        }
        
        int len = sb.Length;
        long curr =0;
        
        for(int i=index;i<num.Length;i++)
        {
            if(num[index]=='0' && i!=index)
            {
                break;
            }
            
            curr = 10* curr + (num[i] - '0');
            Console.WriteLine(curr);
            
            if(index==0)
            {
                DFS(num,target,sb.Append(curr),res,i+1,curr,curr);
                sb.Length= len;
            }
            else
            {
                DFS(num,target,sb.Append("+").Append(curr),res,i+1,eval+curr,curr);
                sb.Length=len;
                DFS(num,target,sb.Append("-").Append(curr),res,i+1,eval-curr,-curr);
                 sb.Length=len;
                DFS(num,target,sb.Append("*").Append(curr),res,i+1,eval-mul + mul                                                        *curr,mul*curr);
                sb.Length=len;
​
            }
        }
    }
}
