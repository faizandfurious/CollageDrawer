package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;

public class SimpleFrame extends ArtistBase {
	
	Rect location;
	Paint paint = new Paint();

	public SimpleFrame(float x, float y, float w, float h) {
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		location.set(0, 0,(int) w - 1,(int) h - 1);
	}
	
	public SimpleFrame() {
		//Object's top-left position and width/height default to zero.
	}
	
	@Override
	public void draw(Canvas onCanvas){
		paint.setStyle(Style.STROKE);
		//Set the paint color to black
		paint.setColor(Color.BLACK);
		//Set the stroke width to zero to activate hairline mode (1px wide)
		paint.setStrokeWidth(0);
		//Have the canvas draw a rect object based on it's own coordinates.
		onCanvas.drawRect(location, paint);
		
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
