import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] left, int[] right) {
                return distToOrigin(right) - distToOrigin(left);
            }
        });

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] result = new int[K][2];
        for (int i = K - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
  
    public int distToOrigin(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] points = { {1,3}, {-2,2} };
        int k = 1;

        int[][] result = sol.kClosest(points, k);

        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
}