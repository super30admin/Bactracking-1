
// brute force
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        return helper(candidates,target,0,new ArrayList<>());
    }
    private List<List<Integer>> helper(int[] candidates, int amount, int i, List<Integer> path){
        // null case
        int len = candidates.length;
        if(candidates==null || len<0) return null;

        // base
        if(amount==0){
            result.add(path);
            return result;
        }
        if(amount<0 || i==len) return null;

        // logic
        // not choose
        helper(candidates,amount,i+1,new ArrayList<>(path)); // deepcopy
        // choose
        path.add(candidates[i]);
        helper(candidates,amount-candidates[i],i,new ArrayList<>(path));
        
        return result;
    }
}

// TC - O(2 power (m*n)) , m - number of candidates, n - target
// SC - O(2 power (m*n)) , m - number of candidates, n - target

// backtracking
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        return helper(candidates,target,0,new ArrayList<>());
    }
    private List<List<Integer>> helper(int[] candidates, int amount, int i, List<Integer> path){
        // null case
        int len = candidates.length;
        if(candidates==null || len<0) return null;

        // base
        if(amount==0){
            result.add(new ArrayList<>(path));
            return result;
        }
        if(amount<0 || i==len) return null;

        // logic
        // not choose
        helper(candidates,amount,i+1,path); // deep copy

        // choose
        // action
        path.add(candidates[i]);
        // recusrion
        helper(candidates,amount-candidates[i],i,path);
        // backtracking
        path.remove(path.size()-1);

        return result;
    }
}

// TC - O(2 power (m*n))
// SC - O(2 power (m*n))

// for loop based recursion
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        return helper(candidates,target,0,new ArrayList<>());
    }
    private List<List<Integer>> helper(int[] candidates, int amount, int pivot, List<Integer> path){
        // null case
        int len = candidates.length;
        if(candidates==null) return null;

        // base
        if(amount==0){
            result.add(new ArrayList<>(path));
            return result;
        }
        if(amount<0 || pivot==len) return null;

        // for loop based recursion
        for(int i=pivot;i<len;i++){
            path.add(candidates[i]);
            helper(candidates,amount-candidates[i],i,path);
            path.remove(path.size()-1);
        }
        
        return result;
    }
}

// TC - O(2 power (m*n))
// SC - O(2 power (m*n))