package ssui.fabbasi.collagedrawer;

import android.graphics.Point;

/**
 * This class extends the ArtistBase class to create a Circle layout on the Collage. It places each child such that their
 * center lie positioned at equal angles around a circular perimeter of a provided size. This layout ignores any overlap of
 * child objects.
 * @author Faiz
 *
 */
public class Circle extends ArtistBase {

	//Declare Variables
	//This point will hold the information regarding the central Point of the circle.
	Point center;
	//This float will contain the offset necessary to ensure each child of the layout will be properly displayed
	//in a circular fashion.
	float offset;
	float radius;
	/**
	 * This constructor takes in the necessary parameters to initialize a circle layout.
	 * @param x This is the x position of the new circle object
	 * @param y This is the y position of the new circle object
	 * @param w This is the width of the new circle object
	 * @param h This is the height of the new circle object
	 * @param layoutCenterX This is the x coordinate of the center of the new circle object
	 * @param layoutCenterY This is the y coordinate of the center of the new circle object
	 * @param layoutRadius This is the radius of the new circle object
	 */
	public Circle(float x, float y, float w, float h, float layoutCenterX, float layoutCenterY, float layoutRadius) {
		this.setPosition(x, y);
		this.setSize(w, h);
		center = new Point();
		center.set((int)layoutCenterX, (int)layoutCenterY);
		radius = layoutRadius;
	}
	
	/**
	 * Performs a top-down layout traversal of the Artist's children. It calculates the necessary offset between each
	 * object in the child tree, and calculates the position of each child. It then calls the child's doLayout() function.
	 */
	@Override
	public void doLayout(){
		//Ensure that the child list has objects.
		if(children.size() > 0){
			
			//Get the radian value (in float) of the distance between each child
			offset = (float) (Math.toRadians(360/children.size()));
			//Begin the current offset at 0.
			float curr_offset = 0;
			
			//Iterate through the children list. For each child, calculate the position, then change the value of the curr_offset
			//variable to reflect the next child's position.
			for(Artist child : children){
				float x = (float) (center.x + radius*(Math.cos(curr_offset)));
				float y = (float) (center.y + radius*(Math.sin(curr_offset)));
				child.setPosition(x + child.getW()/2, y + child.getY()/2);
				curr_offset = curr_offset + offset;
				child.doLayout();
			}
		}
	}

}
