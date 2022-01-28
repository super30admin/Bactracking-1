// Time Complexity: O(2^n)
// Space Complexity: O(n)
// 0-1 backtrack
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)
            return result;
        backtrack(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int [] candidates, int index, int target, List<Integer> path)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        if(index == candidates.length || target < 0)
        {
            return;
        }

        // case 0
        backtrack(candidates, index + 1, target, path);
        // case 1
        path.add(candidates[index]);
        backtrack(candidates, index, target - candidates[index], path);
        path.remove(path.size()-1);
    }
}


// Time Complexity: O(2^n)
// Space Complexity: O(n)
// iterative backtrack
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        if(candidates == null || candidates.length == 0)
            return result;
        
        iterativeBacktrack(candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    
    private void iterativeBacktrack(int [] candidates, int target, int index, List<Integer> path)
    {
        //base
        if(target < 0)
        {
            return;
        }
        if(target == 0) // index out of bound check is not needed as it is controlled by for loop
        {
            result.add(new ArrayList<>(path));
        }
        // recursive
        for(int i = index ; i < candidates.length ; i ++)
        {
            path.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}
