import java.util.*;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, 
            List<List<Integer>> connections) {
        List<List<Integer>> critical = new ArrayList<>();
        Map<Integer, List<Integer>> edges = mapConnections(n, connections);
        // Keeps track if / when a node was visited, -1 = not visited
        int[] timeVisited = new int[n];
        Arrays.fill(timeVisited, -1);
        int[] timer = {0};

        dfs(-1, 0, timeVisited, timer, edges, critical);
        
        return critical;
    }
    
    private Map<Integer, List<Integer>> mapConnections(int n,
            List<List<Integer>> connections) {
        Map<Integer, List<Integer>> edges = new HashMap<>();

        for (int i = 0; i < n; i++) {
            edges.put(i, new ArrayList<Integer>());
        }

        for (List<Integer> edge : connections) {
            int start = edge.get(0);
            int end = edge.get(1);

            edges.get(start).add(end);
            edges.get(end).add(start);
        }

        return edges;
    }

    private void dfs(int parent, int node, int[] visited, int[] timer,
            Map<Integer, List<Integer>> edges, 
            List<List<Integer>> critical) {
        // Mark current node as visited by giving it a time visited
        visited[node] = timer[0]++;
        int originalTimeVisted = visited[node];

        // Check every non-parent neighbor
        for (int neighbor : edges.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            // Perform dfs if unvisited
            if (visited[neighbor] == -1) {
                dfs(node, neighbor, visited, timer, edges, critical);
            }

            // We take the min time seen to identify cycles, lower visited times
            // will propagate around for cycles.
            visited[node] = Math.min(visited[node], visited[neighbor]);

            // This indicates no cycle, therefore a critical node
            if (originalTimeVisted < visited[neighbor]) {
                List<Integer> newCritical = new ArrayList<>();
                newCritical.add(node);
                newCritical.add(neighbor);
                critical.add(newCritical);
            }
        }
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