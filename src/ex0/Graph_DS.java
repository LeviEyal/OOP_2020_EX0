package ex0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph_DS implements graph{

    private ArrayList<node_data> vertices;
    private int edges = 0;
    private int nodeSize = 0;
    private int mc = 0;
    private HashMap<Integer, node_data> verts;

    public Graph_DS() {
        vertices = new ArrayList<>();
        verts = new HashMap<>();
    }

    public Graph_DS(graph other) {
        vertices = new ArrayList<>(other.getV());
//        for(int i=0; i< vertices.size(); i++){
//            getV(i) = new LinkedList<>(other.getV(i));
//        }
    }

    @Override
    public node_data getNode(int key) {
        try {
            return vertices.get(key);
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean hasEdge(int node1, int node2) {
        return getNode(node1).hasNi(node2);
    }

    @Override
    public void addNode(node_data n) {
        if(!verts.containsValue(n)){
            verts.put(n.getKey(), n);
            nodeSize++;
            mc++;
        }
//        if(!vertices.contains(n)){
//            vertices.add((NodeData) n);
//            nodeSize++;
//            mc++;
//        }
    }

    @Override
    public void connect(int node1, int node2) {
        if(!hasEdge(node1,node2) && node1!=node2){
            getNode(node1).addNi(getNode(node2));
            getNode(node2).addNi(getNode(node1));
            edges++;
            mc++;
        }
    }

    @Override
    public Collection<node_data> getV() {
        return vertices;
    }

    @Override
    public Collection<node_data> getV(int node_id) {
        return vertices.get(node_id).getNi();
    }

    @Override
    public node_data removeNode(int key) {
        if(key>=0 && key< vertices.size() && vertices.get(key).getKey() != -1){
            node_data t = vertices.get(key);
            for (int i = 0; i < vertices.size() ; i++) {
                vertices.get(i).removeNode(t);
            }
            vertices.get(key).getNi().clear();
        }

        return null;
    }

    @Override
    public void removeEdge(int node1, int node2) {
        if(hasEdge(node1,node2)){
            System.out.println("tt");
            getNode(node1).removeNode(getNode(node2));
            getNode(node2).removeNode(getNode(node1));
            mc++;
            edges--;
        }
    }

    @Override
    public int nodeSize() {
        return nodeSize;
    }

    @Override
    public int edgeSize() {
        return edges;
    }

    @Override
    public int getMC() {
        return mc;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i=0; i< vertices.size(); i++){
            s += (getNode(i).getKey())+" "+getV(i) + "\n";
        }

        return s;
    }
}
