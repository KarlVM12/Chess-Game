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

    public void initializePieces()
    {
        // 16 pawns are added to the chessPieces ArrayList, for 8 pawns on each side of the board
        for (int piece = 0; piece < BOARD_SIZE * 2; piece++)
            chessPieces.add(new Pawn());

    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
                result += chessBoard[i][j] + "      ";
            result += "\n";
        }

        return result;
    }
}