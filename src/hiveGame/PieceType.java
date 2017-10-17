package hiveGame;

public enum PieceType {
	ANT(3, new Coord(3, 0)),
	SPIDER(2, new Coord(4, 1)),
	MITE(1, new Coord(5, 1)),
	MOSQUITO(1, new Coord(2, 1)),
	GRASSHOPPER(3, new Coord(3, 1)),
	BEETLE(2, new Coord(4, 0)),
	LADYBUG(1, new Coord(1, 1)),
	BEE(1, new Coord(2, 0));
	
	private int piecesPerPlayer;
	private Coord spriteTile;
	PieceType(int piecesPerPlayer, Coord spriteTile){
		this.piecesPerPlayer = piecesPerPlayer;
		this.spriteTile = spriteTile;
	}
	
	public int piecesPerPlayer(){
		return piecesPerPlayer;
	}

	public Coord getSpriteTile() {
		return spriteTile;
	}
}
