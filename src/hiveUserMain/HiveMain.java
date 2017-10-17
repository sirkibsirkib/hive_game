package hiveUserMain;

import files.GenFileLoader;
import hiveGame.Coord;
import hiveGame.Game;
import hiveGame.Piece;
import hiveGame.PieceType;
import hiveGame.Player;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import simpleFrame.Colour;
import simpleFrame.SimpleFrame;
import spriteLoader.SpriteSheet;

public class HiveMain implements MouseListener{
	public static final int PORTNUM = 1234;
	private Game g;
	private Player p1, p2;
	private SpriteSheet hexPieces;
	private SimpleFrame sf;
	
	private HiveMain(){
		sf = new SimpleFrame(800, 500, 1, "Hive", Colour.BLACK);
		sf.registerMouseListener(this);
		hexPieces = new SpriteSheet(GenFileLoader.pathToDesktop("hivePieces.png"), 50, 50, 0xc828c2, 0x820d7e);
		sf.clear(Colour.GRAY);
//		Sprite ant = hivePieces.getSprite(3, 0);
//		Sprite whiteHex = hivePieces.getSprite(0, 0);
//		Sprite blackHex = hivePieces.getSprite(1, 0);
//		whiteHex.paintSelfAt(sf, 40, 100);
//		ant.paintSelfAt(sf, 40, 100);
		sf.render();
		
		p1 = new HumanPlayer();
		p2 = new HumanPlayer();
		g = new Game(p1, p2);
		g.placePiece(p1, PieceType.BEE, new Coord(1, 1));
		g.placePiece(p2, PieceType.ANT, new Coord(5, 3));
		g.placePiece(p1, PieceType.ANT, new Coord(1, 3));
		g.placePiece(p2, PieceType.GRASSHOPPER, new Coord(1, 2));
		g.placePiece(p1, PieceType.GRASSHOPPER, new Coord(0, 2));
		g.drawTo(sf, hexPieces);
		sf.render();
	}

	public static void main(String[] args){
		new HiveMain();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//TODO clicking doesnt really work
		Piece p = g.pieceClickedOn(new Coord(e.getPoint()), hexPieces);
		Colour c = p==null?Colour.RED:Colour.GREEN;
		sf.dot(e.getPoint().x, e.getPoint().y, c);

		sf.render();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
