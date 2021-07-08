// Choose and not choose recursion
class Solution {
    ArrayList<List<Integer>> paths;
    ArrayList<Integer> li;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.paths = new ArrayList<>();
        this.li = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        helper(0, 0);
        return paths;
    }
    
    public void helper(int index, int sum){
        //base
        if(index >= candidates.length || sum > target)
            return;
        if(sum == target){
            paths.add(new ArrayList<>(li));
            return;
        }
           
        //logic
        //case1 - don't choose
        helper(index+1, sum);
        
        //case2 - choose
        li.add(candidates[index]);
        helper(index, sum+candidates[index]);
        
        li.remove(li.size() - 1);
    }
       
}

// for loop recursion
class Solution {
    ArrayList<List<Integer>> paths;
    ArrayList<Integer> li;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.paths = new ArrayList<>();
        this.li = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        helper(0, 0);
        return paths;
    }
    
    public void helper(int index, int sum){
        if(sum > target || index >= candidates.length){
            return;
        }
        if(sum == target){
            paths.add(new ArrayList<>(li));
            return;
        }
        for(int i=index; i<candidates.length; i++){   
            li.add(candidates[i]);
            // System.out.println(li.toString());  
            helper(i, sum+candidates[i]);
            li.remove(li.size() - 1);   
            // System.out.println(li.toString());  
        }
    }
       
}
