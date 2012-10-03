package ssui.fabbasi.collagedrawer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class Icon extends ArtistBase {
	Bitmap icon;
	Paint paint;
	RectF dst;
	
	public Icon(float x, float y, Bitmap image) {
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
	
	@Override
	public void draw(Canvas onCanvas){
		
		//Have the canvas draw a bitmap based on it's own coordinates. 
		onCanvas.drawBitmap(icon, null, dst, paint);

		if(children.size() != 0){
			for(Artist child : children){
				child.draw(onCanvas);
			}
		}
	}

}