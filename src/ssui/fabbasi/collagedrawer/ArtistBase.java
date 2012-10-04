package ssui.fabbasi.collagedrawer;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.PointF;

/**
 * This class is the implementation of the Artist interface. It is the parent class of all visual element objects that can be
 * place in the collage. 
 * 
 * Each <code>Artist</code> maintains a notion of it's position (relative to 
 * it's containing or parent <code>Artist</code>) as well as it's size.  It's
 * size may be determined <i>intrinsically</i> (that is inside the object based
 * on what it draws) or may be set from the outside.  Every <code>Artist</code> 
 * object is responsible for maintaining a possible list of <i>child</i> objects
 * which are contained inside it. Finally, each <code>Artist</code> object is 
 * also responsible for drawing its own appearance, and for arranging for the 
 * layout and drawing of a set of child objects that appear within it.  
 * 
 * @author Faiz
 *
 */
public class ArtistBase implements Artist {

	//Variables (Default-valued)
	//The top-left x-position of the Artist object. Initialize to zero.
	private float xpos = 0;
	//The top-left y-position of the Artist object. Initialize to zero.
	private float ypos = 0;
	//Width of the Artist object. Initialize to zero.
	private float width = 0;
	//Height of the Artist object. Initialize to zero.
	private float height = 0;
	//Boolean to store if the size is to be intrinsic. Start as false.
	boolean intrinsic = false;
	//Reference to the Artist object's parent object. Initialize to null.
	Artist parent = null;
	//A list that contains each of the Artist object's children. Initialize to an empty list.
	List<Artist> children = new ArrayList<Artist>();
	

	@Override
	public void setPosition(PointF pos) {
		//Check to ensure that the PointF object is not null.
		if(pos != null){
			xpos = pos.x;
			ypos = pos.y;
		}

	}
	
	//There will be no checks on the coordinates provided, as no numerical x,y coordinates will break the system.
	@Override
	public void setPosition(float x, float y) {
		xpos = x;
		ypos = y;

	}

	//There will be no checks on the coordinate provided, as no numerical x coordinate will break the system.
	@Override
	public void setX(float x) {
		xpos = x;

	}

	//There will be no checks on the coordinate provided, as no numerical y coordinates will break the system.
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
		//First check if size is null
		if(size != null){
			//If the Artist object is not intrinsic, then carry through with the resize.
			if(!intrinsic){
				//Ensure that the values being passed in are non-negative.
				if(size.x >= 0){
					width = size.x;
				}
				if(size.y >= 0){
					height = size.y;
				}
			}
		}

	}

	@Override
	public void setSize(float w, float h) {
		//If the Artist object is not intrinsic, then carry through with the resize.
		if(!intrinsic){
			//Ensure that the values being passed in are non-negative.
			if(w >= 0){
				width = w;
			}
			if(h >= 0){
				height = h;
			}
		}
	}

	@Override
	public void setW(float w) {
		//If the Artist object is not intrinsic, then carry through with the resize.
		if(!intrinsic){
			//Ensure that the value being passed in is non-negative.
			if(w >= 0){
				width = w;
			}
		}
	}

	@Override
	public void setH(float h) {
		//If the Artist object is not intrinsic, then carry through with the resize.
		if(!intrinsic){
			//Ensure that the value being passed in is non-negative.
			if(h >= 0){
				height = h;
			}
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
		//First check to ensure the newParent provided is not null.
		if(newParent != null){
			//If the current Artist's parent is null, we just set the reference to point to the newParent object.
			if(parent == null){
				parent = newParent;
			}
			//Otherwise, if the current parent is not the newParent object, we must first remove this object from the current
			//parents children list, change the reference to point to the newParent, and then add this Artist object to the
			//newParent's child list.
			else if(!parent.equals(newParent)){
				parent.removeChild(this);
				parent = newParent;
				parent.addChild(this);
			}
		}

	}

	@Override
	public int getNumChildren() {
		return children.size();
	}

	@Override
	public Artist getChildAt(int index) {
		//Check to ensure the index is within bounds.
		if(index < 0 || index > children.size()){
			return null;
		}
		//Check to ensure the child at the index provided is not null.
		else if(children.get(index) != null){
			return children.get(index);
		}
		//Otherwise we did not find the child, so we return null.
		return null;
	}

	@Override
	public int findChild(Artist child) {
		//Perform a lookup for the index of the child provided. Returns -1 if not present.
		return children.indexOf(child);
	}

	@Override
	public void addChild(Artist child) {
		//Only follow through with operations if the child is not null
		if(child != null){
			//Check if child currently exists. If it does, remove it from the list, and add it to the end.
			if(children.contains(child)){
				children.remove(child);
			}
			//Check if the child has a parent. If so, retrieve the parent, and remove the child from the
			//list of children of that parent
			else if(child.getParent() != null){
				Artist parent = child.getParent();
				parent.removeChild(child);
			}
			//Now add the child to the end of the children list, and set the child's parent to the current Artist object.
			children.add(child);
			child.setParent(this);
		}
	}

	@Override
	public void removeChildAt(int index) {
		//Check to ensure the index is within bounds.
		if(index < 0 || index > children.size()){
			//Do nothing
		}
		
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
			//Ensure that the child is contained within the children list.
			if(children.contains(child)){
				child.setParent(null);
				children.remove(child);
			}
		}

	}

	@Override
	public void moveChildFirst(Artist child) {
		//Check to ensure child is not null.
		if(child != null){
			//Ensure that the child is within the children list. If so, remove the child from the list, then add it at the beginning.
			if(children.contains(child)){
				children.remove(child);
				children.add(0, child);
			}
		}

	}

	@Override
	public void moveChildLast(Artist child) {
		//Check to ensure child is not null.
		if(child != null){
			//Ensure that the child is within the children list. If so, remove the child from the list, then add it to the end.
			if(children.contains(child)){
				children.remove(child);
				children.add(child);
			}
		}

	}

	@Override
	public void moveChildEarlier(Artist child) {
		//Check to ensure child is not null.
		if(child != null){
			//Ensure that the child is within the children list. If so, retrieve the index at which the child is currently stored,
			//remove it from the children's list, then add it to the position one before it's previous index. Only do so if it wasn't
			//already at the start of the list.
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
		//Check to ensure child is not null.
		if(child != null){
			//Ensure that the child is within the children list. If so, retrieve the index at which the child is currently stored,
			//remove it from the children's list, then add it to the position one after it's previous index. Only do so if it wasn't
			//already at the end of the list.
			if(children.contains(child)){
				int index = children.indexOf(child);
				if(index < children.size() - 1){
					children.remove(child);
					children.add(index + 1, child);
				}
			}
		}

	}

	@Override
	public void doLayout() {
		//Checks to see if the current Artist has children. If so, iterate through the children and call the child's doLayout() method.
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
				//Save the current state of the canvas to the top of the state stack.
				onCanvas.save();	
					//Add translation to enter into the child's coordinates
					onCanvas.translate(child.getX(), child.getY());			//	now	in	child’s	coords!	
					//Set the clipping rectangle to match the size of the Artist
					onCanvas.clipRect(0, 0, child.getW(), child.getH());	
					//Call the child's draw() method.
					child.draw(onCanvas);	
				//Pop the current state of the canvas off the state stack.
				onCanvas.restore();	
			}
		}
	}

}
