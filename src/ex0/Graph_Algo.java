package ex0;

import java.util.List;

public class Graph_Algo implements graph_algorithms{

    private graph g;

    public Graph_Algo(graph g0) {
        g = g0;
    }

    @Override
    public void init(graph g) {

    }

    @Override
    public graph copy() {
        return new Graph_DS(g);
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public int shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        return null;
    }
}
