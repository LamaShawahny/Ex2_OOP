package api;

import java.util.*;

public class DirectedWGraph_DS implements  directed_weighted_graph {// this class represents a directed weighted graph with a basic methods

    private HashMap<Integer, node_data> nodes;// hashmap represents our graph
    private int edgeSize;//  number of the edges in the graph
    private int mc; //for testing changes in the graph.


    public DirectedWGraph_DS() {// default  cunstractur
        this.nodes = new HashMap<Integer, node_data>();
        this.edgeSize = 0;
        this.mc = 0;
    }
    @Override
    public node_data getNode(int key) {//The node with the key value
        // TODO Auto-generated method stub
        return this.nodes.get(key);
    }

    @Override
    public edge_data getEdge(int src, int dest) {// returns an edge between  src and  dest
        // TODO Auto-generated method stub
        node_data  source =this.nodes.get(src);
        node_data des=this.nodes.get(dest);
        if(((NodeData) source).getmyhashmap().containsKey(des)==false)// if there is no edge between the nodes the method returns null
            return null;
        return ((NodeData) source).getmyhashmap().get(des);
    }
    @Override
    public void addNode(node_data n) {// this method adds a new node to the graph
        // TODO Auto-generated method stub
        this.nodes.put(n.getKey(),n);
        mc++; // modify the mc
    }

    @Override
    public void connect(int src, int  dest, double w) {// this method takes two nodes and connect them (make them neighbors)
        // TODO Auto-generated method stub
        node_data  source =this.nodes.get(src);
        node_data des=this.nodes.get(dest);
        if(src==dest)// connecting a node to himself does not do anything so this if check if nodes are the same
            return;
        if(source==null || des==null )// if one of the nodes does not exist we  do nothing
            return;
        if(getEdge(src, dest)==null)// if the nodes are not  neighbors modify edgeSize by adding one
        {
            edgeSize++;
        }
        edge_data edge =new EdgeData();
        ((EdgeData) edge).setWeight(w);
        ((EdgeData) edge).setSrc(src);
        ((EdgeData) edge).setdest(dest);
        ((NodeData) source).getmyhashmap().put(des, edge);
        mc++; // modify mc

        ((NodeData) des).getshadylama().add(source);//add the source to the dest list
    }

    @Override
    public Collection<node_data> getV() {// the nodes of the graph
        // TODO Auto-generated method stub
        return this.nodes.values();
    }

    @Override
    public Collection<edge_data> getE(int node_id) {// the edegs of the node_id
        // TODO Auto-generated method stub
        if ((nodes.get(node_id) == null) || ((NodeData) nodes.get(node_id)).getmyhashmap() == null)// if the node hasnt edegs we return null
            return null;
        return ((NodeData) this.nodes.get(node_id)).getmyhashmap().values();//return the Edges
    }

    @Override
    public node_data removeNode(int key) {// this method removes the node with key key
        // TODO Auto-generated method stub
        node_data deletednode = this.nodes.get(key);
        int sum=0;
        if (deletednode != null) {
            if (((NodeData) deletednode).getmyhashmap() != null) {// if the node has edges

                for (node_data n : ((NodeData) deletednode).getmyhashmap().keySet())
                {
                    removeEdge(deletednode.getKey(), n.getKey());// removes nodes from neighbors
                }
                if( ((NodeData) deletednode).getshadylama()!=null) {// remove the nodes in the edges that our node is the dest in them
                    for( node_data n:  ((NodeData) deletednode).getshadylama())
                    {
                        removeEdge(n.getKey(), deletednode.getKey());
                        sum++;
                    }
                }
                this.edgeSize -= ((NodeData) deletednode).getmyhashmap().size(); // removes edges
                this.edgeSize=this.edgeSize-sum;
                mc++;// ad one to the mc
            }
            return nodes.remove(key);
        }
        return null;
    }

    @Override
    public edge_data removeEdge(int src, int dest) {// this method removes an edge between two nodes
        // TODO Auto-generated method stub
        node_data source=this.nodes.get(src);
        node_data des=this.nodes.get(dest);
        if(des==null || source==null)// if no one of the nodes exist Do nothing
            return null;
        if(((NodeData) source).getmyhashmap().containsKey(des)==false)// if the nodes are not connected we don't do any thing
            return null;
        mc++;// modify  mc
        edgeSize--;// subtract one from the number of the edges
        return ((NodeData) source).getmyhashmap().remove(des);// return the edge that we have removed
    }

    @Override
    public int nodeSize() {//  returns the number of the nodes in the graph
        // TODO Auto-generated method stub
        return nodes.values().size();
    }

    @Override
    public int edgeSize() {// return the number of the edges in the graph
        // TODO Auto-generated method stub
        return edgeSize;
    }

    @Override
    public int getMC() {// return  mc
        // TODO Auto-generated method stub
        return mc;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public  Collection<node_data> getEkey(int node_id) {// this method return the neighbors of the node_id
        // TODO Auto-generated method stub
        if ((nodes.get(node_id) == null) || ((NodeData) nodes.get(node_id)).getmyhashmap() == null)
            return null;
        return ((NodeData) this.nodes.get(node_id)).getmyhashmap().keySet();//return the keySet of Edges
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}