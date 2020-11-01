package ex0;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 */
public class NodeData implements node_data {

    private static int numOfVertices = 0;
    private HashMap<Integer,node_data> ni = new HashMap<>();
    private String info = "";
    private int tag = 0;
    private final int key ;

    public NodeData() {
        key = numOfVertices++;
    }

    /**
     * @param other - another Node to copy from
     */
    public NodeData(node_data other) {
        ni = new HashMap<>();
        info = other.getInfo();
        tag = other.getTag();
        key = other.getKey();
    }

    /**
     *
     * @return key of this node
     */
    @Override
    public int getKey() {
        return key;
    }

    /**
     *
     * @return A collection of all neighbors of this node
     */
    @Override
    public Collection<node_data> getNi() {
        return ni.values();
    }

    @Override
    public boolean hasNi(int key) {
        return ni.containsKey(key);
    }

    @Override
    public void addNi(node_data t) {
            ni.putIfAbsent(t.getKey(),t);
    }

    @Override
    public void removeNode(node_data node) {
        getNi().remove(node);
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String s) {
        info = "" + s;
    }

    @Override
    public int getTag() {
        return tag;
    }

    @Override
    public void setTag(int t) {
        tag = t;
    }

    @Override
    public String toString() {
        return "#" + key + " ";
    }
}
