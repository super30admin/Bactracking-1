//1.combination Sum
//time Complexity -> n*2^N
//Space Complexity -> N
class Solution {
    //Using deep copies technique
    //0-1 recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates,target,0,new ArrayList());
        return result;        
    }

    private void helper(int[] candidates,int target,int i,List<Integer> path){
        //base case
        if(target < 0 || i == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        //logic
        //not choose
        helper(candidates,target,i+1,path);
        List<Integer> li = new ArrayList(path);
        li.add(candidates[i]); //now we choose the candidate[i] and add it to the new list which is the deep copy of path
        //choose
        helper(candidates,target - candidates[i],i,li);


    }
}

class Solution {
    //Using backTracking technique
    //0-1 recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates,target,0,new ArrayList());
        return result;        
    }

    private void helper(int[] candidates,int target,int i,List<Integer> path){
        //base case
        if(target < 0 || i == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        //logic
        //not choose
        helper(candidates,target,i+1,path);
        //action
        path.add(candidates[i]); //add it to the path i.e choose candidate[i]
        //choose //recurse
        helper(candidates,target - candidates[i],i,path);
        //backtrack
        path.remove(path.size() - 1);


    }
}

class Solution {
    //Using backTracking technique
    //for loop recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates,target,0,new ArrayList());
        return result;        
    }

    private void helper(int[] candidates,int target,int pivot,List<Integer> path){
        //base case
        if(target < 0 || pivot == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        //logic
        for(int i = pivot ;i<candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates,target - candidates[i],i,path);
            //backTrack
            path.remove(path.size()-1);
        }


    }
}

class Solution {
    //Using deep copy technique
    //for loop recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates,target,0,new ArrayList());
        return result;        
    }

    private void helper(int[] candidates,int target,int pivot,List<Integer> path){
        //base case
        if(target < 0 || pivot == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        //logic
        for(int i = pivot ;i<candidates.length;i++){
            List<Integer> li = new ArrayList(path);
            li.add(candidates[i]);
            //recurse
            helper(candidates,target - candidates[i],i,li);
           
        }


    }
}

class Solution {
    //Using backTracking technique
    //0-1 recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates,target,0,new ArrayList());
        return result;        
    }

    private void helper(int[] candidates,int target,int i,List<Integer> path){
        //base case
        if(target < 0 || i == candidates.length) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        //logic
        //action
        path.add(candidates[i]); //add it to the path i.e choose candidate[i]
        //choose //recurse
        helper(candidates,target - candidates[i],i,path);
        //backtrack
        path.remove(path.size() - 1);

        //not choose
        helper(candidates,target,i+1,path);
        
        

    }
}

//2nd Expression Add Operators
//Time Complexity ->
//Space Complexity -> 
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num,target,0,new StringBuilder(),0,0);
        return result;
        
    }

    private void helper(String num,int target,int pivot,StringBuilder sb,long calc,long tail){
        //base
        if(pivot == num.length()){
            if(calc == target){
                result.add(sb.toString());
                return;
            }
        }

        //logic
        for(int i = pivot;i<num.length();i++){
            long curr = Long.parseLong(num.substring(pivot, i+1));
            int le = sb.length();
            if(num.charAt(pivot) == '0' && i!=pivot) continue;
            if(pivot == 0){
                sb.append(curr);
                helper(num,target,i+1,sb,curr,curr);
                sb.setLength(le);
            }
            else{
                //+
                sb.append('+');
                sb.append(curr);
                helper(num,target,i+1,sb,calc + curr,+curr);
                sb.setLength(le);

                //-
                sb.append('-');
                sb.append(curr);
                helper(num,target,i+1,sb,calc - curr,-curr);
                sb.setLength(le);

                //+
                sb.append('*');
                sb.append(curr);
                helper(num,target,i+1,sb,calc-tail + curr*tail,tail*curr);
                sb.setLength(le);
            }
        }
    }
}
