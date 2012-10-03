package ssui.fabbasi.collagedrawer;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.PointF;

public class ArtistBase implements Artist {

	//Variables
	//The top-left x-position of the Artist object
	private float xpos = 0;
	//The top-left y-position of the Artist object
	private float ypos = 0;
	//Width of the Artist object
	private float width = 0;
	//Height of the Artist object
	private float height = 0;
	//
	boolean intrinsic = false;
	//Reference to the Artist object's parent object
	Artist parent = null;
	//A list that contains each of the Artist object's children
	List<Artist> children = new ArrayList<Artist>();
	
	@Override
	public void setPosition(PointF pos) {
		if(pos != null){
			xpos = pos.x;
			ypos = pos.y;
		}

	}

	@Override
	public void setPosition(float x, float y) {
		xpos = x;
		ypos = y;

	}

	@Override
	public void setX(float x) {
		xpos = x;

	}

	@Override
	public void setY(float y) {
		ypos = y;

	}

	@Override
	public PointF getPosition() {
		PointF pos = new PointF(xpos, ypos);
		return pos;
	}

	@Override
	public float getX() {
		
		return xpos;
	}

	@Override
	public float getY() {
		
		return ypos;
	}

	@Override
	public boolean sizeIsIntrinsic() {

		return intrinsic;
	}

	@Override
	public void setSize(PointF size) {
		if(size != null){
			if(!intrinsic){
				width = size.x;
				height = size.y;
			}
		}

	}

	@Override
	public void setSize(float w, float h) {
		if(!intrinsic){
			width = w;
			height = h;
		}
	}

	@Override
	public void setW(float w) {
		if(!intrinsic){
			width = w;
		}
	}

	@Override
	public void setH(float h) {
		if(!intrinsic){
			height = h;
		}
	}

	@Override
	public PointF getSize() {
		PointF size = new PointF(width, height);
		return size;
	}

	@Override
	public float getW() {
		return width;
	}

	@Override
	public float getH() {
		return height;
	}

	@Override
	public Artist getParent() {
		
		return parent;
	}

	@Override
	public void setParent(Artist newParent) {

		if(newParent != null){
			if(parent == null){
				parent = newParent;
			}
			
			else if(!parent.equals(newParent)){
				parent.removeChild(this);
				parent = newParent;
			}
		}

	}

	@Override
	public int getNumChildren() {
		return children.size();
	}

	@Override
	public Artist getChildAt(int index) {
		if(index < 0 || index > children.size()){
			return null;
		}
		else if(children.get(index) != null){
			return children.get(index);
		}
		return null;
	}

	@Override
	public int findChild(Artist child) {
		
		return children.indexOf(child);
	}

	@Override
	public void addChild(Artist child) {
		//Only follow through with operations if the child is not null
		if(child != null){
			//Check if child currently exists. If it does, remove it from the list, and add it to the end.
			if(children.contains(child)){
				children.remove(child);
				children.add(child);
				child.setParent(this);
			}
			//Check if the child has a parent. If so, retrieve the parent, and remove the child from the
			//list of children of that parent
			
			else if(child.getParent() != null){
				Artist parent = child.getParent();
				parent.removeChild(child);
			}
			else{
				child.setParent(this);
				children.add(child);
			}
		}
	}

	@Override
	public void removeChildAt(int index) {
		//Check if the given index exists and actually has data. If so, it will retrieve the child at the given
		//position, remove it from the list of children, and replace that child's parent with a null value.
		if(children.get(index) != null){
			Artist child = children.get(index);
			children.remove(index);
			child.setParent(null);
		}

	}

	@Override
	public void removeChild(Artist child) {
		//Check if the given child exists and actually has data. If so, it will be removed from the list of children, 
		//and replace that child's parent with a null value.
		if(child != null){
			if(children.contains(child)){
				child.setParent(null);
				children.remove(child);
			}
		}

	}

	@Override
	public void moveChildFirst(Artist child) {
		if(child != null){
			if(children.contains(child)){
				children.remove(child);
				children.add(0, child);
			}
		}

	}

	@Override
	public void moveChildLast(Artist child) {
		if(child != null){
			if(children.contains(child)){
				children.remove(child);
				children.add(child);
			}
		}

	}

	@Override
	public void moveChildEarlier(Artist child) {
		if(child != null){
			if(children.contains(child)){
				int index = children.indexOf(child);
				if(index > 0){
					children.remove(child);
					children.add(index - 1, child);
				}
			}
		}

	}

	@Override
	public void moveChildLater(Artist child) {
		if(child != null){
			if(children.contains(child)){
				int index = children.indexOf(child);
				if(index < children.size()){
					children.remove(child);
					children.add(index + 1, child);
				}
			}
		}

	}

	@Override
	public void doLayout() {
		//Checks to see if the current Artist has children. If so, iterate through the children and set their position.
		if(children.size() > 0){
			for(Artist child : children){
				child.doLayout();
			}
		}
	}

	@Override
	public void draw(Canvas onCanvas) {
		
		//Checks to see if the current Artist has children. If so, iterate through the children and set their position.
		if(children.size() > 0){
			//Draw children
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
