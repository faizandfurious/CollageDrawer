package ssui.fabbasi.collagedrawer;

import android.graphics.Point;

public class Circle extends ArtistBase {

	Point center;
	float offset;
	float radius;
	public Circle(float x, float y, float w, float h, float layoutCenterX, float layoutCenterY, float layoutRadius) {
		this.setPosition(x, y);
		this.setSize(w, h);
		center = new Point();
		center.set((int)layoutCenterX, (int)layoutCenterY);
		radius = layoutRadius;
	}
	
	@Override
	public void doLayout(){
		if(children.size() > 0){
			
			offset = (float) (Math.toRadians(360/children.size()));
			System.out.println("Size is: " + children.size() + " offset is: " + offset);
			float curr_offset = 0;
			
			for(Artist child : children){
				float x = (float) (center.x + radius*(Math.cos(curr_offset)));
				float y = (float) (center.y + radius*(Math.sin(curr_offset)));
				child.setPosition(x, y);
				curr_offset = curr_offset + offset;
				System.out.println("Current offset is:" + curr_offset);
				child.doLayout();
			}
		}
	}

}
