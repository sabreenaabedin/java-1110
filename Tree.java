import java.awt.Color;

public class Tree {

	public static void main(String[] args) {
	World myWorld = new World();
	Turtle A = new Turtle(myWorld);
	A.pickPenUp();
	A.goTo(0,-200);
	A.left(90);
	A.putPenDown();
	
	drawTree(A, 4);
	}
	
	public static void drawTree(Turtle A, int level){
		if(level==0){
			return;
		
		}
		if(level==1){
			A.setColor(Color.GREEN);
		} else {
			A.setColor(Color.BLACK);
		}
		A.forward(20);
		A.left(35);
		A.forward(20);
		drawTree(A, level-1);
		A.backward(20);
		A.right(70);
		drawTree(A, level-1);
		A.backward(20);
		A.left(35);
		A.forward(20);
		
	}
}
	
