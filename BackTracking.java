import java.util.*;
public class BackTracking {
    //time complexity : N^N;
    // space complexity : N^N;
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/combination-sum/
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates.length == 0 || candidates == null) return result;
        helper(candidates,0,target,new ArrayList<Integer> ());
        return result;
    }
    
    private void helper(int[] candidates, int index, int target,ArrayList<Integer> path){
     //base condition
     if(target == 0 ){
         result.add(new ArrayList(path));
         return;
     }
     if(index >= candidates.length || target < 0){
         return;
     }
        
     //logic
     for(int i =index;i<candidates.length;i++){
         int sum  = target - candidates[i];
         path.add(candidates[i]);
         helper(candidates,i,sum,path);
      // backtrack 
         path.remove(path.size()-1);
     }           
    }

    //time complexity : 4^N;
    // space complexity : N^N;
    // did it run on leetcode : yes
    // any doubts : no 
    //https://leetcode.com/problems/expression-add-operators/submissions/
    List<String> result1;

    public List<String> addOperators(String num, int target) {

        result = new ArrayList<>();

        helper(num, target, new StringBuilder(), 0, 0, 0);

        return result1;

    }

    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index){

        // base 

        if(index == num.length()){

            if(calc == target){

                result1.add(sb.toString());

                return;

            }

        }

        // logic

       for(int i = index; i < num.length(); i++){

           // preceding zero case

            if(index != i && num.charAt(index) == '0') break;

           long curr = Long.parseLong(num.substring(index, i + 1)); // 1*5

           int len = sb.toString().length();

           if(index == 0){

               sb.append(curr); //action

               helper(num, target, sb ,curr, curr, i + 1); // recurse

               sb.setLength(len); // backtrack

           } else {

               sb.append("+");//action

               sb.append(curr);//action

               helper(num, target, sb, calc + curr, curr, i + 1); // recurse

               sb.setLength(len);// backtrack

               

               sb.append("-");//action

               sb.append(curr);//action

               helper(num, target, sb, calc - curr, -curr, i + 1); // // recurse

               sb.setLength(len);// backtrack

               

               sb.append("*");

               sb.append(curr);

               helper(num, target, sb, calc - tail + tail*curr, tail*curr, i + 1); // recurse

               sb.setLength(len);// backtrack

           }

       }

    }


}
