package it.unipi.hadoop.models;

import java.util.LinkedList;

public class DataPoint{

    protected LinkedList<Float> coordinates;

    public LinkedList<Float> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LinkedList<Float> coordinates) {
        this.coordinates = coordinates;
    }

    public double squaredNorm2Distance(DataPoint p){
        double sum = 0.0;
        for (int i = 0; i < p.getCoordinates().size(); i++) {
            float difference = this.coordinates.get(i) - p.getCoordinates().get(i);
            sum += difference * difference;
        }
        return sum; //not returning the square root since we are looking for the squared norm2
    }

    public static DataPoint parseString(String s, Boolean centroid){

        DataPoint d;
        if(centroid){
                d=new Centroid();
        }
        else{
                d = new DataPoint();
        }

        d.coordinates=new LinkedList<>();
        for (String s2 : s.split(",")){
            System.out.println("split:"+s2);
            d.coordinates.add(Float.parseFloat(s2));
        }
        return d;
    }
}
