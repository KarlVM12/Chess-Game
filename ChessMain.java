import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ChessMain
{
    public static void main(String[] beans)
    {
        JOptionPane panel = new JOptionPane();

        ChessBoard cb = new ChessBoard();
        cb.initializeBoard();
        panel.showMessageDialog(null, cb);
        
    }
}