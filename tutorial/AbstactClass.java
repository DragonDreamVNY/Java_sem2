//Abstract class notes
public class Shape{
  //abstract attributes and constructors here
  //

}

public class Rectangle extends Shape{
  int width;
  int height;
}

public int getArea(){
    return width*height;
}


class Circle extends Shape{
  int radius;
  //these methods are virtual, can speify method as final to prevent subclasses from overriding
  public int radArea(){
    return 3.14*radius*radius;
  }
}
