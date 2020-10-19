package ex0;

import java.util.Collection;
import java.util.LinkedList;

public class NodeData implements node_data{

    private static int numOfVertices = 0;
    private LinkedList<node_data> ni;
    private String info;
    private int tag;
    private int key;

    public NodeData(){
        ni = new LinkedList<>();
        info = "";
        key = numOfVertices++;
    }

    @Override
    public int getKey() {
        return key;
    }

    @Override
    public Collection<node_data> getNi() {
        return ni;
    }

    @Override
    public boolean hasNi(int key) {
        for(node_data node : ni){
            if(node.getKey() == key)
                return true;
        }
        return false;
    }

    @Override
    public void addNi(node_data t) {
        if(!ni.contains(t))
            ni.add(t);
    }

    @Override
    public void removeNode(node_data node) {
        ni.remove(node);
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String s) {
        info = ""+s;
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
        return "#"+key+" ";
    }
}
