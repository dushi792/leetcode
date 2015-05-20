# @param {Integer} n
# @return {Integer}
def num_trees(n)
    count = Array.new(n+1)
    count[0] = 1
    count[1] = 1
    
    for i in 2..n do
        count[i] = 0
        for j in 0..(i-1) do
            count[i] += count[j] * count[i-j-1]
        end
    end
    
    return count[n]
end