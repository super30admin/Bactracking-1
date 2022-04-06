


// for loop based recursion with backtracking
func combinationSum(candidates []int, target int) [][]int {
    var result [][]int
    var helper func(c, paths []int, t, start int)
    helper = func(c, paths []int, t, start int) {
        
        // base
        if t < 0 {return}
        if t == 0 {
            newL := make([]int, len(paths))
            copy(newL, paths)
            result = append(result, newL)
            return
        }
    
        
        // logic
        for i := start; i < len(c); i++ {
            // action
            paths = append(paths, c[i])
            // recurse
            helper(c, paths, t-c[i] , i)
            // backtrack
            paths = paths[:len(paths)-1]
        }
        
    }
    
    helper(candidates, nil, target, 0)
    return result
}


// 0/1 recursion based on decision tree with backtracking
// func combinationSum(candidates []int, target int) [][]int {
    
    
//     var result [][]int
//     var helper func(c []int, target int, i int, paths []int)
//     helper = func(c []int, target int, i int, paths []int){
//         // base
//         if i >= len(c) || target < 0 {return}
        
//         if target == 0 {
//             newPaths := make([]int, len(paths))
//             copy(newPaths, paths)
//             result = append(result, newPaths)
//             return
//         }
        
//         // logic
//         // not choose
//         helper(c, target, i+1, paths)
        
//         // choose
//         paths = append(paths, c[i])
//         helper(c, target - c[i], i, paths)
        
//         paths = paths[:len(paths)-1]
//     }
    
//     helper(candidates, target, 0, []int{})
//     return result
// }


