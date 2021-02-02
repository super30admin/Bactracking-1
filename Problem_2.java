// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

class Solution {
    private List<String> result;
	private  int targ;
    public List<String> addOperators(String num, int target) {
        result=new ArrayList<>();
		targ=target;
		helper(num,"",0,0,0);
		return result;
    }
    
    private void helper(String num,String path,long calc,long tail,int index) {
		//base
		if(index==num.length()) {
			//System.out.println("****calc->"+calc+"|"+"path: "+path+"|"+"tail->"+tail+" :index"+index);
			if(calc==targ) {
				result.add(path);
			}
		}
		
		//logic
		for(int i=index;i<num.length();i++) {
			long curr=Long.parseLong(num.substring(index,i+1));
			//System.out.println(curr);
			//System.out.println("calc->"+calc+"|"+"path: "+path+"|"+"tail->"+tail+" :index"+index);
            if(index!=i && num.charAt(index)=='0') continue;
			if(index==0) {
				helper(num,path+curr,curr,curr,i+1);
			}else {
				//+
				helper(num,path+"+"+curr,calc+curr,curr,i+1);
				
				//-
				helper(num,path+"-"+curr,calc-curr,-curr,i+1);
				
				//*
				helper(num,path+"*"+curr,calc-tail+tail*curr,tail*curr,i+1);
			}
		}
	}
}




