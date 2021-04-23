//Approach - Backtracking

class Solution {
  public List<String> addOperators(String num, int target) {

    List<String> result = new ArrayList<>();

    backtrack(num, target, "", result, 0, 0, 0);
    return result;
  }

  public void backtrack(String num, int target, String path,
                        List<String> result, int index, long calc, long tail){


    if(index == num.length()){
      if(target == calc){
        result.add(path);
      }
      return;
    }

    for(int i=index; i<num.length(); i++){

      if(index != i && num.charAt(index) == '0') { continue; }

      long number = Long.parseLong(num.substring(index, i+1));

      if(index == 0){
        backtrack(num, target, path+number, result, i+1, number, number);
      }else{
        backtrack(num, target, path+"+"+number, result, i+1, calc+number, number);
        backtrack(num, target, path+"-"+number, result, i+1, calc-number, -number);
        backtrack(num, target, path+"*"+number, result, i+1, calc-tail+number*tail, number*tail);
      }


    }

  }
}