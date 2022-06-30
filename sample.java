//*****COMBINATION SUM- BRUTEFORCE WAY - CREATING A PATH AT EACH NODE*****
//Time complexity:o(n square);
//Space complexity:o(n square);
//leetcode ruunable: Y;
//Any doubts: N;
//not choose then choose case

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        combinesum(candidates, target, 0, new ArrayList<>());
        return result;
        
        
    }
    
    private void combinesum(int[] candidates, int target, int i, List<Integer> path)
    {
        //Base
        if(target==0)
        {
            result.add(path);
            return;
        }
        if(i==candidates.length || target<0)
        {
            return;
        }
        
        //Logic
            
            //Not to choose
            combinesum(candidates,target,i+1,new ArrayList<>(path));
            //choose
            path.add(candidates[i]);
            combinesum(candidates,target-candidates[i],i,new ArrayList<>(path));
    }
}



//*****COMBINATION SUM- BRUTEFORCE WAY - CREATING A PATH AT EACH NODE*****
//Time complexity:o(n square);
//Space complexity:o(n square);
//leetcode ruunable: Y;
//Any doubts: N;
//not choose then choose case

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        combinesum(candidates, target, 0, new ArrayList<>());
        return result;
        
        
    }
    
    private void combinesum(int[] candidates, int target, int i, List<Integer> path)
    {
        //Base
        if(target==0)
        {
            result.add(path);
            return;
        }
        if(i==candidates.length || target<0)
        {
            return;
        }
        
        //Logic
            //choose
            List<Integer> li=new ArrayList<>(path);
            li.add(candidates[i]);
            combinesum(candidates,target-candidates[i],i,li);
            //Not to choose
            combinesum(candidates,target,i+1,new ArrayList<>(path));
            
    }
}

//*****COMBINATION SUM- Going to optimal way*****
//o/p will be 2 empty arraylists because while adding path to the result it is passed by the reference.


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        combinesum(candidates, target, 0, new ArrayList<>());
        return result;
        
        
    }
    
    private void combinesum(int[] candidates, int target, int i, List<Integer> path)
    {
        //Base
        if(target==0)
        {
            result.add(path);
            return;
        }
        if(i==candidates.length || target<0)
        {
            return;
        }
        
        //Logic
            
            //Not to choose
            combinesum(candidates,target,i+1,path);
            //choose
                //Action
            path.add(candidates[i]);
                //Recurse
            combinesum(candidates,target-candidates[i],i,path);
                //Backtrack
            path.remove(path.size()-1);
    }
}

//*****COMBINATION SUM- OPTIMAL WAY*****
//Time complexity:o(2 res to ((target/minno.) +n));
//Space complexity:o(n);
//leetcode ruunable: Y;
//Any doubts: N;
//not choose then choose case

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        combinesum(candidates, target, 0, new ArrayList<>());
        return result;
        
        
    }
    
    private void combinesum(int[] candidates, int target, int i, List<Integer> path)
    {
        //Base
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(i==candidates.length || target<0)
        {
            return;
        }
        
        //Logic
            
            //Not to choose
            combinesum(candidates,target,i+1,path);
            //choose
                //Action
            path.add(candidates[i]);
                //Recurse
            combinesum(candidates,target-candidates[i],i,path);
                //Backtrack
            path.remove(path.size()-1);
    }
}


//COMBINATION SUM - FOR LOOP BASED RECURSION

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        //Null case
        if(candidates.length==0 || candidates==null) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
        
    }
    //candidates
    //Target
    //i
    //path
    private void helper(int[] candidates, int target, int index,List<Integer> path)
    {
        //Base
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0)
        {
            return;
        }
        //logic
        for(int i=index;i<candidates.length;i++)
        {
            //Action
            path.add(candidates[i]);
            //Recurse
            helper(candidates, target-candidates[i], i, path);
            //Backtrack
            path.remove(path.size()-1);
            
        }
    }
}
