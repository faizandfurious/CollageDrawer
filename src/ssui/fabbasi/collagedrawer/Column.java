package ssui.fabbasi.collagedrawer;

public class Column extends ArtistBase {

	public Column(float x, float y, float w, float h) {
		this.setPosition(x, y);
		this.setSize(w, h);
	}
	
	@Override
	public void doLayout(){
		//If the parent of this 
		if(this.parent != null){
			//Keep track of the spacing between Artist objects via currH
			
			float center = this.getW();
			float this_center = 0;

			float currH = 0;
			for(Artist child : children){
				
				//Get the vertical center by dividing this Artist's width by 2.
				this_center = (center - child.getW())/2;
				
				//Place the child at the next available cell in the row.
				child.setPosition(this_center, currH);
				//Add the child's width to the currW variable.
				currH = currH + child.getH();
				child.doLayout();
			}
		}
	}
}
