package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;

/**
 * This class extends the ArtistBase class to draw a NinePartImage on the Collage. It takes a NinePatch image, and places it with
 * it's corresponding x,y coordinates.
 * @author Faiz
 *
 */
public class NinePartImage extends ArtistBase {

	//Variables
	Rect location;
	NinePatch npd;
	/**
	 * This constructor takes in the necessary parameters to initialize a NinePartImage image.
	 * @param x This is the x position of the new NinePartImage object
	 * @param y This is the y position of the new NinePartImage object
	 * @param w This is the width of the new NinePartImage object
	 * @param h This is the height of the new NinePartImage object
	 * @param patches This is the NinePatch of the NinePartImage to be displayed
	 */	
	public NinePartImage(float x, float y, float w, float h, NinePatch patches) {
		//Create a Rect that creates a bounding area for the NinePatch image.
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		location.set(0, 0,(int) w,(int) h);
		npd = patches;
	}
	/**
	 * Draw this artist and all child artists on the given <code>Canvas</code> 
	 * object. It will draw a NinePatchImage Artist object with the proper Rect.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	@Override
	public void draw(Canvas onCanvas){
		npd.draw(onCanvas, location);
		
		//Ensure that the children list is not empty
		if(children.size() != 0){
			//Draw children
			for(Artist child : children){
				onCanvas.save();			
				onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
				onCanvas.clipRect(0,0, child.getW(), child.getY());	
				child.draw(onCanvas);	
				onCanvas.restore();	
			}
		}
	}

}
