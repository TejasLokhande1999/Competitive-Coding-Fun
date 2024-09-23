class Solution {
    public long maximumImportance(int N, int[][] roads) {
        int[] degree = new int[N];
        for (int[] road : roads) {
            degree[road[0]]++;  // Increase the count for city road[0]
            degree[road[1]]++;  // Increase the count for city road[1]
        }
        
        // Step 2: Sort the cities by their degree
        // Create an array of indices to represent cities
        Integer[] cityIndexes = new Integer[N];
        for (int i = 0; i < N; i++) {
            cityIndexes[i] = i;
        }
        
        // Sort cities based on their degree in descending order
        Arrays.sort(cityIndexes, (a, b) -> Integer.compare(degree[b], degree[a]));
        
        // Step 3: Assign importance from N down to 1
        int[] importance = new int[N];
        int currentImportance = N;
        for (int city : cityIndexes) {
            importance[city] = currentImportance--;
        }
        
        // Step 4: Calculate the total importance
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += importance[road[0]] + importance[road[1]];
        }
        
        return totalImportance;
    }
}