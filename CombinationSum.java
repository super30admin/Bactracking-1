



//TC = 2^(n*k) 
// n = nodes, k = amount
// nodes is directly proportional to amount

//Space = O(n^2) 
// n nodes * O(n) Lists


//Recursive Solution
class Solution {
    List<List<Integer>> result; // Global list [[],[]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null){
            return result;
        }
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    
    private void helper(int[] candidates, int i, int amount, List<Integer> path){
        //base
        if(i==candidates.length||amount<0) return;
        if(amount == 0){
            result.add(path);
            return;
        }
        //logic
        
        //DS in DS is a Reference
        
        //Not Choose
        //sending into a sep List
        helper(candidates, i+1, amount, new ArrayList<>(path));
        
        path.add(candidates[i]); //[2]
        //Choose
        helper(candidates, i, amount-candidates[i], new ArrayList<>(path));
        
        
    }
}



//First call choose and then Not Choose
class Solution {
    List<List<Integer>> result; // Global list [[],[]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null){
            return result;
        }
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int i, int amount, List<Integer> path){
        //base
        if(i==candidates.length||amount<0) return;
        if(amount == 0){
            result.add(path);
            return;
        }
        //logic
        
        //DS in DS is a Reference
        
        
        List<Integer> temp = new ArrayList<>(path);
        
        temp.add(candidates[i]);
        
        //Choose
        helper(candidates, i, amount-candidates[i], temp);
        
        //Not Choose
        //sending into a sep List
        helper(candidates, i+1, amount, new ArrayList<>(path));
        
        
        
        
        
    }
}

