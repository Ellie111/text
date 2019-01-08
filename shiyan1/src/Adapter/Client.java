package Adapter;

public class Client {
 public static void main(String arg[]){
	 Draw draw= new Angleadapter();
	 Draw line= new Line();
	 Draw rectangle= new Rectangle();
	 Draw square= new Square();
	 line.draw();
	 rectangle.draw();
	 square.draw();
	 draw.draw();
 }
}
