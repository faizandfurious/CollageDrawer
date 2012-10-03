package ssui.fabbasi.collagedrawer;

public class Pile extends ArtistBase {
	
	public Pile(float x, float y, float w, float h) {
		this.setPosition(x, y);
		this.setSize(w, h);
	}
	
	@Override
	public void doLayout(){

		for(Artist child : children){
			//Place the child in the top left corner of this Artist
			child.setPosition(0, 0);
			child.doLayout();
		}
	}

}