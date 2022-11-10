class Solution {
    private List<String> e;
    private List<String> rs;
    int target;
    public List<String> addOperators(String num, int target) {
        e = new ArrayList<>();
        rs = new ArrayList<>();
        this.target=target;
        a(num,0,0,0);
        return rs;
    }
    private void a(String num, int i, long r, long t){
        if(i==num.length()){
            if(r==target){
                StringBuilder es = new StringBuilder();
                for(String x : e){
                    es.append(x);
                }
                rs.add(es.toString());

            }
            return;
        }
        long c=0;
        for(int end=i; end<num.length(); ++end){
            c = c*10+(num.charAt(end)-'0');
        if(e.size()==0){
            e.add(c+"");
            a(num, end+1, c, c);
            e.remove(e.size()-1);
        }else{
            e.add("+");
            e.add(c+"");
            a(num, end+1, r+c, c);
            e.remove(e.size()-1);
            e.remove(e.size()-1);

            e.add("-");
            e.add(c+"");
            a(num, end+1, r-c, -c);
            e.remove(e.size()-1);
            e.remove(e.size()-1);

            e.add("*");
            e.add(c+"");
            a(num, end+1, r-t+t*c, t*c);
            e.remove(e.size()-1);
            e.remove(e.size()-1);
        }
        if(c==0){
            break;
        }
        }
    }
}

//tc=4^n
//sc=O(n)
