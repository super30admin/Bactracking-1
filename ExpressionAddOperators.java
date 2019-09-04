import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode accepted: yes
 */
public class ExpressionAddOperators {

	public static void main(String[] args) {
		System.out.println(addOperators("123", 6));
	}
	
	public static List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		if(num.length() == 0) return result;
		helper(result, "", num, target, 0, 0, 0);
		return result;   
    }

	private static void helper(List<String> result, String path, String num, int target, int index, long calculated, long tail) {
		//Base Case
		if(index == num.length()){
            if(calculated == target){
                result.add(path);
            }
            return;
	     }
		
		for(int i=index; i<num.length(); i++) {
			//Handling preceding 0
		    if(i != index && num.charAt(index) == '0') break;
		    //Handling Integer overflow
            Long cur = Long.parseLong(num.substring(index, i+1));
            if(index == 0){
                helper(result, path + cur, num, target, i + 1, cur, cur);
            } else {
            		//Considering abs value for tail in case of +, -
                helper(result, path + '+' + cur, num, target, i + 1,calculated + cur, cur); 
                helper(result, path + '-' + cur, num, target,i + 1, calculated - cur, -cur); 
                helper(result, path + '*' + cur, num, target,i + 1, calculated - tail + tail * cur, tail* cur); //Handling operator precedence in case of *
            }
		}
	}

}
