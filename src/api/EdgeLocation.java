package api;

public class EdgeLocation implements edge_location{// this class is represent the location of the edge

    private edge_data Edge;// the edge
    public EdgeLocation()//a default  cunstractur
    {
        this.Edge=new EdgeData();
    }
    public EdgeLocation(edge_data e)
    {
        this.Edge=e;
    }//a cunstractur with the edge value
    @Override
    public edge_data getEdge() {// this method return the edge
        // TODO Auto-generated method stub
        return this.Edge;
    }

    @Override
    public double getRatio() {
        // TODO Auto-generated method stub
        return 0;
    }

}
