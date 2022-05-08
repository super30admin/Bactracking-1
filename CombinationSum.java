import java.util.*;
public class CombinationSum
{
    public static List<List<Integer>> result;


    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0)
        {
            return result;
        }

        helper(candidates,target,0,new ArrayList<>());

        return result;
    }

    private static void helper(int[] candidates,int target, int index, List<Integer> path)
    {
        if(target == 0)
        {
            result.add(path);
            return;
        }

        if(index == candidates.length || target< 0)
        {
            return;
        }

        //not choosing i.e 0 Case
        helper(candidates, target, index+1, new ArrayList<>(path));

        //choosing case i.e 1 Case
        path.add(candidates[index]);
        helper(candidates, target-candidates[index], index, new ArrayList<>(path));

    }


    public static void main(String args[])
    {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> answer = combinationSum(candidates, target);

        for(List<Integer> ans : answer)
        {
            System.out.println(ans);
        }
    }
}