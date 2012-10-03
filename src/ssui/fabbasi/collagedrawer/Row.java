package ssui.fabbasi.collagedrawer;

public class Row extends ArtistBase {

	public Row(float x, float y, float w, float h) {
		this.setPosition(x, y);
		this.setSize(w, h);
	}
	
	@Override
	public void doLayout(){
		//Keep track of the spacing between Artist objects via currW
		float currW = 0;
		
		//Get the vertical center by dividing this Artist's height by 2.
		float center = this.getH();
		float this_center = 0;

		
		for(Artist child : children){

			this_center = (center - child.getH())/2;

			//Place the child at the next available cell in the row.
			child.setPosition(currW, this_center);
			System.out.println(this_center);
			//Add the child's width to the currW variable.
			currW = currW + child.getW();
			child.doLayout();
		}
	}
	
	
	
	

}