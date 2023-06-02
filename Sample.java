class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0)return result;
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int pivot, int target, List<Integer> path){
        //base
        if(target < 0 ){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        
        //logic
        for(int i = pivot; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, target - candidates[i], path);
            //backtrack
            path.remove(path.size() - 1);
            
        }
    }
}


class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) return result;
        helper(num, target,0,0,0,new StringBuilder());
        return result;
    }
    
    private void helper(String num,int target,int index,long cal,long tail,StringBuilder path){
        //base
        if(index == num.length()){
            if(cal == target){
            result.add(path.toString());
            return;
            }
        }
        
        
        
        //logic
        for(int i = index; i< num.length();i++){
            if(i != index && num.charAt(index) == '0'){
                continue;
            }
            long cur = Long.parseLong(num.substring(index,i+1));
            int len = path.toString().length();
            if(index == 0){
                path.append(cur);
                helper(num,target,i+1,cur,cur,path);
                path.setLength(len);
            } 
            else{
                //+
                path.append("+");
                path.append(cur);
                helper(num,target,i+1,cal + cur, cur, path);
                path.setLength(len);
                //-
                path.append("-");
                path.append(cur);
                helper(num,target,i+1,cal - cur, -cur, path);
                path.setLength(len);
                //*
                path.append("*");
                path.append(cur);
                helper(num,target,i+1,cal - tail + tail * cur, tail * cur, path);
                path.setLength(len);
            }
        }
    }
}
