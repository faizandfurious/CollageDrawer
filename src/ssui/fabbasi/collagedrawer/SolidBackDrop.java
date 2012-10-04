package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * This class extends the ArtistBase class to create a SolidBackDrop on the Collage.
 * @author Faiz
 *
 */
public class SolidBackDrop extends ArtistBase {
	
	Rect location;
	Paint paint = new Paint();
	
	public SolidBackDrop() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * This method initializes the values of the SolidBackDrop Artist object.
	 * @param x This is the x position of the new SolidBackDrop object
	 * @param y This is the y position of the new SolidBackDrop object
	 * @param w This is the width of the new SolidBackDrop object
	 * @param h This is the height of the new SolidBackDrop object
	 * @param color This is the color of the new SolidBackDrop object
	 */
	public SolidBackDrop(float x, float y, float w, float h, int color) {
		//Create a new Rect to store the location of the SolidBackDrop object
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		location.set(0, 0,(int) w,(int) h);
		//Set the paint color
		paint.setColor(color);
	}
	
	/**
	 * Draw this artist and all child artists on the given <code>Canvas</code> 
	 * object. It will draw a SolidBackDrop Artist object with the proper color
	 * and size.
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
				onCanvas.save();			
				onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
				onCanvas.clipRect(0,0, child.getW(), child.getH());	
				child.draw(onCanvas);	
				onCanvas.restore();	
			}
		}
	}

}
