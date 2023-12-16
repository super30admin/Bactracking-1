
//TC: 2^(m+n)
//SC: 2^(m+n)

import java.util.ArrayList;
import java.util.List;

public class Solution {

  List<List<Integer>> result = new ArrayList<List<Integer>>();
  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    List<Integer> path = new ArrayList <Integer>();
    helper(candidates,target,0, path );
    return result;

  }

  private void helper(int[] candidates, int target, int pivot, List<Integer> path){

    if(target<0) return;
    if (target==0) {
      result.add( new ArrayList <Integer>(path));
      System.out.println(path);
      return;
    }

    for( int i= pivot; i<candidates.length; i++ ){
      // no choose
      //helper(candidates, target, i+1, new ArrayList <Integer>(path));

      // choose
      path.add(candidates[i]);
      helper(candidates, target-candidates[i], i, path);
      path.remove(path.size()-1);
    }

  }
}
