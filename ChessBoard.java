
public class ChessBoard {
	public class NotValidFieldException extends Exception {
		private static final long serialVersionUID = 1L;
		public NotValidFieldException() {super();}
		public NotValidFieldException(String msg) {
			super(msg); 
		}

	}
	public static class Field {
		private char row;
		private byte column;
		private Chesspiece piece = null;
		private boolean marked = false;

		public Field(char row, byte column) {
			this.row = row;
			this.column = column;
		}

		public void put(Chesspiece piece) {
			this.piece = piece;

		}

		public Chesspiece take() {
			this.piece = null;
			return this.piece;
		}

		public void mark() {
			this.marked = true;
		}

		public void unmark() {
			this.marked = false;
		}

		public String toString() {
			String s = (marked) ? " xx " : " --";
			return (piece == null) ? s : piece.toString();
		}
	}

	public static final int NUMBER_OF_ROWS = 8;
	public static final int NUMBER_OF_COLUMNS = 8;
	public static final int FIRST_ROW = 'a';
	public static final int FIRST_COLUMN = 1;
	private Field[][] fields;

	public ChessBoard() {
		fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		char row = 0;
		byte column = 0;
		for (int r = 0; r < NUMBER_OF_ROWS; r++) {
			row = (char) (FIRST_ROW + r);
			column = FIRST_COLUMN;
			for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
				fields[r][c] = new Field(row, column);
				column++;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < NUMBER_OF_ROWS; i++) {
			for (int j = 0; j < NUMBER_OF_ROWS; j++) {
				sb.append(fields[i][j].toString() + "|");
			}
			sb.append("\n\n");
		}
		return sb.toString();
	}

	public boolean isValidField(char row, byte column) {
// if (row > 60 && row < 69 && column > 0 && column < 9)
		if (row >= 'a' && row <= 'h' && column > 0 && column < 9) {
			return true;
		} else {
			return false;
		}
	}

	public abstract class Chesspiece {
		private char color;
// w - white , b - black
		private char name;
// K - King , Q - Queen , R - Rook , B - Bishop , N - Knight ,
// P Pawn
		protected char row = 0;
		protected byte column = -1;

		protected Chesspiece(char color, char name) {
			this.color = color;
			this.name = name;
		}

		public String toString() {
			return " " + color + name;
		}

		public boolean isOnBoard() {
			return ChessBoard.this.isValidField(row, column);
		}

		public void moveTo(char row, byte column)
				throws NotValidFieldException{
			if (!ChessBoard.this.isValidField(row, column)) {
					throw new NotValidFieldException( "badfield :" + row + column);
			 }
		//	NotValidFieldExeption a = new NotValidFieldExeption;
			//try {
				//ChessBoard.this.isValidField(row, column);
				//}
			//catch (NotValidFieldExeption){}
					this.row = row;
			this.column = column;
			int r = row - FIRST_ROW;
			int c = column - FIRST_COLUMN;
			ChessBoard.this.fields[r][c].put(this);
		}

		public void moveOut() {
			ChessBoard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();

		}

		public abstract void markReachableFields();

		public abstract void unmarkReachableFields();
	}

	public class Pawn extends Chesspiece {
		public Pawn(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			
			byte col = (byte) (column + 1);
			if (ChessBoard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				ChessBoard.this.fields[r][c].mark();
				
			}
			
		}

		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			if (ChessBoard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				ChessBoard.this.fields[r][c].unmark();
			}
		}
	}

	public class Rook extends Chesspiece {
		public Rook(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			byte col = (byte) (column + 1);
			byte col1 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
			while (ChessBoard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				ChessBoard.this.fields[r][c].mark();
				col++;
			} 
			while (ChessBoard.this.isValidField(row, col1)) {
				int r1 = row - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].mark();
				col1--;
			}
			while (ChessBoard.this.isValidField(row1, column)) {
				int r3 = row1 - FIRST_ROW;
				int c3 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].mark();
				row1++;
		}
			while (ChessBoard.this.isValidField(row2, column)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].mark();
				row2--;
			} 

		}

		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			byte col1 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
			while (ChessBoard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				ChessBoard.this.fields[r][c].unmark();
				col++;
			}
			while (ChessBoard.this.isValidField(row, col1)) {
				int r1 = row - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].unmark();
				col1--;
			}
			while (ChessBoard.this.isValidField(row1, column)) {
				int r3 = row1 - FIRST_ROW;
				int c3 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].unmark();
				row1++;
			}
			while (ChessBoard.this.isValidField(row2, column)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].unmark();
				row2--;
			}
		}

	}

	public class Bishop extends Chesspiece {
		public Bishop(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			byte col1 = (byte) (column + 1);
			byte col2 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
		
			
			while(ChessBoard.this.isValidField(row1, col1)){
				int r1 = row1 - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].mark();
				row1++;
				col1++;
				}
			while(ChessBoard.this.isValidField(row2, col2)){
				int r4 = row2 - FIRST_ROW;
				int c4 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].mark();
				row2--;
				col2--;
				} 
			byte col3 = (byte) (column + 1);
			byte col4 = (byte) (column - 1);
			
			char row3 = (char) row11;
			char row4 = (char) row22;
			while(ChessBoard.this.isValidField(row3, col4)){
				int r3 = row3 - FIRST_ROW;
				int c3 = col4 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].mark();
				row3++;
				col4--;
				}
			while(ChessBoard.this.isValidField(row4, col3)){
				int r2 = row4 - FIRST_ROW;
				int c2 = col3 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].mark();
				row4--;
				col3++;
				}
		
		}

		public void unmarkReachableFields() {
			byte col1 = (byte) (column + 1);
			byte col2 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
		
			
			while(ChessBoard.this.isValidField(row1, col1)){
				int r1 = row1 - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].unmark();
				row1++;
				col1++;
				}
			while(ChessBoard.this.isValidField(row2, col2)){
				int r4 = row2 - FIRST_ROW;
				int c4 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].unmark();
				row2--;
				col2--;
				} 
			byte col3 = (byte) (column + 1);
			byte col4 = (byte) (column - 1);
			
			char row3 = (char) row11;
			char row4 = (char) row22;
			while(ChessBoard.this.isValidField(row3, col4)){
				int r3 = row3 - FIRST_ROW;
				int c3 = col4 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].unmark();
				row3++;
				col4--;
				}
			while(ChessBoard.this.isValidField(row4, col3)){
				int r2 = row4 - FIRST_ROW;
				int c2 = col3 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].unmark();
				row4--;
				col3++;
				}
		}
	}

	public class Knight extends Chesspiece {
		public Knight(char color, char name) {
			super(color, name);
		}
      	public void markReachableFields() {
			byte col1 = (byte) (column + 1);
			byte col2 = (byte) (column - 1);
			byte col3 = (byte) (column + 2);
			byte col4 = (byte) (column - 2);
			int row11 = (row + 1);
			int row22 = (row - 1);
			int row33 = (row + 2);
			int row44 = (row - 2);
			char row1 = (char) row11;
			char row2 = (char) row22;
			char row3 = (char) row33;
			char row4 = (char) row44;
			if (ChessBoard.this.isValidField(row1, col3)) {
				int r1 = row1 - FIRST_ROW;
				int c1 = col3 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].mark();
			}
			if (ChessBoard.this.isValidField(row2, col3)) {
				int r2 = row2 - FIRST_ROW;
				int c2 = col3 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].mark();
			}
			if (ChessBoard.this.isValidField(row1, col4)) {
				int r3 = row1 - FIRST_ROW;
				int c3 = col4 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].mark();
			}
			if (ChessBoard.this.isValidField(row2, col4)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = col4 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].mark();
			}
			if (ChessBoard.this.isValidField(row3, col1)) {
				int r5 = row3 - FIRST_ROW;
				int c5 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r5][c5].mark();
			}
			if (ChessBoard.this.isValidField(row3, col2)) {
				int r6 = row3 - FIRST_ROW;
				int c6 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r6][c6].mark();
			}
			if (ChessBoard.this.isValidField(row4, col1)) {
				int r7 = row4 - FIRST_ROW;
				int c7 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r7][c7].mark();
			}
			if (ChessBoard.this.isValidField(row4, col2)) {
				int r8 = row4 - FIRST_ROW;
				int c8 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r8][c8].mark();
			}
		}

		public void unmarkReachableFields() {
			byte col1 = (byte) (column + 1);
			byte col2 = (byte) (column - 1);
			byte col3 = (byte) (column + 2);
			byte col4 = (byte) (column - 2);
			int row11 = (row + 1);
			int row22 = (row - 1);
			int row33 = (row + 2);
			int row44 = (row - 2);
			char row1 = (char) row11;
			char row2 = (char) row22;
			char row3 = (char) row33;
			char row4 = (char) row44;
			if (ChessBoard.this.isValidField(row1, col3)) {
				int r1 = row1 - FIRST_ROW;
				int c1 = col3 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].unmark();
			}
			if (ChessBoard.this.isValidField(row2, col3)) {
				int r2 = row2 - FIRST_ROW;
				int c2 = col3 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].unmark();
			}
			if (ChessBoard.this.isValidField(row1, col4)) {
				int r3 = row1 - FIRST_ROW;
				int c3 = col4 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].unmark();
			}
			if (ChessBoard.this.isValidField(row2, col4)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = col4 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].unmark();
			}
			if (ChessBoard.this.isValidField(row3, col1)) {
				int r5 = row3 - FIRST_ROW;
				int c5 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r5][c5].unmark();
			}
			if (ChessBoard.this.isValidField(row3, col2)) {
				int r6 = row3 - FIRST_ROW;
				int c6 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r6][c6].unmark();
			}
			if (ChessBoard.this.isValidField(row4, col1)) {
				int r7 = row4 - FIRST_ROW;
				int c7 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r7][c7].unmark();
			}
			if (ChessBoard.this.isValidField(row4, col2)) {
				int r8 = row4 - FIRST_ROW;
				int c8 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r8][c8].unmark();
			}
		}
	}

	public class Queen extends Chesspiece {
		public Queen(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			byte col = (byte) (column + 1);
			byte col1 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
			while (ChessBoard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				ChessBoard.this.fields[r][c].mark();
				col++;
			} 
			while (ChessBoard.this.isValidField(row, col1)) {
				int r1 = row - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].mark();
				col1--;
			}
			while (ChessBoard.this.isValidField(row1, column)) {
				int r3 = row1 - FIRST_ROW;
				int c3 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].mark();
				row1++;
		}
			while (ChessBoard.this.isValidField(row2, column)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].mark();
				row2--;
			} 
			byte col5 = (byte) (column + 1);
			byte col6 = (byte) (column - 1);
			
			char row5 = (char) row11;
			char row6 = (char) row22;
		
			
			while(ChessBoard.this.isValidField(row5, col5)){
				int r1 = row5 - FIRST_ROW;
				int c1 = col5 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].mark();
				row5++;
				col5++;
				}
			while(ChessBoard.this.isValidField(row6, col6)){
				int r4 = row6 - FIRST_ROW;
				int c4 = col6 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].mark();
				row6--;
				col6--;
				} 
			byte col7 = (byte) (column + 1);
			byte col8 = (byte) (column - 1);
			
			char row7 = (char) row11;
			char row8 = (char) row22;
			while(ChessBoard.this.isValidField(row7, col8)){
				int r3 = row7 - FIRST_ROW;
				int c3 = col8 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].mark();
				row7++;
				col8--;
				}
			while(ChessBoard.this.isValidField(row8, col7)){
				int r2 = row8 - FIRST_ROW;
				int c2 = col7 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].mark();
				row8--;
				col7++;
				}
		
		
		}

		public void unmarkReachableFields() {
			byte col = (byte) (column + 1);
			byte col1 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
			while (ChessBoard.this.isValidField(row, col)) {
				int r = row - FIRST_ROW;
				int c = col - FIRST_COLUMN;
				ChessBoard.this.fields[r][c].unmark();
				col++;
			} 
			while (ChessBoard.this.isValidField(row, col1)) {
				int r1 = row - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].unmark();
				col1--;
			}
			while (ChessBoard.this.isValidField(row1, column)) {
				int r3 = row1 - FIRST_ROW;
				int c3 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].unmark();
				row1++;
		}
			while (ChessBoard.this.isValidField(row2, column)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].unmark();
				row2--;
			} 
			byte col5 = (byte) (column + 1);
			byte col6 = (byte) (column - 1);
			
			char row5 = (char) row11;
			char row6 = (char) row22;
		
			
			while(ChessBoard.this.isValidField(row5, col5)){
				int r1 = row5 - FIRST_ROW;
				int c1 = col5 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].unmark();
				row5++;
				col5++;
				}
			while(ChessBoard.this.isValidField(row6, col6)){
				int r4 = row6 - FIRST_ROW;
				int c4 = col6 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].unmark();
				row6--;
				col6--;
				} 
			byte col7 = (byte) (column + 1);
			byte col8 = (byte) (column - 1);
			
			char row7 = (char) row11;
			char row8 = (char) row22;
			while(ChessBoard.this.isValidField(row7, col8)){
				int r3 = row7 - FIRST_ROW;
				int c3 = col8 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].unmark();
				row7++;
				col8--;
				}
			while(ChessBoard.this.isValidField(row8, col7)){
				int r2 = row8 - FIRST_ROW;
				int c2 = col7 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].unmark();
				row8--;
				col7++;
				}
		
		}
	}

	public class King extends Chesspiece {
		public King(char color, char name) {
			super(color, name);
		}

		public void markReachableFields() {
			byte col1 = (byte) (column + 1);
			byte col2 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
			if (ChessBoard.this.isValidField(row1, col1)) {
				int r1 = row1 - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].mark();
			}
			if (ChessBoard.this.isValidField(row1, col2)) {
				int r2 = row1 - FIRST_ROW;
				int c2 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].mark();
			}
			if (ChessBoard.this.isValidField(row2, col1)) {
				int r3 = row2 - FIRST_ROW;
				int c3 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].mark();
			}
			if (ChessBoard.this.isValidField(row2, col2)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].mark();
			}
			if (ChessBoard.this.isValidField(row1, column)) {
				int r5 = row1 - FIRST_ROW;
				int c5 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r5][c5].mark();
			}
			if (ChessBoard.this.isValidField(row2, column)) {
				int r6 = row2 - FIRST_ROW;
				int c6 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r6][c6].mark();
			}
			if (ChessBoard.this.isValidField(row, col1)) {
				int r7 = row - FIRST_ROW;
				int c7 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r7][c7].mark();
			}
			if (ChessBoard.this.isValidField(row, col2)) {
				int r8 = row - FIRST_ROW;
				int c8 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r8][c8].mark();
			}
	
		}

		public void unmarkReachableFields() {
			byte col1 = (byte) (column + 1);
			byte col2 = (byte) (column - 1);
			int row11 = (row + 1);
			int row22 = (row - 1);
			char row1 = (char) row11;
			char row2 = (char) row22;
			if (ChessBoard.this.isValidField(row1, col1)) {
				int r1 = row1 - FIRST_ROW;
				int c1 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r1][c1].unmark();
			}
			if (ChessBoard.this.isValidField(row1, col2)) {
				int r2 = row1 - FIRST_ROW;
				int c2 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r2][c2].unmark();
			}
			if (ChessBoard.this.isValidField(row2, col1)) {
				int r3 = row2 - FIRST_ROW;
				int c3 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r3][c3].unmark();
			}
			if (ChessBoard.this.isValidField(row2, col2)) {
				int r4 = row2 - FIRST_ROW;
				int c4 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r4][c4].unmark();
			}
			if (ChessBoard.this.isValidField(row1, column)) {
				int r5 = row1 - FIRST_ROW;
				int c5 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r5][c5].unmark();
			}
			if (ChessBoard.this.isValidField(row2, column)) {
				int r6 = row2 - FIRST_ROW;
				int c6 = column - FIRST_COLUMN;
				ChessBoard.this.fields[r6][c6].unmark();
			}
			if (ChessBoard.this.isValidField(row, col1)) {
				int r7 = row - FIRST_ROW;
				int c7 = col1 - FIRST_COLUMN;
				ChessBoard.this.fields[r7][c7].unmark();
			}
			if (ChessBoard.this.isValidField(row, col2)) {
				int r8 = row - FIRST_ROW;
				int c8 = col2 - FIRST_COLUMN;
				ChessBoard.this.fields[r8][c8].unmark();
			}
		}
	}
}