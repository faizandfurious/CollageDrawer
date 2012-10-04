package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

/**
 * This class extends the ArtistBase class to create a TextArtist on the Collage.
 * @author Faiz
 *
 */
public class TextArtist extends ArtistBase {

	//Variables
	Paint paint = new Paint();
	String display;
	
	/**
	 * This method initializes the values of the TextArtist Artist object.
	 * @param x This is the x position of the new TextArtist object
	 * @param y This is the y position of the new TextArtist object
	 * @param text This is the text to be used for the new TextArtist object
	 * @param face This is the typeface used for the text of the new TextArtist object
	 * @param textSize This is the size of the text of the new TextArtist object
	 * @param color This is the color of the new TextArtist object
	 */
	public TextArtist(float x, float y, String text, Typeface face, float textSize, int color) {
		//Set the position of the object
		this.setPosition(x, y);

		//Set the paint attributes, including the TypeFace, the textSize, and the color of the text.
		paint.setTypeface(face);
		paint.setTextSize(textSize);
		paint.setColor(color);
		
		//Create the necessary bounds of the TextArtist, then set the size to be intrinsic.
		Rect bounds = new Rect();
		paint.getTextBounds(text,0,text.length(),bounds);
		int height = bounds.height();
		int width = bounds.width();
		this.setSize(width, height);
		this.intrinsic = true;
		
		//Set the text.
		display = text;
	}
	/**
	 * Draw this artist and all child artists on the given <code>Canvas</code> 
	 * object. It will draw a TextArtist Artist object with the proper fontType, textSize, and color.
	 * @param onCanvas the <code>Canvas</code> object that drawing is done on.
	 */
	@Override
	public void draw(Canvas onCanvas){
		//Have the canvas draw a bitmap based on it's own coordinates. 
		onCanvas.drawText(display, 0, this.getH(), paint);

		//Checks to see if the current Artist has children. If so, iterate through the children and set their position.
		if(children.size() > 0){
			for(Artist child : children){
				onCanvas.save();			
				onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
				onCanvas.clipRect(0, 0, child.getW(), child.getH());	
				child.draw(onCanvas);	
				onCanvas.restore();	
			}
		}
	}

}
