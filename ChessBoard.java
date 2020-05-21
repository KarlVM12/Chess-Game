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

        // 4 Rooks are added to the chessPieces ArrayList, for 2 Rooks on each side of the board
        for (int piece = 0; piece < BOARD_SIZE / 2; piece++)
            chessPieces.add(new Rook());

        // 4 Knights are added to the chessPieces ArrayList, for 2 Knights on each side of the board
        for (int piece = 0; piece < BOARD_SIZE / 2; piece++)
            chessPieces.add(new Knight());

        // 4 Bishops are added to the chessPieces ArrayList, for 2 Bishops on each side of the board
        for (int piece = 0; piece < BOARD_SIZE / 2; piece++)
            chessPieces.add(new Bishop());       

        // 2 Queens are added to the chessPieces ArrayList, for 1 Queen on each side of the board
        for (int piece = 0; piece < 2; piece++)
            chessPieces.add(new Queen());
        
        // 2 Kings are added to the chessPieces ArrayList, for 1 King on each side of the board
        for (int piece = 0; piece < 2; piece++)
            chessPieces.add(new King());

    }

    // This methods adds pawns to the regular place on the chess board
    public void placePawns()
    {
        // col is used to place a pawn at that index of each row
        int col = 0;

        // while loop adds pawns to the board until there are none left in the chessPieces ArrayList
        // col < 8 short-circuits the loop otherwise is would check for another piece that is already removed causing an exception
        // checkPieces accepts any class to check if that class of pieces is in chessPieces 
        while (col < 8 && checkPieces(new Pawn()))
        {
            // A pawn is added from chessPieces and then removed
            chessBoard[1][col] = chessPieces.get(0).toString();
            chessPieces.remove(chessPieces.get(0)); // when the Pawn at index 0 is removed, all Pawns shift down an index till none are left

            // a pawn is added from chessPieces and then removed
            chessBoard[6][col] = chessPieces.get(0).toString();   
            chessPieces.remove(chessPieces.get(0));

            col++;
     
        } 
    
    }

    // adds Rooks to the corners of the ChessBoard
    public void placeRooks()
    {
        // if four Rooks are present in chessPieces ArrayList, they are placed on the board
        if (checkPieces(new Rook()))
        {
            chessBoard[0][0] = chessPieces.get(0).toString();
            chessBoard[0][7] = chessPieces.get(1).toString();

            chessBoard[7][0] = chessPieces.get(2).toString();
            chessBoard[7][7] = chessPieces.get(3).toString();
        }

        // four Rooks placed are removed from the chessPieces ArrayList
        for (int piece = 0; piece < 4; piece++)
            chessPieces.remove(chessPieces.get(0));
        
    }
    
    // adds Knights to their appropriate starting position on ChessBoard
    public void placeKnights()
    {
        // if four Knights are present in chessPieces ArrayList, they are placed on the board
        if (checkPieces(new Knight()))
        {
            chessBoard[0][1] = chessPieces.get(0).toString();
            chessBoard[0][6] = chessPieces.get(1).toString();

            chessBoard[7][1] = chessPieces.get(2).toString();
            chessBoard[7][6] = chessPieces.get(3).toString();
        }

        // four Knights are removed from the chessPieces Arraylist
        for (int piece = 0; piece < 4; piece++)
            chessPieces.remove(chessPieces.get(0));

    }

    // adds Bishops to their appropriate starting position on ChessBoard
    public void placeBishops()
    {
        // if four Bishops are present in chessPieces ArrayList, they are placed on the board
        if (checkPieces(new Bishop()))
        {
            chessBoard[0][2] = chessPieces.get(0).toString();
            chessBoard[0][5] = chessPieces.get(1).toString();

            chessBoard[7][2] = chessPieces.get(2).toString();
            chessBoard[7][5] = chessPieces.get(3).toString();
        }

        // four Bishops are removed from the chessPieces Arraylist
        for (int piece = 0; piece < 4; piece++)
            chessPieces.remove(chessPieces.get(0));

    }

    // add Queens to their starting positions on ChessBoard
    public void placeQueens()
    {
        // if two Queens are present in chessPieces ArrayList, they are placed on the board
        if (checkPieces(new Queen()))
        {
            chessBoard[0][3] = chessPieces.get(0).toString();
            chessBoard[7][3] = chessPieces.get(0).toString();
        }

        // Two Queens are removed from chessPieces ArrayList
        for (int piece = 0; piece < 2; piece++)
            chessPieces.remove(chessPieces.get(0));

    }

    // add Kings to their starting positions on ChessBoard
    public void placeKings()
    {
        // if two Kings are present in chessPieces ArrayList, they are placed on the board
        if (checkPieces(new King()))
        {
            chessBoard[0][4] = chessPieces.get(0).toString();
            chessBoard[7][4] = chessPieces.get(0).toString();
        }

        // Two Kings are removed from chessPieces ArrayList
        for (int piece = 0; piece < 2; piece++)
            chessPieces.remove(chessPieces.get(0));
            
    }

    // checks if a piece belongs to a certain ChessPiece class passed through
    public boolean checkPieces(ChessPiece p)
    {
        // while loop in placePawns() uses this to make sure the next object in ArrayList is a Pawn
        if (p instanceof Pawn && chessPieces.get(0) instanceof Pawn)
            return true;

        // if statement in placeRooks() uses this to make sure next four pieces are Rooks
        if (p instanceof Rook && chessPieces.get(0) instanceof Rook && chessPieces.get(3) instanceof Rook)
            return true;

        // if statement in placeKnights() uses this to make sure next four pieces are Knights
        if (p instanceof Knight && chessPieces.get(0) instanceof Knight && chessPieces.get(3) instanceof Knight)
            return true;

        // if statement in placeBishops() uses this to make sure next four pieces are Bishops
        if (p instanceof Bishop && chessPieces.get(0) instanceof Bishop && chessPieces.get(3) instanceof Bishop)
            return true;

        // if statement in placeQueens() uses this to make sure next two pieces are Queens
        if (p instanceof Queen && chessPieces.get(0) instanceof Queen && chessPieces.get(1) instanceof Queen)
            return true;

        // if statement in placeKings() uses this to make sure next two pieces are Kings
        if (p instanceof King && chessPieces.get(0) instanceof King && chessPieces.get(1) instanceof King)
            return true;

        return false;
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