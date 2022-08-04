// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//TC - Exponential
//SC - Exponential

var result []string
func addOperators(num string, target int) []string {
    if len(num) == 0{
        return []string{}
    }
    
    result = []string{}
    
    helper(num,target,0,"",0,0)
    
    return result
}


func helper(num string, target int,index int, path string, cal int, tail int){
    //base
    if index == len(num){
        if target == cal{
            fmt.Println(path)
            result = append(result,path)
        }
        
        return
    }
    
    //logic
    for i := index;i<len(num);i++{
        curr,_ := strconv.Atoi(num[index:i+1])
        if index != i && string(num[index]) == "0"{
            continue
        } 
        if index == 0{
            helper(num,target,i+1,path+num[index:i+1], curr,curr)
        }else{
            //+ case
            
            helper(num,target,i+1,path+"+"+num[index:i+1],cal+curr,curr)
            
            //- case
            helper(num,target,i+1,path+"-"+num[index:i+1],cal-curr,-curr)
            //* case
            helper(num,target,i+1,path+"*"+num[index:i+1],cal-tail+tail*curr,tail*curr)
        }
    }
}

