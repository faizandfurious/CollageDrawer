package ssui.fabbasi.collagedrawer;

/**
 * This class extends the ArtistBase class to create a Pile layout on the Collage. It places each child such that they
 * lie on top of each other.
 * @author Faiz
 *
 */
public class Pile extends ArtistBase {
	/**
	 * This method initializes the values of the pile Artist object.
	 * @param x This is the x position of the new pile object
	 * @param y This is the y position of the new pile object
	 * @param w This is the width of the new pile object
	 * @param h This is the height of the new pile object
	 */
	public Pile(float x, float y, float w, float h) {
		//Set the positon and size of the pile.
		this.setPosition(x, y);
		this.setSize(w, h);
	}
	
	/**
	 * Performs a top-down layout traversal of the Artist's children. It sets each of it's children's position to 0,0, in order
	 * to place each child on top of one another. It then calls that child's doLayout() method.
	 */
	@Override
	public void doLayout(){

		for(Artist child : children){
			//Place the child in the top left corner of this Artist
			child.setPosition(0, 0);
			child.doLayout();
		}
	}

}