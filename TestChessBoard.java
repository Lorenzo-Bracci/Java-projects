

public class TestChessBoard {
	
	public static void main (String[]args)throws ChessBoard.NotValidFieldException {
 ChessBoard a = new ChessBoard();
ChessBoard.Bishop piece = a.new Bishop('w','p');

piece.moveTo('b', (byte)3);

piece.markReachableFields();
System.out.println(a);

}
}
