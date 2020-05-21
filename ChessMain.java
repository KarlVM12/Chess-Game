import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ChessMain
{
    public static void main(String[] beans)
    {
        JOptionPane panel = new JOptionPane();

        ChessBoard cb = new ChessBoard();
        cb.initializeBoard();
        cb.initializePieces();
        cb.placePawns();
        panel.showMessageDialog(null, cb);
        cb.placeRooks();
        cb.placeKnights();
        cb.placeBishops();
        cb.placeQueens();
        cb.placeKings();
        
    }
}