package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;

public class TextArtist extends ArtistBase {

	Paint paint = new Paint();
	String display;
	
	public TextArtist(float x, float y, String text, Typeface face, float textSize, int color) {
		System.out.println("The x position for this textartist is: " + x);
		System.out.println("And the y position is: " + y);
		this.setPosition(x, y);
		System.out.println("The actual-x position for this textartist is: " + this.getX());
		System.out.println("And the actual-y position is: " + this.getY());
		paint.setTypeface(face);
		paint.setTextSize(textSize);
		paint.setColor(color);
		
		Rect bounds = new Rect();

		paint.getTextBounds(text,0,text.length(),bounds);
		
		int height = bounds.height();
		int width = bounds.width();
		
		this.setSize(width, height);
		this.intrinsic = true;
		display = text;
	}
	
	@Override
	public void draw(Canvas onCanvas){
		//Have the canvas draw a bitmap based on it's own coordinates. 
		onCanvas.drawText(display, 0, this.getH(), paint);
		System.out.println("The drawn-x position for this textartist is: " + this.getX());
		System.out.println("And the drawn-y position is: " + this.getY());
		System.out.println("It's parent is: " + this.getParent().toString());

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
