import java.util.ArrayList;
import java.util.List;

class permute{
  public static void main(String args[])
  {
   int[] candi = {2,3,6,7};
   List<List<Integer>> res = permute(candi);

  }


public static List<List<Integer>> permute(int[] nums) {

    if (nums == null || nums.length == 0)
        return new ArrayList<>();

    List<List<Integer>> finalResult = new ArrayList<>();
    permuteRecur(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
    return finalResult;
}

private static void permuteRecur(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {

    if (currResult.size() == nums.length) {
        finalResult.add(new ArrayList<>(currResult));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (used[i])
            continue;
        currResult.add(nums[i]);
        used[i] = true;
        permuteRecur(nums, finalResult, currResult, used);
        used[i] = false;
        currResult.remove(currResult.size() - 1);
    }
}
}