import java.util.LinkedList;
import java.util.Queue;

public class FindLongestPathUnGraph {

    public static void main(String[] args) {
        // Create a sample graph
        FindPathGraph.Graph g = new FindPathGraph.Graph(12);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 7);
        g.addEdge(2, 8);
        g.addEdge(3, 4);
        g.addEdge(4, 9);
        g.addEdge(5, 10);
        g.addEdge(10, 11);

        FindLongestPathUnGraph f = new FindLongestPathUnGraph();
        f.longestPath(g,0);
    }



    private void longestPath(FindPathGraph.Graph g, int s) {
        Queue<Integer> queue = new LinkedList<>();
        int dis[] = new int[g.V];


        queue.add(s);

        dis[s] = 0;

        while (!queue.isEmpty()) {

            int t = queue.poll();

            for (int i = 0; i < g.adj[t].size(); i++) {
                queue.add((Integer) g.adj[t].get(i));
                dis[(int) g.adj[t].get(i)] = dis[t] + 1;
            }
        }

        System.out.println(dis);
    }

    public static class Graph {
        int V;
        LinkedList[] adj;

        Graph(int v) {
            this.V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<Integer>();
            }
        }


        public void addEdge(int s, int d) {
            adj[s].add(d);
        }
    }


}
