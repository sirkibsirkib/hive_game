package hiveGame;

import java.util.ArrayList;
import java.util.List;

import simpleFrame.SimpleFrame;
import spriteLoader.SpriteSheet;

public class Space {
	private List<Piece> pieces;
	
	public Space(){
		
	}

	public boolean isWhite() {
		if(pieces == null) return false;
		return top().isWhite();
	}
	
	public boolean isBlack() {
		if(pieces == null) return false;
		return top().isBlack();
	}

	Piece top() {
		return pieces.get(pieces.size()-1);
	}

	public void drawAt(SimpleFrame sf, Coord hexCoord, SpriteSheet hexPieces) {
		if(pieces == null) return;
		top().drawAt(sf, hexCoord, hexPieces);
	}

	public void addPiece(Piece p) {
		if(pieces == null)pieces = new ArrayList<>();
		pieces.add(p);
	}

	public boolean drawsRelativePixel(Coord c, SpriteSheet hexPieces) {
		if(pieces == null) return false;
		return hexPieces.getSprite(0, 0).drawsPixelAtWhenDrawnAt(c.getX(), c.getY());
	}

}
