class Solution {
    //Time O(4^N)
    //Space O(H)
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0)
        {
            return result;
        }
        helper(num , target, new StringBuilder(), 0, 0, 0);
        return result;
    }
    private void helper(String num, int target, StringBuilder path, long calc, long tail, int index)
    {
        //base
        if(index == num.length() && target == calc)
        {
            result.add(path.toString());
            return;
        }
        //logic
        for(int i=index ; i<num.length() ; i++)
        {
            if(num.charAt(index) == '0' && index != i) continue;
            long curr = Long.parseLong(num.substring(index , i+1));
            int len = path.toString().length();
            if(index == 0)
            {
                helper(num , target, path.append(curr) , curr , curr , i+1);
                path.setLength(len);
            }
            else
            {
                //Addition
                path.append('+'); // Action
                path.append(curr);
                helper(num , target, path , calc + curr, curr, i+1); //Recurse
                path.setLength(len); //BackTrack
                
                //Subraction
                path.append('-'); // Action
                path.append(curr);
                helper(num , target, path , calc - curr, -curr, i+1);
                path.setLength(len); //BackTrack
                
                //Multiplication
                path.append('*'); // Action
                path.append(curr);
                helper(num , target, path , calc-tail + (tail*curr), tail*curr, i+1);
                path.setLength(len); //Backtrack
            }
            //System.out.println(curr);
        }
    }
}