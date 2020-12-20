package api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedWGraph_DSTest {
    private directed_weighted_graph g;


    @Test
    public directed_weighted_graph graph() {
        g = new DirectedWGraph_DS();
        node_data n0=new NodeData(6);
        node_data n1=new NodeData(1);
        node_data n2=new NodeData(2);
        node_data n3=new NodeData(3);
        node_data n4=new NodeData(4);

        g.addNode(n0);
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);

        g.addNode(n4);

        g.connect(n0.getKey(), n1.getKey(), 4);
        g.connect(n1.getKey(), n2.getKey(), 5);
        g.connect(n2.getKey(), n1.getKey(), 2);
        g.connect(n2.getKey(), n3.getKey(), 1);
        g.connect(n0.getKey(), n3.getKey(), 16);


        return g;
    }

    @Test
    void getNode() {
        node_data a = g.getNode(20);
        assertNull(a);

    }



    @Test
    void addNode() {
        int NodesSize = g.nodeSize();
        node_data n = g.getNode(6);
        g.addNode(n);
        assertEquals(NodesSize, g.nodeSize());
        NodesSize++;
        node_data n2= g.getNode(7);
        g.addNode(n2);
        g.connect(7, 3,4);
        assertEquals(NodesSize, g.nodeSize());
        g.removeNode(7);

    }

    @Test
    void connect() {
        int EdgesSize = g.edgeSize();
        g.connect(3, 4,1);
        EdgesSize++;
        assertEquals(EdgesSize, g.edgeSize());
        g.connect(3, 4,1);
        assertEquals(EdgesSize, g.edgeSize());
        g.connect(3, 4,3);
        assertEquals(EdgesSize, g.edgeSize());
        g.removeEdge(3, 4);
    }



    @Test
    void removeNode() {
        directed_weighted_graph  graph =new DirectedWGraph_DS();
        node_data n1=new NodeData(1);
        node_data n2=new NodeData(2);
        node_data n3=new NodeData(3);
        node_data n4=new NodeData(4);

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.connect(1,2,10);
        graph.connect(2,1,8);
        graph.connect(3,4,9);
        graph.removeNode(5);
        graph.removeNode(1);
        assertEquals(1,graph.edgeSize());
        assertEquals(3,graph.nodeSize());
    }

    @Test
    void removeEdge() {
        int EdgesSize = g.edgeSize();
        assertEquals(g.edgeSize(), EdgesSize);
        EdgesSize--;
        g.removeEdge(2, 1);
        assertEquals(g.edgeSize(), EdgesSize);
        g.connect(2, 1,1);
    }

    @Test
    void nodeSize() {
        directed_weighted_graph  graph =new DirectedWGraph_DS();
        node_data n0=new NodeData(6);
        node_data n1=new NodeData(1);
        node_data n2=new NodeData(1);

        graph.addNode(n0);
        graph.addNode(n1);
        graph.addNode(n2);

        graph.removeNode(3);
        graph.removeNode(1);
        graph.removeNode(1);
        int size = graph.nodeSize();
        assertEquals(1,size);


    }

    @Test
    void edgeSize() {
        assertEquals(g.edgeSize(),5);
    }


}