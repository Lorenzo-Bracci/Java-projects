import java.util.Random;

//import java.util.concurrent.TimeUnit;


public class ReachablePositionsOnChessBoard {
	public static final Random rand = new Random();
	public static void main(String[]args) 
			 throws ChessBoard.NotValidFieldException{
		
		ChessBoard     chessBoard = new  ChessBoard  ();
		System.out.println (chessBoard + "\n");
		ChessBoard.Chesspiece []   pieces = new  ChessBoard.Chesspiece [6];
		pieces [0] = chessBoard.new  Pawn ('w', 'P');
		pieces [1] = chessBoard.new  Rook ('b', 'R');
		pieces [2] = chessBoard.new  Queen ('w', 'Q');
		pieces [3] = chessBoard.new  Bishop ('w', 'B');
		pieces [4] = chessBoard.new  King ('b', 'K');
		pieces [5] = chessBoard.new  Knight ('w', 'N');
		for (int i = 0; i < 6; i++) {
			int a1 = rand.nextInt(8) + 1;
			byte a = (byte) a1;
			int b1 = rand.nextInt(8);
			int b2 = b1 + 97;
			char b = (char)b2;
			ChessBoard.Chesspiece piece = pieces[i];
			piece.moveTo(b,a);
			piece.markReachableFields();
			System.out.println (chessBoard + "\n");
		//	TimeUnit.SECONDS.sleep(3);
			piece.unmarkReachableFields();
			piece.moveOut();
		}
		
	}
}