import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    static char[][] field = new char[3][3];
    static char player = 'O';
    static int turn = 0;
    JButton btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
    JFrame jFrameWindow;
    static boolean game = true;

    public Main()
    {
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
        public void actionPerformed(ActionEvent e)
        {
            String playerAsString = String.valueOf(player);

            if(e.getSource()==btn00)
            {
                btn00.setText(playerAsString);
                field[0][0] = player;
                btn00.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn01)
            {
                btn01.setText(playerAsString);
                field[0][1] = player;
                btn01.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn02)
            {
                btn02.setText(playerAsString);
                field[0][2] = player;
                btn02.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn10)
            {
                btn10.setText(playerAsString);
                field[1][0] = player;
                btn10.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn11)
            {
                btn11.setText(playerAsString);
                field[1][1] = player;
                btn11.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn12)
            {
                btn12.setText(playerAsString);
                field[1][2] = player;
                btn12.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn20)
            {
                btn20.setText(playerAsString);
                field[2][0] = player;
                btn20.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn21)
            {
                btn21.setText(playerAsString);
                field[2][1] = player;
                btn21.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            else if(e.getSource()==btn22)
            {
                btn22.setText(playerAsString);
                field[2][2] = player;
                btn22.setEnabled(false);
                CheckWin();
                player = SwapPlayer(player);
            }

            if (!game)
            {
                jFrameWindow.dispose();
                game = true;
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
        boolean checkHorizontals;
        boolean checkVerticals;
        boolean checkDiagonals;
        checkVerticals = (((field[0][0] == 'X') && (field[0][1] == 'X') && (field[0][2] == 'X')) ||
                ((field[0][0] == 'O') && (field[0][1] == 'O') && (field[0][2] == 'O')) ||
                ((field[1][0] == 'X') && (field[1][1] == 'X') && (field[1][2] == 'X')) ||
                ((field[1][0] == 'O') && (field[1][1] == 'O') && (field[1][2] == 'O')) ||
                ((field[2][0] == 'X') && (field[2][1] == 'X') && (field[2][2] == 'X')) ||
                ((field[2][0] == 'O') && (field[2][1] == 'O') && (field[2][2] == 'O')));

        checkHorizontals = (((field[0][0] == 'X') && (field[1][0] == 'X') && (field[2][0] == 'X')) ||
                ((field[0][1] == 'O') && (field[1][1] == 'O') && (field[2][1] == 'O')) ||
                ((field[0][2] == 'X') && (field[1][2] == 'X') && (field[2][2] == 'X')) ||
                ((field[0][0] == 'O') && (field[1][0] == 'O') && (field[2][0] == 'O')) ||
                ((field[0][1] == 'X') && (field[1][1] == 'X') && (field[2][1] == 'X')) ||
                ((field[0][2] == 'O') && (field[1][2] == 'O') && (field[2][2] == 'O')));

        checkDiagonals = (((field[0][0] == 'X') && (field[1][1] == 'X') && (field[2][2] == 'X')) ||
                ((field[0][0] == 'O') && (field[1][1] == 'O') && (field[2][2] == 'O')) ||
                ((field[2][0] == 'X') && (field[1][1] == 'X') && (field[0][2] == 'X')) ||
                ((field[2][0] == 'O') && (field[1][1] == 'O') && (field[0][2] == 'O')));

       if((checkVerticals || checkHorizontals || checkDiagonals) || turn ==9)
       {
           FinishGame();
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

    private static void FinishGame()
    {
        if(turn!=9)
        {
            JOptionPane.showMessageDialog(null, "The winner is " + player + ".", "Win",JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "The game is a draw", "Draw", JOptionPane.INFORMATION_MESSAGE);

        if(JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Retry?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            game = false;
        }

        else {
            System.exit(0);
        }

    }
}