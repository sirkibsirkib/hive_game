package hiveGame;

import java.util.ArrayList;
import java.util.List;

import simpleFrame.SimpleFrame;
import spriteLoader.SpriteSheet;

public class Game {
	private Board board;
	private Player white, black, playsNext;
	private PieceBag piecebag;
	
	public Game(Player white, Player black){
		board = new Board();
		playsNext = this.white = white;
		this.black = black;
		piecebag = new PieceBag();
	}

	public void move(Player player, Coord from, Coord to){
		if(playsNext != player){
			throw new Error();
		}
		if((player == white && board.whiteAt(from))
				|| (player == black && board.blackAt(from))){
			if(board.legalMove(from, to));
		}else{
			throw new Error("Illegal move! You don't own that piece!");
		}
		swapTurn();
	}
	
	public void placePiece(Player player, PieceType type, Coord at){
		Piece find = piecebag.remove(player == white, type);
		if(find == null){
			System.out.println("Can't place a piece not in the bag!");
			throw new Error();
		}
		board.placePiece(at, find);
		swapTurn();
	}

	private void swapTurn() {
		playsNext = playsNext == white ? black : white;
	}

	public void drawTo(SimpleFrame sf, SpriteSheet hexPieces){
		board.drawTo(sf, hexPieces);
	}

	public Piece pieceClickedOn(Coord c, SpriteSheet hexPieces) {
		return board.pieceAtCoord(c, hexPieces);
	}
}
