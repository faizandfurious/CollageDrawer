package ssui.fabbasi.collagedrawer;


/**
 * This class extends the ArtistBase class to create a Column layout on the Collage. It places each child such that they
 * lie in the same vertical column, and places them horizontally centered. Children that do not fit within the bounds are
 *clipped at the bottom edge.
 * @author Faiz
 *
 */
public class Column extends ArtistBase {

	/**
	 * This method initializes the values of the column Artist object.
	 * @param x This is the x position of the new column object
	 * @param y This is the y position of the new column object
	 * @param w This is the width of the new column object
	 * @param h This is the height of the new column object
	 */
	public Column(float x, float y, float w, float h) {
		//Set the position with the corresponding x, y values
		this.setPosition(x, y);
		//Set the size with the corresponding w, h values.
		this.setSize(w, h);
	}
	
	/**
	 * Performs a top-down layout traversal of the Artist's children. It calculates the appropriate center for each child in order
	 * to horizontally center the child, and calculates the necessary offset to properly place each child one after the other.
	 * It then calls that child's doLayout() method.
	 */
	@Override
	public void doLayout(){

		//Set the parent_center to be this column artist's width. This value will be used to calculate the necessary center.
		float parent_center = this.getW();
		//Set the horizontally-centered center value initially to zero.
		float this_center = 0;

		//Set the current height value initially to zero.
		float currH = 0;
		
		//Iterate through the children list
		for(Artist child : children){

			//Get the horizontal center by dividing this Artist's width by 2.
			this_center = (parent_center - child.getW())/2;

			//Place the child at the next available cell in the column.
			child.setPosition(this_center, currH);
			//Add the child's height to the currH variable.
			currH = currH + child.getH();
			child.doLayout();
		}
	}
}
