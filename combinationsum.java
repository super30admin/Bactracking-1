// Time Complexity : O(2^N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// BackTracking Solution
import java.util.*;
class Main{
  public static void main(String []args){
    int []candidates={2,3,6,7};
    int target=7;
    System.out.println(combinationSum(candidates, target));
  }
  static List<List<Integer>> result;
  static int targ;
  public static List<List<Integer>> combinationSum(int []candidates, int target){
    result=new ArrayList<>();
    targ=target;
    if(candidates==null || candidates.length==0){
      return result;
    }
    backtrack(candidates, new ArrayList<>(), 0, 0);
    return result;
  }
  private static void backtrack(int []candidates, List<Integer> temp, int sum, int index){
    //base
    if(sum>targ){
      return;
    }
    if(sum==targ){
      result.add(new ArrayList<>(temp));
      return;
    }
    //logic
    for(int i=index; i<candidates.length; i++){
      //action
      temp.add(candidates[i]);
      //recurse
      backtrack(candidates, temp, sum+candidates[i], i);
      //backtrack
      temp.remove(temp.size()-1);
    }
  }
}

//Resursive Solution
// Space Complexity : O(2^N * N)
import java.util.*;
class Main{
  public static void main(String []args){
    int []candidates={2,3,6,7};
    int target=7;
    System.out.println(combinatioSum(candidates, target));
  }
  static List<List<Integer>> result;
  static int targ;
  public static List<List<Integer>> combinatioSum(int []candidates, int target){
    result=new ArrayList<>();
    targ=target;
    if(candidates==null || candidates.length==0){
      return result;
    }
    helper(candidates, new ArrayList<>(), 0, 0);
    return result;
  }
  public static void helper(int []candidates, List<Integer> temp, int sum, int index){
    if(sum>targ || index==candidates.length){
      return;
    }
    if(sum==targ){
      result.add(temp);
      return;
    }
    //not choose
    helper(candidates, new ArrayList<>(temp), sum, index+1);

    //choose
    temp.add(candidates[index]);
    helper(candidates, new ArrayList<>(temp), sum+candidates[index], index);
  }
}
