package hiveGame;

import java.util.HashMap;
import java.util.Map;

import simpleFrame.SimpleFrame;
import spriteLoader.SpriteSheet;

public class Board {
	private Space[][] spaces;
	private Map<Space, Coord> hexCoordinate;
	
	public Board(){
		spaces = new Space[6][6];
		hexCoordinate = new HashMap<>();
	}

	public boolean whiteAt(Coord c) {
		if(spaces[c.getX()][c.getY()] == null) return false;
		return spaces[c.getX()][c.getY()].isWhite();
	}
	
	public boolean blackAt(Coord c) {
		if(spaces[c.getX()][c.getY()] == null) return false;
		return spaces[c.getX()][c.getY()].isBlack();
	}

	public boolean legalMove(Coord from, Coord to) {
		if(spaces[from.getX()][from.getY()] == null) return false;
		return false;
	}
	
	public void placePiece(Coord gridCoord, Piece p){
		if(spaces[gridCoord.getX()][gridCoord.getY()] == null){
			spaces[gridCoord.getX()][gridCoord.getY()] = new Space();
			hexCoordinate.put(spaces[gridCoord.getX()][gridCoord.getY()], gridCoord.hexProject(50));
			
		}
		spaces[gridCoord.getX()][gridCoord.getY()].addPiece(p);
	}

	public void drawTo(SimpleFrame sf, SpriteSheet hexPieces) {
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(spaces[i][j] != null){
					spaces[i][j].drawAt(sf, hexCoordinate.get(spaces[i][j]), hexPieces);
				}
			}
		}
	}

	public Piece pieceAtCoord(Coord c, SpriteSheet hexPieces) {
		for(int i = 0; i < spaces.length; i++){
			for(int j = 0; j < spaces[0].length; j++){
				if(spaces[i][j] != null){
					Coord relClick = c.subtract(hexCoordinate.get(spaces[i][j]));
					if(spaces[i][j].drawsRelativePixel(relClick, hexPieces)){
						return spaces[i][j].top();
					}
				}
			}
		}
		return null;
	}
}
