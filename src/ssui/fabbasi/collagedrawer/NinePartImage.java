package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;

public class NinePartImage extends ArtistBase {

	Rect location;
	NinePatch npd;
	
	public NinePartImage(float x, float y, float w, float h, NinePatch patches) {
		location = new Rect();
		this.setPosition(x, y);
		this.setSize(w, h);
		location.set(0, 0,(int) w,(int) h);
		npd = patches;
	}
	
	@Override
	public void draw(Canvas onCanvas){
		npd.draw(onCanvas, location);
		
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
