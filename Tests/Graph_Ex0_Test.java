package Tests;

import ex0.*;

import java.util.List;
import java.util.Random;

public class Graph_Ex0_Test {
    static int seed = 3;
    static Random _rnd = new Random(seed);
    static int v_size = 10;
    static int e_size = v_size*3;
    static graph g0 = new Graph_DS(), g1;
    static graph_algorithms ga;

    public static void main(String[] args) {
        test0();
//        test1();
//        System.out.println("g0:\n"+g0);
//        test2();
//        System.out.println("g0:\n"+g0);
//        test3();
//        System.out.println(g0);
    }

    private static void test0() {
        graph g = new Graph_DS();
        for(int i=0; i<13; i++)
            g.addNode(new NodeData());
        g.connect(0,1);
        g.connect(1,2);
        g.connect(2,3);
        g.connect(4,0);
        g.connect(5,1);
        g.connect(5,6);
        g.connect(6,2);
        g.connect(7,3);
        g.connect(8,4);
        g.connect(9,8);
        g.connect(9,10);
        g.connect(10,5);
        g.connect(10,11);
        g.connect(11,6);
        g.connect(11,12);
        g.connect(12,7);
        Graph_Algo gra = new Graph_Algo(g);
        System.out.println(g);
        System.out.println("isConnected: "+gra.isConnected());
        System.out.println("Shortest way 0->12 has: "+gra.shortestPathDist(0,12)+" nodes");
        System.out.println("Shortest way 10->6 has: "+gra.shortestPathDist(10,6)+" nodes");
        System.out.println("Shortest way 8->5 has: "+gra.shortestPathDist(8,5)+" nodes");
        System.out.println("Shortest way 3->9 has: "+gra.shortestPathDist(3,9)+" nodes");
        System.out.println("Shortest way 11->1 has: "+gra.shortestPathDist(11,1)+" nodes");
        System.out.println("Shortest way 4->7 has: "+gra.shortestPathDist(4,7)+" nodes");
        System.out.println("Shortest way 2->10 has: "+gra.shortestPathDist(2,10)+" nodes");
        System.out.println("Shortest way 12->7 has: "+gra.shortestPathDist(12,7)+" nodes");
        graph gr = gra.copy();
        gra.init(gr);
        gr.removeNode(5);
        gr.removeNode(6);
        System.out.println("\nisConnected: "+gra.isConnected());
        System.out.println("Shortest way 0->12 has: "+gra.shortestPathDist(0,12)+" nodes");
        System.out.println("Shortest way 10->6 has: "+gra.shortestPathDist(10,6)+" nodes");
        System.out.println("Shortest way 8->5 has: "+gra.shortestPathDist(8,5)+" nodes");
        System.out.println("Shortest way 3->9 has: "+gra.shortestPathDist(3,9)+" nodes");
        System.out.println("Shortest way 11->1 has: "+gra.shortestPathDist(11,1)+" nodes");
        System.out.println("Shortest way 4->7 has: "+gra.shortestPathDist(4,7)+" nodes");
        System.out.println("Shortest way 2->10 has: "+gra.shortestPathDist(2,10)+" nodes");
        System.out.println("Shortest way 12->7 has: "+gra.shortestPathDist(12,7)+" nodes");
        System.out.println("Shortest way 8->11 has: "+gra.shortestPathDist(8,11)+" nodes");
        System.out.println("Shortest way 3->8 has: "+gra.shortestPathDist(3,8)+" nodes");

        System.out.println("Shortest way 0->12 : "+gra.shortestPath(0,12));
        System.out.println("Shortest way 10->6 : "+gra.shortestPath(10,6));
        System.out.println("Shortest way 8->5 : "+gra.shortestPath(8,5));
        System.out.println("Shortest way 3->9 : "+gra.shortestPath(3,9));
        System.out.println("Shortest way 11->1 : "+gra.shortestPath(11,1));
        System.out.println("Shortest way 4->7 : "+gra.shortestPath(4,7));
        System.out.println("Shortest way 2->10 : "+gra.shortestPath(2,10));
        System.out.println("Shortest way 12->7 : "+gra.shortestPath(12,7));
        System.out.println("Shortest way 8->11 : "+gra.shortestPath(8,11));
        System.out.println("Shortest way 3->8 : "+gra.shortestPath(3,8));
//        System.out.println(gra.shortestPath(10,4));
//        gr.removeNode(12);
//        gr.removeNode(0);
//        System.out.println("\nisConnected: "+gra.isConnected());
//        System.out.println("Shortest way 0->12 has: "+gra.shortestPathDist(0,12)+" nodes");
//        System.out.println("Shortest way 10->6 has: "+gra.shortestPathDist(10,6)+" nodes");
//        System.out.println("Shortest way 8->5 has: "+gra.shortestPathDist(8,5)+" nodes");
//        System.out.println("Shortest way 3->9 has: "+gra.shortestPathDist(3,9)+" nodes");
//        System.out.println("Shortest way 11->1 has: "+gra.shortestPathDist(11,1)+" nodes");
//        System.out.println("Shortest way 4->7 has: "+gra.shortestPathDist(4,7)+" nodes");
//        System.out.println("Shortest way 2->10 has: "+gra.shortestPathDist(2,10)+" nodes");
//        System.out.println("Shortest way 12->7 has: "+gra.shortestPathDist(12,7)+" nodes");
//        System.out.println("Shortest way 8->11 has: "+gra.shortestPathDist(8,11)+" nodes");

    }

    public static void test1() {

        for(int i=0;i<v_size;i++) {
            node_data n = new NodeData();
            g0.addNode(n);
        }
        while(g0.edgeSize() < e_size) {
            int a = nextRnd(0,v_size);
            int b = nextRnd(0,v_size);
            g0.connect(a,b);
        }
         System.out.println("finish");
    }
    public static void test2() {
        g0.removeEdge(2,3);
        g0.removeEdge(9,3);
        g0.removeNode(0);
        g0.removeNode(0);
        g0.addNode(new NodeData());
        g0.removeNode(2);
        g0.removeNode(8);
        g0.connect(6,10);
    }
    public static void test3() {
        ga = new Graph_Algo(g0);
        g1 = ga.copy();
        ga.init(g1);
//        g1.addNode(new NodeData());
//        g1.connect(10,9);
//        g0.removeNode(5);
        System.out.println("g0:\n"+g0);
        System.out.println("g1:\n"+g1+"\nis connected: "+ ga.isConnected());
//        System.out.println("shortest path: 1,9 dist="+ ga.shortestPathDist(1,9));
//        System.out.println("shortest path: 3,2 dist="+ ga.shortestPathDist(3,4));
        List<node_data> sp = ga.shortestPath(3,5);
        System.out.println(sp);
    }
    public static int nextRnd(int min, int max) {
        double v = nextRnd(0.0+min, (double)max);
        int ans = (int)v;
        return ans;
    }
    public static double nextRnd(double min, double max) {
        double d = _rnd.nextDouble();
        double dx = max-min;
        double ans = d*dx+min;
        return ans;
    }
}
