int numTrees(int n) {
    int count[n];
    count[0] = 1;
    count[1] = 1;
    for (int i = 2; i <= n; i++) {
        count[i] = 0;
        for (int j = 0; j < i; j++) {
            count[i] += count[j] * count[i - j - 1];
        }
    }
    return count[n];
}