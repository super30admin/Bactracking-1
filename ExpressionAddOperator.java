// Time Complexity : O(4 POW N) // at every node we can take 2 decisions.
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. it is DP problem as we can see sub problems in the tree
 * 2. at each node we can take four decisions. no symbol,+,- or *. 
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
	List<String> result;
	public List<String> addOperators(String num, int target) {

		result = new ArrayList<>();
		helper(num,target,0,0,0,new StringBuilder());
		return result;
	}
	private void helper(String num, int target,long calc,long tail,int index,StringBuilder path) {
		//base
		if(index==num.length() && calc==target) {
			result.add(path.toString());
			return;
		}
		//logic
		for(int i=index;i<num.length();i++) {
			System.out.println(index+"..."+i);
			if(num.charAt(index)=='0'&& index!=i) continue;
			int len=path.length();
			long cur=Long.parseLong(num.substring(index, i+1));
			
			if(index==0) {
				path.append(cur);
				helper(num,target,cur,cur,i+1,path);
				path.setLength(len);
			}else {
				//+
				path.append("+"+cur);
				helper(num,target,calc+cur,cur,i+1,path);
				path.setLength(len);
				//-
				path.append("-"+cur);
				helper(num,target,calc-cur,-cur,i+1,path);
				path.setLength(len);
				//*
				path.append("*"+cur);
				helper(num,target,calc-tail+tail*cur,tail*cur,i+1,path);
				path.setLength(len);
			}
		}
		
	}
	public static void main(String[] args) {
		System.out.println(new ExpressionAddOperator().addOperators("105", 5));
	}
}
