package api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.io.ObjectInputStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
 import java.io.IOException;


public class DWGraph_Algo implements dw_graph_algorithms{// this class  represents a directed weighted graph with a basic methods complex methods

    private directed_weighted_graph MyGraph;// our graph
    private int W=0,B=1,G=2;
    private int V;
    private Queue<Integer> Q;
    private int P[];
    private int sizeofarr;
    private int color[] ;
    final int nill=-1;
    private List<node_data> ls;
    private double prev[] ;
    private double destination[] ;

    private void dijkstra(node_data s,node_data dest) { //
        if(s.getKey()==dest.getKey() && s.getTag()==1)
        {
            return;
        }
        Collection<edge_data> nie=MyGraph.getE(s.getKey());
        Collection<node_data> ni=new ArrayList<>();
        for(edge_data e: nie)
        {
            ni.add(MyGraph.getNode(e.getDest()));
        }
        if(ni!=null)
        {
            for(node_data e:ni)
            {
                double v =this.MyGraph.getNode(e.getKey()).getWeight();
                double cu=MyGraph.getEdge(s.getKey(), e.getKey()).getWeight();
                double u=this.MyGraph.getNode(s.getKey()).getWeight();
                if(u+cu<v)
                {
                    this.MyGraph.getNode(e.getKey()).setWeight(this.MyGraph.getNode(s.getKey()).getWeight()+MyGraph.getEdge(s.getKey(), e.getKey()).getWeight());
                    dijkstra(this.MyGraph.getNode(e.getKey()), dest);
                    s.setTag(1);
                }
            }
        }


    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  directed_weighted_graph transpose(directed_weighted_graph g)// this method transpose the graph edges
    {
        for (node_data n:MyGraph.getV()) {
            g.addNode(n);
        }
        for(node_data n: MyGraph.getV())
            for(edge_data e: ((NodeData)n).getmyedges()) {
                int newsrc=e.getDest();
                int newdest=e.getSrc();
                g.connect(newdest, newsrc, e.getWeight());
            }
        return g;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void BFS(int s) {//Breadth-first search (BFS) is an algorithm that is used to graph info or searching tree or traversing structures.
        // The full form of BFS is the Breadth-first search.

        for (int i = 0; i <sizeofarr; i++) {
            color[i] = W;
            P[i] = nill;
        }//end for
        V = s;
        color[s] = G;
        Q.add(V);
        while (!Q.isEmpty()) {
            int u = Q.poll();
            if(MyGraph.getE(u)!=null)
            {
                for (edge_data n : MyGraph.getE(u)) {
                    int v = ((node_data) n).getKey();
                    if (color[v] == W) {
                        color[v] = G;
                        P[v] = u;
                        Q.add(v);
                    }
                }

            }
            color[u] = B;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void init(directed_weighted_graph g) {//init the graph on which this set of algorithms operates on
        this.MyGraph=g;
        Iterator<node_data> itr = MyGraph.getV().iterator();
        int maxkey=0;
        while(itr.hasNext()) {
            int n =itr.next().getKey();
            if(maxkey<n)
                maxkey=n;
        }
        maxkey++;
        sizeofarr=maxkey;
        V=0;
        P=new int[sizeofarr];
        color=new int[sizeofarr];
        Q=new ArrayBlockingQueue<Integer>(sizeofarr);
        ls=new ArrayList<node_data>();
        destination=new double[sizeofarr];
        prev=new double[sizeofarr];

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public directed_weighted_graph getGraph() {// this method return the graph
        // TODO Auto-generated method stub
        return  this.MyGraph;
    }

    @Override
    public directed_weighted_graph copy() {// this method return a copy of the graph
        // TODO Auto-generated method stub
        directed_weighted_graph CopyGraph = new DirectedWGraph_DS();
        Iterator<node_data> Itr = this.MyGraph.getV().iterator();
        while (Itr.hasNext()) {
            node_data N= new NodeData (Itr.next().getKey());
            CopyGraph.addNode(N);
        }
        for (node_data n : this.MyGraph.getV()) {
            for (edge_data internalN : this.MyGraph.getE(n.getKey())) {
                CopyGraph.connect(internalN.getSrc(), internalN.getDest(),internalN.getWeight());
            }
        }
        return CopyGraph;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean isConnected() {// this method check if all the nodes in the graph are connected using the BFS algorithm
        // TODO Auto-generated method stub
        if(MyGraph.getV().isEmpty())return true;
        BFS(sizeofarr-1);
        for(node_data u : MyGraph.getV())
        {
            if (color[u.getKey()]!=B) {
                return false;
            }
        }

        this.MyGraph=transpose(new DirectedWGraph_DS());
        if(MyGraph.getV().isEmpty())return true;
        BFS(sizeofarr-1);
        for(node_data u : MyGraph.getV())
        {
            if (color[u.getKey()]!=B) {
                return false;
            }
        }

        return true;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setNodes() { // this method set the graph nodes wight to POSITIVE_INFINITY and the tag to 0
        Collection<node_data> temp = this.MyGraph.getV();
        for (node_data node : temp)
        {
            node.setTag(0);
            node.setWeight(Double.POSITIVE_INFINITY);//set the nodes
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public double shortestPathDist(int src, int dest) {// this method return the smallest distance between the two nodes using
        // TODO Auto-generated method stub

        if(src==dest)// if the two nodes are the same return 0
            return 0;
        if(this.MyGraph.getNode(src)==null||this.MyGraph.getNode(dest)==null)// if one of the nodes ar'nt exist return -1
            return -1;
        setNodes();// set the graph nodes weight and tag
        node_data temp=this.MyGraph.getNode(src);
        temp.setWeight(0);
        dijkstra(temp, MyGraph.getNode(dest));
        if(MyGraph.getNode(dest).getWeight()==Double.POSITIVE_INFINITY)// if we did not find a path we return -1
            return -1;
        double asn=this.MyGraph.getNode(dest).getWeight();
        return asn;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<node_data> shortestPath(int src, int dest) {/// this method return the a list that contains the shortest path
        // between the src and dest using the findtheminpath
        // TODO Auto-generated method stub
        if(this.MyGraph.getNode(src) == null || this.MyGraph.getNode(dest) == null)// if one of the nodes ar'nt exist return -1
            return null;
        if (src==dest)// if the two nodes are the same return a list that contains one of them
        {
            List<node_data> myls=new ArrayList<>();
            myls.add(MyGraph.getNode(src));
            return myls;
        }
        if(shortestPathDist(src, dest)==-1)
            return null;
        List<node_data> pathlist =findtheminpath(src,dest);
        List<node_data> newpath= new ArrayList<>();
        for (node_data n1 :pathlist)
        {
            if(n1!=null) {
                newpath.add(n1);
            }
        }
        return newpath;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private List<node_data> findtheminpath( int src, int dest)//this algorithm I find the psodocode in the internet
    //this method find the shortest path between the src and the dest
    {
        double a=0;
        LinkedList<node_data> Q = new LinkedList<node_data>();
        List<node_data> list = new LinkedList();
        node_data[] array = new node_data[prev.length];
        resetarr();
        for(node_data n : MyGraph.getV()) {
            Q.add(n);
        }

        destination[src] = 0;

        while (!Q.isEmpty()) {
            int index = getmin(Q);
            node_data u =MyGraph.getNode(index);
            Q.remove(u);
            for (edge_data e1 : MyGraph.getE(u.getKey())) {
                if (Q.contains(MyGraph.getNode(e1.getDest()))) {
                    a = destination[index] + e1.getWeight();
                    if(a < destination[e1.getDest()]) {
                        destination[e1.getDest()]= a;
                        prev[e1.getDest()] = u.getKey();
                    }
                }
            }
        }
        node_data u=MyGraph.getNode(dest);
        int j=0;
        if(prev[u.getKey()] != -1 || u.getKey()==src)
            while(u != null) {
                array[j]=u;
                j++;
                u = MyGraph.getNode((int)prev[u.getKey()]);
            }
        if(j==1)
            return null;
        while(j>=0) {
            list.add(array[j]);
            j--;
        }
        return list;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int getmin(LinkedList<node_data> list) {//this method return the the index of the min node
        int mini=0;
        double min = Double.POSITIVE_INFINITY;
        for(int i=0;i<destination.length;i++) {
            node_data n1=MyGraph.getNode(i);
            if(destination[i]<min && list.contains(n1)) {
                mini =i;
                min=destination[i];
            }
        }
        return mini;

    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void  resetarr() // this method set the prev array values to -1 and the destination to Double.POSITIVE_INFINITY
    {
        for(int i=0;i<prev.length;i++) {
            destination[i] = Double.POSITIVE_INFINITY;
            prev[i] = nill;
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean save(String file) {
        // TODO Auto-generated method stub
        Gson g=new GsonBuilder().setPrettyPrinting().create();
        String str=g.toJson(MyGraph);
        System.out.println(str);
        try {
            PrintWriter p=new PrintWriter(new File(file));
            p.write(str);
            p.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;

        }
        return true;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean load(String file) {
        // TODO Auto-generated method stub
        try {
            FileInputStream MygraphhFile = new FileInputStream(file);
            ObjectInputStream OtherGraphFile = new ObjectInputStream(MygraphhFile);
            MyGraph = (directed_weighted_graph)
                    OtherGraphFile.readObject();
            OtherGraphFile.close();
            MygraphhFile.close();
            return true;
        }
        catch (IOException ex) {
            return false;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }


}