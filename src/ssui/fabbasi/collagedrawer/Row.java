package ssui.fabbasi.collagedrawer;

/**
 * This class extends the ArtistBase class to create a row layout on the Collage. It places each child such that they
 * lie in the same horizontal row, and places them vertically centered. Children that do not fit within the bounds are
 *clipped at the right edge.
 * @author Faiz
 *
 */
public class Row extends ArtistBase {

	/**
	 * This method initializes the values of the row Artist object.
	 * @param x This is the x position of the new row object
	 * @param y This is the y position of the new row object
	 * @param w This is the width of the new row object
	 * @param h This is the height of the new row object
	 */
	public Row(float x, float y, float w, float h) {
		//Set the position and size of the row object
		this.setPosition(x, y);
		this.setSize(w, h);
	}
	
	/**
	 * Performs a top-down layout traversal of the Artist's children. It calculates the appropriate center for each child in order
	 * to vertically center the child, and calculates the necessary offset to properly place each child one after the other.
	 * It then calls that child's doLayout() method.
	 */
	@Override
	public void doLayout(){
		//Keep track of the spacing between Artist objects via currW
		float currW = 0;
		
		//Get the vertical center by dividing this Artist's height by 2.
		float center = this.getH();
		float this_center = 0;

		//Ensure that the child list has objects.
		if(children.size() > 0){
			//Iterate through the children list.
			for(Artist child : children){

				//Get the vertical center by dividing this Artist's width by 2.
				this_center = (center - child.getH())/2;
	
				//Place the child at the next available cell in the row.
				child.setPosition(currW, this_center);
				//Add the child's width to the currW variable.
				currW = currW + child.getW();
				child.doLayout();
			}
		}
	}
	
	
	
	

}