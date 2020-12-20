package api;
 import java.util.Random;
 import java.util.Collection;
 import java.util.List ;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DWGraph_AlgoTest {
    directed_weighted_graph graph = new DirectedWGraph_DS();
    directed_weighted_graph graph2 = new DirectedWGraph_DS();
    dw_graph_algorithms  graphalgo = new DWGraph_Algo();
    dw_graph_algorithms  graphalgo2 = new DWGraph_Algo();
    private static Random _rnd = null;


    @Test
    void isConnected() {
        node_data n0=new NodeData(1);
        node_data n1=new NodeData(10);
        node_data n2=new NodeData(100);
        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.connect(1, 10, 4);
        graph.connect(9, 100, 9);

        graphalgo.init(graph);
        assertFalse(graphalgo.isConnected());


        node_data n3=new NodeData(3);
        node_data n4=new NodeData(7);
        node_data n5=new NodeData(9);
        graph2.addNode(n0);
        graph2.addNode(n1);
        graph2.addNode(n2);
        graph2.addNode(n3);
        graph2.addNode(n4);
        graph2.addNode(n5);
        graph2.connect(1, 7, 9);
        graph2.connect(7, 3, 9);
        graph2.connect(1, 3, 2);
        graph2.connect(1, 10, 5);
        graph2.connect(3, 10, 8);

        graphalgo.init(graph2);
        assertTrue(graphalgo2.isConnected());


    }

    @Test
    void shortestPathDist() {
        node_data n0=new NodeData(1);
        node_data n1=new NodeData(10);
        node_data n2=new NodeData(100);
        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.connect(1, 10, 4);
        graph.connect(10, 100, 9);
        graph.connect(1, 100, 90);

        graphalgo.init(graph);
        assertTrue(graphalgo.isConnected());
        double d = graphalgo.shortestPathDist(1, 100);
        assertEquals(d, 13);

        node_data n3=new NodeData(8);
        node_data n4=new NodeData(2);
        node_data n5=new NodeData(14);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.connect(2, 8, 5);

        graphalgo2.init(graph2);
        assertFalse(graphalgo.isConnected());
        double d2 = graphalgo2.shortestPathDist(8, 14);
        assertEquals(d2, -1);

    }

    @Test
    void shortestPath() {
        node_data n0=new NodeData(1);
        node_data n1=new NodeData(10);
        node_data n2=new NodeData(100);
        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);
        graph.connect(1, 10, 8);
        graph.connect(10, 100, 6);
        graph.connect(100, 1, 80);

        graphalgo.init(graph);
        List<node_data> sp = graphalgo.shortestPath(100, 1);
        int[] checkKey = {1, 10, 100};
        int i = 0;
        for (node_data n : sp) {
            assertEquals(n.getKey(), checkKey[i]);
            i++;
        }

        node_data n3=new NodeData(9);
        node_data n4=new NodeData(2);
        node_data n5=new NodeData(300);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.connect(2, 9, 5);

        graphalgo2.init(graph2);
        List<node_data> sp1 = graphalgo2.shortestPath(2, 9);
        int[] checkKey2 = {2, 9};
        i = 0;
        for (node_data nn : sp1) {
            assertEquals(nn.getKey(), checkKey2[i]);
            i++;
        }
        sp1 = graphalgo2.shortestPath(2, 2);
        int[] checkKey3 = {2};
        i = 0;
        for (node_data nn : sp1) {
            assertEquals(nn.getKey(), checkKey3[i]);
            i++;
        }
    }
}