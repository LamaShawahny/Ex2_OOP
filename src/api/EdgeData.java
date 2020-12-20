package api;

public class EdgeData implements edge_data{ // this class represent an edge between two nodes

    int Src;//the source point of the edge
    private int Dest;// the destination of point the edge
    private double weight;// the weight of the edge
    private String info;// the info of the edge
    private int tag;// the tag of the edge
    public EdgeData()//a default  cunstractur
    {
        this.Src=0;
        this.Dest=0;
        this.weight=0;
        this.info="";
        this.tag=0;
    }
    public void setSrc(int src)
    {
        this.Src=src;
    }// set the source of the edge
    public void setdest(int d)
    {
        this.Dest=d;
    }// set the destination of the edge
    public void setWeight(double w)
    {
        this.weight=w;
    }//  set the weight of the edge
    @Override
    public int getSrc() {// get the source of the edge
        // TODO Auto-generated method stub
        return this.Src;
    }

    @Override
    public int getDest() {// return the destination of the edge
        // TODO Auto-generated method stub
        return this.Dest;
    }

    @Override
    public double getWeight() {//  return the weight of the edge
        // TODO Auto-generated method stub
        return this.weight;
    }

    @Override
    public String getInfo() {// return the info of the edge
        // TODO Auto-generated method stub
        return this.info;
    }

    @Override
    public void setInfo(String s) {// set the info of the edge
        // TODO Auto-generated method stub
        this.info=s;
    }

    @Override
    public int getTag() {// return the tag of the edge
        // TODO Auto-generated method stub
        return this.tag;
    }

    @Override
    public void setTag(int t) {// set the tag of the edge
        // TODO Auto-generated method stub
        this.tag=t;
    }

}