// Time Complexity : 
// Space Complexity : 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
    var output = [[Int]]()
    func combinationSum(_ candidates: [Int], _ target: Int) -> [[Int]] {
        if candidates == nil || candidates.count == 0 {
            return []
        }
        var path = [Int]()
        backtracking(candidates,target,0,&path)
        return output
        
    }
    func backtracking(_ candidates: [Int],_ target: Int,_ index: Int,_  path: inout [Int] ) {
        if target < 0 {
            return
        }
        if target == 0 {
            var path = path
            output.append(path)
        }
        for i in index..<candidates.count {
            path.append(candidates[i])
            backtracking(candidates, target - candidates[i],i,&path)
            path.remove(at: path.count-1)
        }
    }