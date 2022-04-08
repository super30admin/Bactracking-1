// func combinationSum(candidates []int, target int) [][]int {
//     result := [][]int{}
    
//     var dfs func (c []int, i int, t int, p []int)
//     dfs = func(c []int,i int, t int, p []int) {
//         // base
//         if t == 0 {
//             newL := make([]int, len(p))
//             copy(newL, p)
//             result = append(result, newL)
//             return
//         }
//         if i >= len(c) || t < 0 {return}
        
//         // logic
//         // not choose
//         dfs(c, i+1, t, p)
        
//         // choose
//         p = append(p, c[i])
//         dfs(c, i, t-c[i], p)
//         p = p[:len(p)-1]
//     }
//     dfs(candidates, 0, target, nil)
//     return result
// }

/*
    approach : for-loop based recursion.
    - Since we have to find all combinations, we need to start with a number
    - And then with that number , find all other numbers that add up to target.
    - We are allowed to re-use the same number as many times as we want.
    - For example: [2,3,5] ; target = 8
    - We need to pick each number 1 by 1 and try other possible numbers that sum up to 8
    - Pick 2 : [2(i),3,5]
        - Now with [2], go find other elements that when summed with these elements add up to target.
        - Since we can re-use the same number over and over again,
        - We can get [2,2,2,2] == 8
        - [2,2,2,2] - is only possible with parent path [2,2,2]
        - NOW go back to parent path ([2,2,2] i.e backtrack) and try next element that a parent may have 
            - parent idx is still at [2(i),3,5]
        - When recursion goes back to parent, IT RESUMES PARENT FOR LOOP THAT WAS PAUSED!
        - WHICH MEANS OUR RECURSION RUNS WITHIN EACH ITERATION
        - Parent for loop starts, sets up path, and recurses, and its child starts and does the same thing until some base conditions are met.
        - Once a child for loop is done, it resumes parent for loop, and makes parent i go i++
        - Which means the next path when parent path was [2,2,2] at [2(i),3,5] 
        - Parent moves i++ -- so [2,3(i),5]
        - New element is added in that parent path [2,2,3]
        - target is reduced by 3
        - and parent calls the recursive function again, FROM WITHIN THE FOR LOOP
        - Child func call starts, child may / may not meet base conditions and may / may-not start its for loop and become a parent for childs it spins up.
        - Like this the recursion continues.
    
    
    time and space are exponential, at each idx, we recurse until target is met or we are past the target.
    Each iteration has a potential of expanding exponentially.
    
    time: 2^target/min(candidates)
    space: 2^target/min(candidates)
    
    
    it would have been 2^n IF WE WERE NOT ALLOWED TO REUSE THE SAME ELEMENTS

*/

func combinationSum(candidates []int, target int) [][]int {
    var result [][]int
    
    
    var dfs func(start, t int, c []int, paths []int)
    dfs = func(start, t int, c []int, paths []int) {
        
        // base
        // when this combination works
        if t == 0 {
            newL := make([]int, len(paths))
            copy(newL, paths)
            result = append(result, newL)
            return
        }
        // when this combination does not work
        if t < 0 || start >= len(c) {
            return
        }
        
        
        // logic
        // from this position, with current paths, 
        for i := start; i < len(c); i++ {
            // add new element to path to check if this combination works
            // ACTION
            paths = append(paths, c[i])         
        
            // RECURSE to evaluate whether we are going to save the paths or not
            dfs(i, t-c[i], c,paths)
            
            // BACKTRACK
            // Did/did-not workout, undo all the actions to restore ANY MODIFIED
            // REFERENCE data structure state back to what it was in a parent recursion stack
            paths = paths[:len(paths)-1]
        }
    }
    
    // actually call the func
    dfs(0, target, candidates,nil)
    
    return result
}
