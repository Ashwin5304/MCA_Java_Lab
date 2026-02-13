package shapes;

public class Square {
    double Side;

    public Square(double side){
        this.Side = side;
    }

    public double getArea(){
        return Side*Side;
    }  
}

