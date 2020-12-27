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
        
       for (int i = index; i < candidates.Length; i++) {
                //currsum = currsum + candidates[i];
           
                temp.Add(candidates[i]);
                helper(candidates, target, i, currsum + candidates[i], temp);
               // currsum = currsum - candidates[i];
             
                temp.RemoveAt(temp.Count-1);
            }
    }
}