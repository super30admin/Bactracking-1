public class Solution {
    List<IList<int>> result;
    public IList<IList<int>> CombinationSum(int[] candidates, int target) {
        result = new List<IList<int>>();
        
        if(candidates.Length ==0) return result;
        
        helper(candidates,target,0,0,new List<int>());
        return result;
        
    }
    
    private void helper(int[] candidates,int target,int index,int currsum,List<int> temp)
    {
       if(currsum > target ||index>=candidates.Length)
       {
           return;
       }
        if(currsum == target)
        {
            result.Add(new List<int>(temp));
            return;
        }
        
        helper(candidates,target,index+1,currsum,temp);
        temp.Add(candidates[index]);
        helper(candidates,target,index,currsum + candidates[index],temp);
        for(int j=0;j<temp.Count;j++)
        {
            Console.WriteLine(temp[j]);
        }
        temp.Remove(candidates[index]);
    }
}
