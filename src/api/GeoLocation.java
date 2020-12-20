//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package api;
public class GeoLocation implements geo_location {// this class represent a 3D point

    private double x; // the coordinate of x
    private double y; // the coordinate of y
    private double z; // the coordinate of z
    public GeoLocation()//a default  cunstractur
    {
        this.x=0;
        this.z=0;
        this.y=0;
    }
    public void setx(double x) // this method set the coordinate of x
    {
        this.x=x;
    }
    public void sety(double y) // this method set the coordinate of y
    {
        this.y=y;
    }
    public void setz(double z) // this method set the coordinate of z
    {
        this.z=z;
    }

    @Override
    public double x() { // this method return the coordinate of x
        // TODO Auto-generated method stub
        return this.x;
    }

    @Override
    public double y() { // this method return the coordinate of y
        // TODO Auto-generated method stub
        return this.y;
    }

    @Override
    public double z() { // this method return the coordinate of z
        // TODO Auto-generated method stub
        return this.z;
    }

    @Override
    public double distance(geo_location g) {// this method return the distance between two 3D points
        // TODO Auto-generated method stub
        double xdis=Math.pow(this.x-g.x(),2);
        double ydis=Math.pow(this.y-g.y(),2);
        double zdis=ydis=Math.pow(this.z-g.z(),2);
        double dis=Math.sqrt(xdis+ydis+zdis);
        return dis;
    }

}