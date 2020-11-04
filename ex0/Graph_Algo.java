package ex0;

import java.util.*;

/**
 * This class represents the "regular" Graph Theory algorithms including:
 * 0. clone();
 * 1. init(String file_name);
 * 2. save(String file_name);
 * 3. isConnected();
 * 5. int shortestPathDist(int src, int dest);
 * 6. List<Node> shortestPath(int src, int dest);
 * @see ex0.graph_algorithms
 *
 * @author Eyal Levi
 * https://github.com/LeviEyal
 */
public class Graph_Algo implements graph_algorithms{

    private graph g;

    /**
     * Construct a graph-algorithms object and set its init graph with a given graph.
     * @param g0 a graph to init with
     */
    public Graph_Algo(graph g0) {
        this.g = g0;
    }

    /**
     * Construct a graph-algorithms object and set its init graph with an empty new graph.
     */
    public Graph_Algo() {
        g = new Graph_DS();
    }

    /**
     * Init this set of algorithms on a given graph
     * @param g a given graph to init this set of algorithms on.
     */
    @Override
    public void init(graph g) {
        this.g = g;
    }

    /**
     * Computes a deep copy of this graph by turning to the copy-constructor of Graph_DS class.
     * @return a deep copy of this graph
     */
    @Override
    public graph copy() {
        return new Graph_DS(this.g);
    }

    /**
     * This algorithm traverse the graph and check
     * connectivity of all nodes.
     * The algorithm use BFS method for graph traversal.
     * The algorithm works as followed:
     * 1) Mark all nodes as not visited by setting their tags to 0
     * 2) Pick some node - call it v
     * 3) Mark v as visited by set its tag to 1
     * 4) add v to a queue
     * 5) while the queue not empty commit:
     *      - set v as the outcome of the queue pop
     *      - for all neighbor n of v:
     *          -- if not visited - add it to the queue and mark it as visited
     * 6) traverse the graph and return false if their is a node who still marked as not visited.
     *
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

    //Sets al nodes' tags value to a given integer number t
    private void setAllTags(int t) {
        for(node_data n: g.getV())
            n.setTag(t);
    }

    /**
     * This algorithm searching for the shortest path between given source and destination.
     * The algorithm use BFS method for graph traversal.
     * The algorithm works as followed:
     * 1) Mark all nodes as not visited by setting their tags to 0
     * 3) Mark v as visited by set its tag to 1
     * 4) add v to a queue
     * 5) while the queue not empty commit:
     *      - set v as the outcome of the queue pop
     *      - for all neighbor n of v:
     *          -- if not visited - add it to the queue and mark it as visited
     * 6) traverse the graph and return false if their is a node who still marked as not visited.
     *
     * @param src - start node
     * @param dest - end (target) node
     * @return the shortest path between given source and destination.
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        if(src == dest) return 0;
        node_data a = g.getNode(src);
        node_data b = g.getNode(dest);
        if(a == null || b == null) return -1;

        setAllTags(-1);
        Queue<node_data> q = new LinkedList<>();
        a.setTag(0);
        q.add(a);
        while(!q.isEmpty()){
            node_data v = q.remove();
            for(node_data n: v.getNi()){
                if(n.getKey() == dest)
                    return v.getTag()+1;
                if(n.getTag() == -1){
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
        q.add(a);
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
