import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    static char[][] field = new char[3][3];
    JButton btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
    JFrame jFrameWindow;

    public Main()
    {
        jFrameWindow = new JFrame("TicTacToe");

        GridLayout flowLayout = new GridLayout(3,3);

        jFrameWindow.setLayout(flowLayout);

        jFrameWindow.setSize(400,400);

        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main.SelectMove selectMove = new Main.SelectMove();

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
        char player = 'O';

       /* while (!stopRound)
        {
            player = 'O';
            displayField();



            validateInput(player);

            //setInput(player);
           // JOptionPane.showMessageDialog(null, "Where would O like to move? " +
         //           "(Enter two numbers within the range 0-2)");
            //validateInput(input, player);
            if(!checkWin())
            {
                player = 'X';
        //        JOptionPane.showMessageDialog(null, "Where would X like to move? " +
         //           "(Enter two numbers within the range 0-2)");
            //validateInput(input, player);
            checkWin();

            }
            stopRound = checkWin();

        }
        JOptionPane.showMessageDialog(null, "The winner is " + player); */
    }

    private class SelectMove() implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {

            char player = 'O';
            String playerAsString = String.valueOf(player);
            boolean stopRound = false;

            if(e.getSource()==btn00)
            {
                btn00.setText(playerAsString);
                field[0][0] = player;

            }

            else if(e.getSource()==btn01)
            {
                btn01.setText(playerAsString);
                field[0][1] = player;
            }

            else if(e.getSource()==btn02)
            {
                btn02.setText(playerAsString);
                field[0][2] = player;
            }

            else if(e.getSource()==btn10)
            {
                btn10.setText(playerAsString);
                field[1][0] = player;
            }

            else if(e.getSource()==btn11)
            {
                btn11.setText(playerAsString);
                field[1][1] = player;
            }

            else if(e.getSource()==btn12)
            {
                btn12.setText(playerAsString);
                field[1][2] = player;
            }

            else if(e.getSource()==btn20)
            {
                btn20.setText(playerAsString);
                field[2][0] = player;
            }

            else if(e.getSource()==btn21)
            {
                btn21.setText(playerAsString);
                field[2][1] = player;
            }

            else if(e.getSource()==btn22)
            {
                btn22.setText(playerAsString);
                field[2][2] = player;
            }
        }
    }




 /*   public static void displayField(String display)
        {
            StringBuilder displayBuilder = new StringBuilder(display);
            for (int i=0; i<3; i++)
            {
                for (int j=0; j<3; j++)
                {
                    displayBuilder.append(field[j][i]).append(" ");
                }
                displayBuilder.append("\n");
            }
            display = displayBuilder.toString();
            JOptionPane.showMessageDialog(null, display);
        }
*/


   /* public static void validateInput(char player)
    {
        //JOptionPane.showMessageDialog(null, selected);
        boolean valid = false;
        int x;
        int y;

        while(!valid)
        {
            valid = true;

            if (input.length()!=2) {
                JOptionPane.showMessageDialog(null, "The input is too long or too short");
                valid = false;
            }

            if (valid && (!Character.isDigit(input.charAt(0)) || !Character.isDigit(input.charAt(1)))) {
                JOptionPane.showMessageDialog(null, "The input is not a number");
                valid = false;
            }

            if (valid && ((Character.getNumericValue(input.charAt(0)) > 2) || Character.getNumericValue(input.charAt(1)) > 2)) {
                JOptionPane.showMessageDialog(null, "Out of bounds, " +
                        "enter two numbers within the range 0-2");
                valid = false;
            }

            if (valid && (field[(Character.getNumericValue(input.charAt(0)))][(Character.getNumericValue(input.charAt(1)))] == 'X' ||
                    field[(Character.getNumericValue(input.charAt(0)))][(Character.getNumericValue(input.charAt(1)))] == 'O')) {
                JOptionPane.showMessageDialog(null, "The space is already used");
                valid = false;
            }

            if(!valid)
            {
                input = JOptionPane.showInputDialog(null, "Please enter where you would like to go");
            }


        }
        x=Character.getNumericValue(input.charAt(0));
        y=Character.getNumericValue(input.charAt(1));
        field[x][y] = player;
    }*/


    public static boolean checkWin()
    {
        boolean checkHorizontals;
        boolean checkVerticals;
        boolean checkDiagonals;
        checkVerticals = ((field[0][0] == 'X') && (field[0][1] == 'X') && (field[0][2] == 'X') ||
                ((field[0][0] == 'O') && (field[0][1] == 'O') && (field[0][2] == 'O') ||
                (field[1][0] == 'X') && (field[1][1] == 'X') && (field[1][2] == 'X') ||
                ((field[1][0] == 'O') && (field[1][1] == 'O') && (field[1][2] == 'O') ||
                ((field[2][0] == 'X') && (field[2][1] == 'X') && (field[2][2] == 'X') ||
                (field[2][0] == 'O') && (field[2][1] == 'O') && (field[2][2] == 'O')))));

        checkHorizontals = ((field[0][0] == 'X') && (field[1][0] == 'X') && (field[2][0] == 'X') ||
                ((field[0][1] == 'O') && (field[1][1] == 'O') && (field[2][1] == 'O') ||
                (field[0][2] == 'X') && (field[1][2] == 'X') && (field[2][2] == 'X') ||
                ((field[0][0] == 'O') && (field[1][0] == 'O') && (field[2][0] == 'O') ||
                ((field[0][1] == 'X') && (field[1][1] == 'X') && (field[2][1] == 'X') ||
                (field[0][2] == 'O') && (field[1][2] == 'O') && (field[2][2] == 'O')))));

        checkDiagonals = ((field[0][0] == 'X') && (field[1][1] == 'X') && (field[2][2] == 'X') ||
                ((field[0][0] == 'O') && (field[1][1] == 'O') && (field[2][2] == 'O') ||
                (field[2][0] == 'X') && (field[1][1] == 'X') && (field[0][2] == 'X') ||
                ((field[2][0] == 'O') && (field[1][1] == 'O') && (field[0][2] == 'O'))));

       return checkVerticals || checkHorizontals || checkDiagonals;

    }

}