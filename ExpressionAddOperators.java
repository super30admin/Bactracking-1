//space : O(h+s), h=height of tree, s=length of substrings
//time : O(4^n), n=length of strings
//Run successfully on leetcode : yes
class ExpressionAddOperators {
    //list to store result
    List<String> result;
    public List<String> addOperators(String num, int target) {
        //initializing result list
        result = new ArrayList<>();
        //if input is empty
        if(num==null || num.length()==0){
            return result;
        }
        //call method to find paths
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    public void helper(String num, int target, StringBuilder path, int index, long cal, long tail){
        //base
        //  System.out.println("Enter        ind:"+index+"  path"+path);
        //if target is found at leaf
        if(index == num.length() && cal==target){
            // add to result
            result.add(path.toString());
            return;
        }
        //logic
        //loop through remaining strings
        for(int i=index; i<num.length(); i++){

            if(index!=i && num.charAt(index)=='0') continue;
            long curr = Long.valueOf(num.substring(index, i+1));

            //if its the first character in string
            if(index == 0){
                //get length of current path
                int len = path.length();
                //update path: add current character to path
                path.append(curr);
                //  System.out.println("Mid i:"+i+"  ind:"+index+"  path"+path +" curr:"+curr+ "  cal:"+curr);
                //call helper to remaining strings
                helper(num, target, path, i+1, curr, curr);
                //backtrack : undo path update
                path.setLength(len);
            }
            else{
                //get length of current path
                int len = path.length();
                //update path: add current character to path
                path.append("+");
                path.append(curr);
                //   System.out.println("Mid    i:"+i+"   ind:"+index+"  path"+path +" curr:"+curr+ "  cal:"+(cal+curr));
                //call helper to remaining strings
                helper(num, target, path, i+1, cal+curr, curr);
                //backtrack : undo path update
                path.setLength(len);
                //get length of current path
                len = path.length();
                //update path: add current character to path
                path.append("-");
                path.append(curr);
                //   System.out.println("Mid   i:"+i+"     ind:"+index+"  path"+path + " curr:"+curr+"  cal:"+(cal-curr));
                //call helper to remaining strings
                helper(num, target, path, i+1, cal-curr, -curr);
                //backtrack : undo path update
                path.setLength(len);
                //get length of current path
                len = path.length();
                //update path: add current character to path
                path.append("*");
                path.append(curr);
                // System.out.println("Mid   i:"+i+"     ind:"+index+"  path"+path + " curr:"+curr+"  cal:"+(cal-tail+tail*curr));
                //call helper to remaining strings
                helper(num, target, path, i+1, cal-tail+tail*curr, tail*curr);
                //backtrack : undo path update
                path.setLength(len);
            }
        }


    }
}