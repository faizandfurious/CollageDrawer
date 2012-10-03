package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class SolidBackDrop extends ArtistBase {
	
	Rect location;
	Paint paint = new Paint();
	
	public SolidBackDrop() {
		// TODO Auto-generated constructor stub
	}

	public SolidBackDrop(float x, float y, float w, float h, int color) {
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		location.set(0, 0,(int) w,(int) h);
		paint.setColor(color);
	}
	
	@Override
	public void draw(Canvas onCanvas){
		//Have the canvas draw a rect object based on it's own coordinates. 
		onCanvas.drawRect(location, paint);

		System.out.println("The w position is: " + this.getW() + " and the h position is: " + this.getH());
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
