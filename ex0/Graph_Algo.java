package ex0;

import java.util.*;

/**
 *
 */
public class Graph_Algo implements graph_algorithms{

    private graph g;

    public Graph_Algo(graph g0) {
        this.g = g0;
    }

    public Graph_Algo() {
        g = new Graph_DS();
    }

    @Override
    public void init(graph g) {
        this.g = g;
    }

    @Override
    public graph copy() {
        return new Graph_DS(this.g);
    }

    /**
     * This algorithm traverse the graph and check
     * connectivity of all nodes.
     * the algorithm use BFS method for graph traversal.
     * @return TRUE if the graph is connected.
     */
    @Override
    public boolean isConnected() {
        if(g.nodeSize() == 0 || g.nodeSize() == 1) return true;
        setAllTags(0);
        Queue<node_data> q = new LinkedList<>();
        node_data v = g.getV().iterator().next(); //pick some node
        v.setTag(1);
        q.add(v);
        while(!q.isEmpty()){
            v = q.remove();
            for(node_data n: v.getNi()){
                if(n.getTag() == 0){
                    q.add(n);
                    n.setTag(1);
                }
            }
        }
        for(node_data n: g.getV())
            if(n.getTag() == 0)
                return false;
        return true;
    }

    //reset all nodes....
    private void setAllTags(int t) {
        for(node_data n: g.getV())
            n.setTag(t);
    }

    @Override
    public int shortestPathDist(int src, int dest) {
        if(src == dest) return 0;
        node_data a = g.getNode(src);
        node_data b = g.getNode(dest);
        if(a == null || b == null) return -1;

        setAllTags(0);
        Queue<node_data> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){
            node_data v = q.remove();
            for(node_data n: v.getNi()){
                if(n.getKey() == dest)
                    return v.getTag()+1;
                if(n.getTag() == 0){
                    q.add(n);
                    n.setTag(v.getTag()+1);
                }
            }
        }
        return -1;
    }

    @Override
    public List<node_data> shortestPath(int src, int dest) {
        node_data a = g.getNode(src);
        node_data b = g.getNode(dest);
        if(a == null || b == null) return null;

        List<node_data> path = new ArrayList<>();
        if(src == dest) {
            path.add(a);
            return path;
        }
        setAllTags(-1);
        Queue<node_data> q = new LinkedList<>();
        q.add(g.getNode(src));
        while(!q.isEmpty()){
            node_data v = q.remove();
            for(node_data n: v.getNi()){
                if(n.getKey() == dest) {
                    n.setTag(v.getKey());
                    int t = n.getKey();
                    while(t != src){
                        path.add(g.getNode(t));
                        t = g.getNode(t).getTag();
                    }
                    path.add(g.getNode(t));
                    Collections.reverse(path);
                    return path;
                }
                if(n.getTag() == -1){
                    q.add(n);
                    n.setTag(v.getKey());
                }
            }
        }
        return null;
    }
}
