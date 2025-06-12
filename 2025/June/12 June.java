import java.util.*;

class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });

        for (int num : arr) {
            if (num == x) continue;
            int diff = Math.abs(num - x);
            pq.offer(new int[]{diff, num});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[1]);
        }

        result.sort((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA != diffB) return diffA - diffB;
            return b - a;
        });

        int[] resArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }
}
