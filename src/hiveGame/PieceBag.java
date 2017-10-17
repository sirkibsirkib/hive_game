package hiveGame;

import java.util.ArrayList;
import java.util.List;

public class PieceBag {
	private List<Piece> pieces;
	
	public PieceBag(){
		pieces = new ArrayList<>();
		for(int i = 0; i < 2; i++){
			boolean whitePiece = i == 0;
			for(PieceType type : PieceType.values()){
				for(int j = 0; j < type.piecesPerPlayer(); j++){
					pieces.add(new Piece(whitePiece, type));
				}
			}
		}
	}

	public Piece remove(boolean whitePiece, PieceType type) {
		for(int i = 0; i < pieces.size(); i++){
			if((pieces.get(i).isWhite() && whitePiece)
					|| (pieces.get(i).isBlack() && !whitePiece)){
				if(pieces.get(i).getType() == type){
					return pieces.remove(i);
				}
			}
		}
		return null;
	}
}
