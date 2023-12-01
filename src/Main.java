import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    static char[][] field = new char[3][3];
    static char player = 'O';
    static int turn = 0;
    static boolean keepGoing = true;
    String fontStyle = "Courier";
    JFrame jFrameWindow;
    JButton btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;

    public Main()
    {
        //JButton btn00;
        //Variables var = new Variables();
        //var.setBtn00(btn00);

        jFrameWindow = new JFrame("TicTacToe");

        GridLayout flowLayout = new GridLayout(3,3);

        jFrameWindow.setLayout(flowLayout);

        jFrameWindow.setSize(400,400);

        jFrameWindow.setLocationRelativeTo(null);

        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main.DisplayField selectMove = new Main.DisplayField();

        btn00 = new JButton();
        jFrameWindow.add(btn00);
        btn00.addActionListener(selectMove);

        btn01 = new JButton();
        jFrameWindow.add(btn01);
        btn01.addActionListener(selectMove);

        btn02 = new JButton();
        jFrameWindow.add(btn02);
        btn02.addActionListener(selectMove);

        btn10 = new JButton();
        jFrameWindow.add(btn10);
        btn10.addActionListener(selectMove);

        btn11 = new JButton();
        jFrameWindow.add(btn11);
        btn11.addActionListener(selectMove);

        btn12 = new JButton();
        jFrameWindow.add(btn12);
        btn12.addActionListener(selectMove);

        btn20 = new JButton();
        jFrameWindow.add(btn20);
        btn20.addActionListener(selectMove);

        btn21 = new JButton();
        jFrameWindow.add(btn21);
        btn21.addActionListener(selectMove);

        btn22 = new JButton();
        jFrameWindow.add(btn22);
        btn22.addActionListener(selectMove);

        jFrameWindow.setVisible(true);
    }

    public static void main(String[] args)
    {
        Main guiApp = new Main();
    }

    private class DisplayField implements ActionListener
    {
        Variables var = new Variables();
        public void actionPerformed(ActionEvent e)
        {
            String playerAsString = String.valueOf(player);

            if(e.getSource()==btn00)
            {
                btn00.setFont(new Font(fontStyle, Font.BOLD,90));
                btn00.setText(playerAsString);
                field[0][0] = player;
                btn00.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn01)
            {
                btn01.setFont(new Font(fontStyle, Font.BOLD,90));
                btn01.setText(playerAsString);
                field[0][1] = player;
                btn01.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn02)
            {
                btn02.setFont(new Font(fontStyle, Font.BOLD,90));
                btn02.setText(playerAsString);
                field[0][2] = player;
                btn02.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn10)
            {
                btn10.setFont(new Font(fontStyle, Font.BOLD,90));
                btn10.setText(playerAsString);
                field[1][0] = player;
                btn10.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn11)
            {
                btn11.setFont(new Font(fontStyle, Font.BOLD,90));
                btn11.setText(playerAsString);
                field[1][1] = player;
                btn11.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn12)
            {
                btn12.setFont(new Font(fontStyle, Font.BOLD,90));
                btn12.setText(playerAsString);
                field[1][2] = player;
                btn12.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn20)
            {
                btn20.setFont(new Font(fontStyle, Font.BOLD,90));
                btn20.setText(playerAsString);
                field[2][0] = player;
                btn20.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn21)
            {
                btn21.setFont(new Font(fontStyle, Font.BOLD,90));
                btn21.setText(playerAsString);
                field[2][1] = player;
                btn21.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn22)
            {
                btn22.setFont(new Font(fontStyle, Font.BOLD,90));
                btn22.setText(playerAsString);
                field[2][2] = player;
                btn22.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            if (!keepGoing)
            {

                jFrameWindow.dispose();
                keepGoing = true;
                turn = 0;
                field = new char[3][3];
                player = 'O';
                Main guiApp = new Main();

            }
        }
    }

    public static void CheckWin()
    {
        turn ++;
        boolean win;
        boolean checkHorizontals = false;
        boolean checkVerticals = false;
        boolean checkDiagonals;


        for (int i=0;i<=2;i++)
        {

            if(field[i][0] == 'O' && field[i][1] == 'O' && field[i][2] == 'O')
            {
                checkVerticals = true;
            }

            if(field[i][0] == 'X' && field[i][1] == 'X' && field[i][2] == 'X')
            {
                checkVerticals = true;
            }

            if(field[0][i] == 'O' && field[1][i] == 'O' && field[2][i] == 'O')
            {
                checkHorizontals = true;
            }

            if(field[0][i] == 'X' && field[1][i] == 'X' && field[2][i] == 'X')
            {
                checkHorizontals = true;
            }

        }


        checkDiagonals = (((field[0][0] == 'X') && (field[1][1] == 'X') && (field[2][2] == 'X')) ||
                ((field[0][0] == 'O') && (field[1][1] == 'O') && (field[2][2] == 'O')) ||
                ((field[2][0] == 'X') && (field[1][1] == 'X') && (field[0][2] == 'X')) ||
                ((field[2][0] == 'O') && (field[1][1] == 'O') && (field[0][2] == 'O')));

        win = (checkVerticals || checkHorizontals || checkDiagonals);

       if(win || turn == 9)
       {
           FinishGame(win);
       }

    }

    private static char SwapPlayer(char player)
    {
        if(player=='O')
            player = 'X';
        else
            player = 'O';

        return player;
    }

    private static void FinishGame(boolean win)
    {

        if(win)
        {
            JOptionPane.showMessageDialog(null, "The winner is " + player + ".", "Win",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "The game is a draw", "Draw", JOptionPane.INFORMATION_MESSAGE);

        if(JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Retry?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            //var.setKeepGoing
            keepGoing = false;
        }

        else {
            System.exit(0);
        }

    }
}