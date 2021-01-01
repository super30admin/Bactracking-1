/*
# recursive sol
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if num is None or len(num) == 0:
            return []
        
        self.result = []
        self.recurse(num, target, "", 0, 0, 0)
        
        return self.result
    
    def recurse(self, num, target, path, cal, tail, index):
        if index == len(num):
            if cal == target:
                self.result.append(path)
            return
        
        
        for i in range(index, len(num)):
            if num[index] == '0' and index != i:
                continue
                
            substringnumber = int(num[index:i+1])
            
            if index == 0:
                self.recurse(num, target, path+str(substringnumber), substringnumber, substringnumber, i+1)
            
            else:
                # +
                self.recurse(num, target, path+'+'+str(substringnumber), cal+substringnumber, substringnumber, i+1)
                # -
                self.recurse(num, target, path+'-'+str(substringnumber), cal-substringnumber, -substringnumber, i+1)
                # *
                self.recurse(num, target, path+'*'+str(substringnumber), cal-tail+tail*substringnumber, tail*substringnumber, i+1)

                

# Backtracking
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if num is None or len(num) == 0:
            return []
        
        self.result = []
        self.recurse(num, target, [], 0, 0, 0)
        
        return self.result
    
    def recurse(self, num, target, path, cal, tail, index):
        if index == len(num):
            if cal == target:
                s = "".join(path)
                self.result.append(s)
            return
        
        
        for i in range(index, len(num)):
            if num[index] == '0' and index != i:
                continue
                
            substringnumber = int(num[index:i+1])
            
            
            if index == 0:
                path.append(str(substringnumber))
                self.recurse(num, target, path, substringnumber, substringnumber, i+1)
                path.pop()
            
            else:
                # +
                path.append('+')
                path.append(str(substringnumber))
                self.recurse(num, target, path, cal+substringnumber, substringnumber, i+1)
                path.pop()
                path.pop()
                
                # -
                path.append('-')
                path.append(str(substringnumber))
                self.recurse(num, target, path, cal-substringnumber, -substringnumber, i+1)
                path.pop()
                path.pop()
                
                # *
                path.append('*')
                path.append(str(substringnumber))
                self.recurse(num, target, path, cal-tail+tail*substringnumber, tail*substringnumber, i+1)
                path.pop()
                path.pop()


*/



/*
//Recursive 
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        
        recurse(num, target, "", 0, 0, 0);
            
        return result;
    }
    
    private void recurse(String num, int target, String path, long cal, long tail, int index){
        if (index == num.length()){
            if (cal == target)
                result.add(path);
            return;
        }
        
        for (int i=index; i<num.length(); i++){
            if (num.charAt(index) == '0' && index != i)
                continue;
            
            long cur = Long.parseLong(num.substring(index, i+1));
            
            if (index == 0){
                recurse(num, target, path+cur, cur, cur, i+1);
            }else{
                recurse(num, target, path+'+'+cur, cal+cur, cur, i+1);
                
                recurse(num, target, path+'-'+cur, cal-cur, -cur, i+1);
                
                recurse(num, target, path+'*'+cur, cal-tail+tail*cur, tail*cur, i+1);
            }
        }
    }
}
*/


// Time Complexity : O(4^n) where n is size of num 
// Space Complexity : O(n) as I am maintaining a single string builder 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: There are 4 choices every time, whether to append next number or 
// to place a + between two numbers or place a - betwen two numbers or place a * between two numbers

//Backtracking
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;
        
        recurse(num, target, new StringBuilder(), 0, 0, 0);
            
        return result;
    }
    
    private void recurse(String num, int target, StringBuilder path, long cal, long tail, int index){
        if (index == num.length()){
            if (cal == target)
                result.add(path.toString());
            return;
        }
        
        for (int i=index; i<num.length(); i++){
            if (num.charAt(index) == '0' && index != i)
                continue;
            
            long cur = Long.parseLong(num.substring(index, i+1));
            int length = path.length();
            
            if (index == 0){
                path.append(cur);
                recurse(num, target, path, cur, cur, i+1);
                path.setLength(length);
            }else{
                path.append('+');
                path.append(cur);
                recurse(num, target, path, cal+cur, cur, i+1);
                path.setLength(length);
                
                path.append('-');
                path.append(cur);
                recurse(num, target, path, cal-cur, -cur, i+1);
                path.setLength(length);
                
                path.append('*');
                path.append(cur);
                recurse(num, target, path, cal-tail+tail*cur, tail*cur, i+1);
                path.setLength(length);
            }
        }
    }
}