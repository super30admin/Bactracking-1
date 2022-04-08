func addOperators(num string, target int) []string {
    
    
    result := []string{}
    
    var dfs func(start int, path string, calc int, tail int)
    dfs = func(start int, path string, calc int, tail int) {
        
        
        // base
        if start == len(num) && calc == target {
            result = append(result, path)
            return
        }
        
        // logic
        for i := start; i < len(num); i++ {
            currNumStr := string(num[start:i+1])
            currNum, _ := strconv.Atoi(currNumStr)
            if string(num[start]) == "0" && start != i {continue}
            if start == 0 {
                dfs(i+1, path + currNumStr, currNum, currNum)
            } else {
                // recurse
                // +
                dfs(i+1, fmt.Sprintf("%v+%v",path,currNumStr), calc+currNum, currNum)
                
                // -
                dfs(i+1, fmt.Sprintf("%v-%v",path,currNumStr), calc-currNum, -currNum)
    
                // *
                dfs(i+1, fmt.Sprintf("%v*%v",path,currNumStr), calc-tail+tail*currNum, tail*currNum)
            }   
        }
    }
    
    dfs(0, "",0,0)
    return result
    
}
