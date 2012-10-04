package ssui.fabbasi.collagedrawer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * This class extends the ArtistBase class to draw a Icon on the Collage. It takes a Bitmap image, and places it with
 * it's corresponding x,y coordinates.
 * @author Faiz
 *
 */
public class Icon extends ArtistBase {
	
	//Variables
	Bitmap icon;
	Paint paint;
	RectF dst;
	/**
	 * This constructor takes in the necessary parameters to initialize an icon image.
	 * @param x This is the x position of the new icon object
	 * @param y This is the y position of the new icon object
	 * @param image This is the Bitmap of the image to be displayed
	 */
	public Icon(float x, float y, Bitmap image) {
		//Create a RectF to hold the rect that the image is to be translated into.
		dst = new RectF();
		dst.set(0, 0, image.getWidth(), image.getHeight());
		paint = new Paint();
		//Set the position of the image
		this.setPosition(x, y);
		this.setSize(image.getWidth(), image.getHeight());
		//Set the size of the image to be intrinsic
		this.intrinsic = true;
		icon = image;
	}
	/**
	 * Draw this artist and all child artists on the given <code>Canvas</code> 
	 * object. It will draw an Icon Artist object with an intrinsic size. It then calls that child's
	 * draw() method.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	@Override
	public void draw(Canvas onCanvas){
		
		//Have the canvas draw a bitmap based on it's own coordinates. 
		onCanvas.drawBitmap(icon, null, dst, paint);
		
		//Ensure that the children list is not empty
		if(children.size() != 0){
			//Iterate through the list of children to call their draw method.
			for(Artist child : children){
				child.draw(onCanvas);
			}
		}
	}

}