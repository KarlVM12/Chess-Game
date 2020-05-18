import java.util.ArrayList;

public class ChessBoard
{
    private String EMPTY = "0";
    private int BOARD_SIZE = 8;
    private ArrayList<ChessPiece> chessPieces; // = new ChessPiece[32]; 
    private String[][] chessBoard; // = new String[BOARD_SIZE][BOARD_SIZE];

    public ChessBoard()
    {
        this.chessPieces = new ArrayList<ChessPiece>();
        this.chessBoard = new String[BOARD_SIZE][BOARD_SIZE];    

    }

    public void initializeBoard()
    {
        for (int row = 0; row < BOARD_SIZE; row++)
            for (int col = 0; col < BOARD_SIZE; col++)
                chessBoard[row][col] = EMPTY;

    }

}