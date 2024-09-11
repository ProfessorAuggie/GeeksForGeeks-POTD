class Solution {
    public long minCost(long[] arr) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long totalCost = 0;

        for (long num : arr) {
            minHeap.add(num);
        }

        while (minHeap.size() > 1) {
            long first = minHeap.poll();
            long second = minHeap.poll();
            long cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }

        return totalCost;
    }
}
