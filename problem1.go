// Time Complexity : O(2^N)
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var result [][]int
func combinationSum(candidates []int, target int) [][]int {
    if len(candidates) == 0{
        return [][]int{}
    }
    
    result = [][]int{}
    
    helper(candidates,target,0,[]int{})
    
    return result
}


Without backtrack with extra space
func helper(candidates []int, target int,index int,path []int){
    if target == 0{
        result = append(result,path)
        return
    }
    if target < 0 || index ==  len(candidates){
        return
    }
       
    //0 case
    newpath1 := []int{}
    newpath1 = append(newpath1,path...)    
    helper(candidates,target,index+1,newpath1)
    
    //1 case
    newpath2 := []int{}
    newpath2 = append(newpath2,path...)
    newpath2 = append(newpath2,candidates[index])
    helper(candidates,target-candidates[index],index,newpath2)
    
}

//With backtrack and no extra space
func helper(candidates []int, target int,index int,path []int){
    if target == 0{
        newpath := []int{}
        newpath = append(newpath,path...)
        result = append(result,newpath)
        return
    }
    if target < 0 || index ==  len(candidates){
        return
    }
       
    //0 case    
    helper(candidates,target,index+1,path)
    
    //1 case
    path = append(path,candidates[index])
    helper(candidates,target-candidates[index],index,path)
    path = path[:len(path)-1]
}
