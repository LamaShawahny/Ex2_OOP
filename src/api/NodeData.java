package api;

import java.util.HashMap;
import java.util.*;

public class NodeData implements node_data {// this class represent nodes of the graph with a basic methods
    private int id=0;// the id of the node
    private int key;// the key of the node
    private geo_location Loc;// the loctation of the node
    private double Weight;// the weight of the node
    private String info;//the info of rhe node
    private int tag;//our node tag
    private HashMap<node_data, edge_data> Ni;// this hashmap represent the edges between our node and is't neighbors
    private LinkedList<node_data> shadylama ;// we will use this list in the method connect to save the destination of the edge
                                            // and we will use it also in  method remove node in DirectedWGraph_DS class

    public NodeData() { // default cunstractur
        key=id++;
        this.id=id+1;
        this.info="";
        this.tag=0;
        this.Ni=new HashMap<node_data, edge_data>();
        this.shadylama=new LinkedList<node_data>();
        this.Weight=Double.POSITIVE_INFINITY;

    }
    public int getid()// this method return the id of the node
    {
        return this.id;
    }
    public NodeData(int key)// a cunstractur with the node key value
    {

        this.Ni=new HashMap<node_data, edge_data>();
        this.shadylama=new LinkedList<node_data>();
        this.key=key;
        this.Loc=new GeoLocation();
        this.Weight=Double.POSITIVE_INFINITY;
        this.info="";
        this.tag=0;
        this.id=id+1;
    }
    public LinkedList<node_data> getshadylama()// returns the list that contains the edeges that our node key is the dest
    {
        return this.shadylama;
    }
    public HashMap<node_data, edge_data> getmyhashmap()// returns a hashmap that contains the edges between our node and is't neighbors
    {
        return this.Ni;
    }
    public Collection<node_data> getmyne()// returns a list that contains the neighbors of our node
    {
        return this.Ni.keySet();
    }
    public Collection<edge_data> getmyedges()// returns the edges that our node is the src in them
    {
        return this.Ni.values();
    }
    public void setKey(int key)// this method sets the key value
    {
        this.key=key;
    }

    @Override
    public int getKey() {// this method returns the key value
        // TODO Auto-generated method stub
        return this.key;
    }

    @Override
    public geo_location getLocation() {// this method returns the geo location
        // TODO Auto-generated method stub
        return this.Loc;
    }

    @Override
    public void setLocation(geo_location p) { // this method sets the geo location
        // TODO Auto-generated method stub
        this.Loc=p;
    }

    @Override
    public double getWeight() {// this method returns the node weight
        // TODO Auto-generated method stub
        return this.Weight;
    }

    @Override
    public void setWeight(double w) {// this method sets the node weight
        // TODO Auto-generated method stub
        this.Weight=w;
    }

    @Override
    public String getInfo() {// this method returns the node info
        // TODO Auto-generated method stub
        return this.info;
    }

    @Override
    public void setInfo(String s) {// this method sets the node info
        // TODO Auto-generated method stub
        this.info=s;
    }

    @Override
    public int getTag() {// this method returns the node tag
        // TODO Auto-generated method stub
        return this.tag;
    }

    @Override
    public void setTag(int t) {// this method sets the node tag
        // TODO Auto-generated method stub
        this.tag=t;
    }
}