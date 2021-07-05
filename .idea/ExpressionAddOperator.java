class ExpressionAddOperator {
    List<String> result = new ArrayList<>();
    public List<String> addOperators(String num, int target) {
        helper(num, target,"",0,0,0);
        return result;
    }
    private  void helper(String num, int target, String path, int index, long calc, long tail)
    {
        //base
        if(index==num.length())
        {
            if(calc == target)
                result.add(path);
            return;
        }
        //logic
        for(int i=index; i< num.length();i++)
        {
            if(num.charAt(index)=='0' && index!=i) continue;
            long curr = Long.parseLong(num.substring(index, i +1));

            if(index==0)
            {
                helper(num, target, path+curr, i + 1 ,curr, curr);
            }
            else
            {
                //+
                helper(num, target, path +'+'+curr, i+1, calc+curr, curr);
                //-
                helper(num, target, path +'-'+curr, i+1, calc-curr, -curr);
                //*
                helper(num, target,
                        path +'*'+curr, i+1, calc-tail + (tail * curr), tail * curr);
            }

        }
    }
}


