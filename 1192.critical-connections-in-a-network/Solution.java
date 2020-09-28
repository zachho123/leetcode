import java.util.*;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, 
            List<List<Integer>> connections) {
        List<List<Integer>> critical = new ArrayList<>();
        Map<Integer, List<Integer>> edges = mapConnections(connections);
        boolean[] visited = new boolean[n];

        dfs();
        
        return critical;
    }
    
    private Map<Integer, List<Integer>> mapConnections(
            List<List<Integer>> connections) {
        Map<Integer, List<Integer>> edges = new HashMap<>();

        // for (int i = 0; i < connections.size(); i++) {
        for (List<Integer> edge : connections) {
            // List<Integer> edge = connections.get(i);
            int start = edge.get(0);
            int end = edge.get(1);

            if (edges.containsKey(start)) {
                edges.get(start).add(end);
            } else {
                ArrayList<Integer> conns = new ArrayList<>();
                conns.add(end);
                edges.put(start, conns);
            }

            if (edges.containsKey(end)) {
                edges.get(end).add(start);
            } else {
                ArrayList<Integer> conns = new ArrayList<>();
                conns.add(start);
                edges.put(end, conns);
            }
        }

        return edges;
    }

    private void dfs() {

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] inputArr = {
            {0,1},
            {1,2},
            {2,0},
            {1,3}
        };

        List<List<Integer>> input = new ArrayList<List<Integer>>();

        for (int[] conn : inputArr) {
            List<Integer> newList = new ArrayList<>();
            for (int end : conn) {
                newList.add(end);
            }
            input.add(newList);
        }

        System.out.println(s.criticalConnections(input.size(), input));
    }
}