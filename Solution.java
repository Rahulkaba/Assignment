import java.util.*;

public class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (List<Integer> connection : connections) {
            int a = connection.get(0);
            int b = connection.get(1);
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] low = new int[n];
        Arrays.fill(low, -1);
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph, 0, -1, 0, low, result);
        return result;
    }

    private int dfs(List<Integer>[] graph, int curr, int prev, int depth, int[] low, List<List<Integer>> result) {
        low[curr] = depth;
        int minDepth = depth;
        for (int neighbor : graph[curr]) {
            if (neighbor == prev) {
                continue;
            }
            if (low[neighbor] == -1) {
                int neighborMinDepth = dfs(graph, neighbor, curr, depth + 1, low, result);
                minDepth = Math.min(minDepth, neighborMinDepth);
                if (neighborMinDepth > depth) {
                    result.add(Arrays.asList(curr, neighbor));
                }
            } else {
                minDepth = Math.min(minDepth, low[neighbor]);
            }
        }
        return minDepth;
    }
}
