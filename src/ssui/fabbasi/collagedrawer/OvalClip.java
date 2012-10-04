package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
/**
 * This class extends the ArtistBase class to create an OvalClip clipping that is to be applied to it's children
 * on the Collage.
 * @author Faiz
 *
 */
public class OvalClip extends ArtistBase {

	//Variables
	RectF oval;
	Path path;
	Canvas onCanvas;
	/**
	 * This constructor takes in the necessary parameters to initialize an OvalClip clipping path.
	 * @param x This is the x position of the new OvalClip clipping path
	 * @param y This is the y position of the new OvalClip clipping path
	 * @param w This is the width of the new OvalClip clipping path
	 * @param h This is the height of the new OvalClip clipping path
	 */
	public OvalClip(float x, float y, float w, float h) {
		//Set the position and size of the OvalClip clipping path
		this.setPosition(x, y);
		this.setSize(w, h);
		//Create a new RectF object, which is used to create an oval clipping path.
		oval = new RectF();
		oval.set(0, 0, w, h);
		path = new Path();
		path.addOval(oval, Path.Direction.CW);
		
	}
	/**
	 * Override the draw method to add the OvalClip clipping path to the children, replacing the original
	 * rectangular clipping path.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	@Override
	public void draw(Canvas onCanvas) {
		
		//Checks to see if the current Artist has children. If so, iterate through the children and set their position.
		if(children.size() > 0){
			//Draw children
			for(Artist child : children){
				onCanvas.save();			
					onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
					//Apply the new oval clipping path
					onCanvas.clipPath(path);	
					child.draw(onCanvas);	
				onCanvas.restore();	
			}
		}
	}
	

}