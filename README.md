assignment 3
--------------------------------------------------------------

this assignment is an improved version of assignment 2, it works on developing a data structure of a directed weighted graph.
The Assignment contains 2 parts. 
1) api : consists of 7 interfaces and their implementations, testers...
2)gameClient:  we use the data structures and the algorithms that we had developed to build a Pokemon game.
 it consists of 7 classes 

  PART 1:MAIN CLASSES
--------------------------------------------------------------------------------------------------------------------------------------------------------------
 node_data interface <-->NodeData class :

*This class represents set of operations applicable on a node (vertex) in an (directional) weighted graph.
To implement the graph I used the  collection data structure :hashmap ,Since storing and retrieving elements from the HashMap takes constant O(1) time.
 and we also used the data structure LinkedList.

    properties :
    private int id=0 - the id of the node
    private int key - the key of the node
    private geo_location Loc - the loctation of the node
    private double Weight - the weight of the node
    private String info -the info of rhe node
    private int tag -our node tag
    private HashMap<node_data, edge_data> Ni- this hashmap represent the edges between our node and is't neighbors
    private LinkedList<node_data> shadylama - we will use this list in the method connect to save the destination of the edge, and we will use it also in  method remove node                                                                in DirectedWGraph_DS class.
    constructors:
    public NodeData() :default constructor
    public NodeData(int key): another cunstractur with the node key value

     Getters and setters for the  properties in O(1)complexity...

  --------------------------------------------------------------------------------------------------------------------------------------------------------------

  directed_weighted_graph interface  <-->DirectedWGraph_DS class  :

 *This class represents an directional weighted graph. It supports a large number of nodes , The implementation  based on an efficient compact representation.
  To implement this class we used the  collection data structure : hashmap ,Since storing and retrieving elements from the HashMap takes constant O(1) time.
   properties :
     private HashMap<Integer, node_data> nodes - hashmap represents the nodes in our graph
     private int edgeSize;-  number of the edges in the graph
     private int mc; -for testing changes in the graph.
 
     public DirectedWGraph_DS()  - default  cunstractur

    methods: 
    node_info getNode(int  -the node_data by the node_id-O(1)
    public double getEdge   -the weight if the edge (node1, node1). In case there is no such edge - should return -1 -O(1)
    public  void addNode(node_data n) -adds a new node to the graph with the given given key.-O(1)
    public void connect(int node1, int node2, double w)- Connect an edge between node1 and node2, with an edge with weight >=0. -O(1)
    public Collection<node_data> getV() -return a pointer (shallow copy) for the collection representing all the nodes in the graph -O(1)
    public Collection<edge_data> getE(int node_id)) -This method returns a pointer (shallow copy) for the collection representing all the edges getting out of the given node (all the edges                                                       starting (source) at the given node).- O(n)
    public node_data removeNode(int key)-  Delete the node (with the given ID) from the graph - and removes all edges which starts or ends at this node. O(1)
    public edge_data removeEdge(int src, int dest)- Delete the edge from the graph- O(1)
    public  int nodeSize ()- the number of vertices (nodes) in the graph.-O(1)
    public  int edgeSize () -get edges size -O(1)
    public int getMC () -get  mc -O(1)
 ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

  dw_graph_algorithms interface  <--> DWGraph_Algo class 

*To implement this class we used the Dijkstra  algorithm for finding the shortest paths from source to all vertices in the given graph.
 we generate a SPT (shortest path tree) with given source as root. We maintain two sets, one set contains vertices included in shortest path tree, other set includes vertices not yet included in shortest path tree. At every step of the algorithm, we find a vertex which is in the other set (set of not yet included) and has a minimum distance from the source.
 and we also used BFS- Breadth-first search - is an algorithm that is used to graph info or searching tree or traversing structures.The full form of BFS is the Breadth-first search.

  properties :
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

  main methods:
   public void init(directed_weighted_graph g) -Init the graph on which this set of algorithms operates on.
   public directed_weighted_graph copy() {-returns a copy of the graph
   public boolean isConnected() : Check if there is a valid path from EVREY node to each other node using the BFS algorithm
    public double shortestPathDist(int src, int dest) -this method return the smallest distance between the two nodes using the dijkstra algorithm
    List<node_data> shortestPath(int src, int dest) - this method return the a list that contains the shortest path
                                                     between the src and dest using the findtheminpath   helper algorithm that we used .
  secondary methods :

  private void dijkstra(node_data s,node_data dest) - Dijkstra  Algorithm
  public  directed_weighted_graph transpose(directed_weighted_graph g)-this method transpose the graph edges
  public void BFS(int s) -Breadth-first search (BFS) is an algorithm that is used to graph info or searching tree or traversing structures.
                          The full form of BFS is the Breadth-first search.
     
 private List<node_data> findtheminpath( int src, int dest)-this method find the shortest path between the src and the dest( we found psudocode that helped us in the Internet the link is in the sources )
 private int getmin(LinkedList<node_data> list) -this method return the the index of the min node

   -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   implements geo_location  interface  <--> GeoLocation  class

    * this class represent a 3D point
    properties :
    private double x -the coordinate of x
    private double y - the coordinate of y
    private double z -  the coordinate of z
    public GeoLocation() -a default  cunstractur 
    methods :
    public double distance(geo_location g) -this method return the distance between two 3D points
    Getters and setters for the  properties in O(1)complexity...
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  PART 2:MAIN CLASSES

  In this part of the assignment, we build a game by using algorithms from part 1. , this game was supposed to be  Pockemns game with agents chasing Pokemon.
  but we decided to do instead of a Covid -19 game that represents the 2020 main event.
  we Did some changes in the Ex2 class specifically in the moveNode method
  we also changes in Arena class- isOnEdge method 
  Intence of design : we change MyFrame class To add sound we add threads in Ex2 and we add a class called simplePlayer. 






sources:
https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
https://github.com/simon-pikalov/Ariel_OOP_2020
https://www.baeldung.com/java-collections-complexity
https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
https://www.youtube.com/watch?v=s-CYnVz-uh4
https://www.youtube.com/watch?v=oDqjPvD54Ss
https://stackoverflow.com/questions/34664134/implementing-a-graph-using-a-hashmap
https://stackabuse.com/graphs-in-java-representing-graphs-in-code/
https://www.geeksforgeeks.org/implementing-generic-graph-in-java/
https://www.khanacademy.org/computing/computer-science/algorithms/breadth-first-search/a/breadth-first-search-and-its-uses
BFSמצגת (4) איליזבת   
Asignment 2 -lama shawahny 
Aaignment 2 -shady shanem 

