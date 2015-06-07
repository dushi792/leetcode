/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    res = new Array(n);
    res[0] = 1;
    
    for (i = 0; i < m; i++) {
        for (j = 1; j < n; j++) {
            if (isNaN(res[j]))
                res[j] = 0;
            res[j] += res[j-1];
        }
    }
    
    return res[n-1];
};