package ssui.fabbasi.collagedrawer;

import android.graphics.Canvas;
import android.graphics.PointF;

public class ArtistBase implements Artist {

	@Override
	public void setPosition(PointF pos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public PointF getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean sizeIsIntrinsic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSize(PointF size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSize(float w, float h) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setW(float w) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setH(float h) {
		// TODO Auto-generated method stub

	}

	@Override
	public PointF getSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float getW() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Artist getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(Artist newParent) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNumChildren() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Artist getChildAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findChild(Artist child) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addChild(Artist child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChildAt(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChild(Artist child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveChildFirst(Artist child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveChildLast(Artist child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveChildEarlier(Artist child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveChildLater(Artist child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doLayout() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Canvas onCanvas) {
		// TODO Auto-generated method stub

	}

}
