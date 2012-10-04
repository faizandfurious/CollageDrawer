package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;

/**
 * This class extends the ArtistBase class to create a SimpleFrame on the Collage.
 * @author Faiz
 *
 */
public class SimpleFrame extends ArtistBase {
	
	//Variables
	Rect location;
	Paint paint = new Paint();

	/**
	 * This method initializes the values of the SimpleFrame Artist object.
	 * @param x This is the x position of the new SimpleFrame object
	 * @param y This is the y position of the new SimpleFrame object
	 * @param w This is the width of the new SimpleFrame object
	 * @param h This is the height of the new SimpleFrame object
	 */
	public SimpleFrame(float x, float y, float w, float h) {
		//Initialize a new Rect object to store the Rect of the SimpleFrame
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		//Reduce the width and height by 1 pixel in order to display the bounding frame.
		location.set(0, 0,(int) w - 1,(int) h - 1);
	}
	
	public SimpleFrame() {
		//Object's top-left position and width/height default to zero.
	}
	
	/**
	 * Draw this artist and all child artists on the given <code>Canvas</code> 
	 * object. It will draw a SimpleFrame Artist object with the proper style, color,
	 * and stroke width.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	@Override
	public void draw(Canvas onCanvas){
		//Set the paint style to be a stroke
		paint.setStyle(Style.STROKE);
		//Set the paint color to black
		paint.setColor(Color.BLACK);
		//Set the stroke width to zero to activate hairline mode (1px wide)
		paint.setStrokeWidth(0);
		//Have the canvas draw a rect object based on it's own coordinates.
		onCanvas.drawRect(location, paint);
		
		//Ensure that the children list is not empty
		if(children.size() != 0){
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
