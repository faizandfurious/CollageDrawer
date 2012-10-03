package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

public class OvalClip extends ArtistBase {

	RectF oval;
	Path path;
	Canvas onCanvas;
	public OvalClip(float x, float y, float w, float h) {
		this.setPosition(x, y);
		this.setSize(w, h);
		oval = new RectF();
		oval.set(0, 0, w, h);
		path = new Path();
		path.addOval(oval, Path.Direction.CW);
		
	}
	
	@Override
	public void draw(Canvas onCanvas) {
		
		//Checks to see if the current Artist has children. If so, iterate through the children and set their position.
		if(children.size() > 0){
			//Draw children
			for(Artist child : children){
				onCanvas.save();			
					onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
					onCanvas.clipPath(path);	
					child.draw(onCanvas);	
				onCanvas.restore();	
			}
		}
	}
	

}