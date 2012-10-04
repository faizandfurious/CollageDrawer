package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * This class extends the ArtistBase class to create a rotation layout on the Collage. It places each child such that they
 * lie in the same rotated view.
 * @author Faiz
 *
 */
public class Rotate extends ArtistBase {
	
	//Variables
	Rect location;
	Paint paint = new Paint();
	float angle;
	/**
	 * This method initializes the values of the Rotate Artist object.
	 * @param x This is the x position of the new Rotate object
	 * @param y This is the y position of the new Rotate object
	 * @param w This is the width of the new Rotate object
	 * @param h This is the height of the new Rotate object
	 * @param color This is the color of the new Rotate object
	 * @param angle This is the color of the new Rotate object
	 */
	public Rotate(float x, float y, float w, float h, int color, float angle) {
		//Create a new Rect to store the location of the SolidBackDrop object
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		this.angle = angle;
		location.set(0, 0,(int) w,(int) h);
		//Set the paint color
		paint.setColor(color);
	}
	
	/**
	 * Draw this artist and all child artists on the given <code>Canvas</code> 
	 * object. It will draw a Rotate Artist object with the proper color, size, and angle
	 * rotation.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	@Override
	public void draw(Canvas onCanvas){
		//Have the canvas draw a rect object based on it's own coordinates. 
		onCanvas.drawRect(location, paint);

		//Checks to see if the current Artist has children. If so, iterate through the children and set their position.
		if(children.size() > 0){		
			//Draw children
			for(Artist child : children){
				location.set((int)child.getX(), (int)child.getY(), (int)child.getW(), (int)child.getH());
				onCanvas.save();			
				//Rotate the canvas
				onCanvas.rotate(angle, this.getX() + location.exactCenterX(), this.getY() + location.exactCenterY());
				onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
				onCanvas.clipRect(0,0, child.getW(), child.getH());	
				child.draw(onCanvas);	
				onCanvas.restore();	
			}
		}
	}

}
