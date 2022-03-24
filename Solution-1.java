class Solution {
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    ArrayList<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    
    sum(candidates, target, 0, result, list);
    
    return result;
}

static void sum(int[] arr, int target, int start, ArrayList<List<Integer>> result, ArrayList<Integer> list){
    if(target<0){
        return;
    }
    
    if(target==0){
        result.add(new ArrayList<>(list));
    }
    
    for(int i=start; i<arr.length;i++){
        list.add(arr[i]);
        sum(arr,target-arr[i], i, result, list);
        list.remove(list.size()-1);
    }
}
}
