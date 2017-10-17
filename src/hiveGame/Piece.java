package hiveGame;

import simpleFrame.SimpleFrame;
import spriteLoader.Sprite;
import spriteLoader.SpriteSheet;

public class Piece {
	private boolean white;
	private PieceType type;
	
	public Piece(boolean white, PieceType type){
		this.white = white;
		this.type = type;
	}

	public boolean isWhite() {
		return white;
	}
	
	public boolean isBlack() {
		return !white;
	}
	
	public PieceType getType(){
		return type;
	}
	
	@Override
	public String toString(){
		return (white?"white:" : "black:")+type.name();
	}

	public void drawAt(SimpleFrame sf, Coord hexCoord, SpriteSheet hexPieces) {
		Coord spriteTile = type.getSpriteTile();
		Sprite hex = hexPieces.getSprite(white?0:1, 0);
		Sprite bug = hexPieces.getSprite(spriteTile.getX(), spriteTile.getY());

		hex.paintSelfAt(sf, hexCoord.getX(), hexCoord.getY());
		bug.paintSelfAt(sf, hexCoord.getX(), hexCoord.getY());
	}
}
