import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static char[][] field = new char[3][3];
    JTextField usernameField;
    JPasswordField passwordField;

    public Main()
    {
        JFrame jFrameWindow = new JFrame("TicTacToe");
        FlowLayout flowLayout = new FlowLayout();
        jFrameWindow.setLayout(flowLayout);
        jFrameWindow.setSize(400,400);
        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel usernameLabel = new JLabel("Username:");

        jFrameWindow.add(usernameLabel);

        usernameField = new JTextField(10);

        jFrameWindow.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");

        jFrameWindow.add(passwordLabel);

        passwordField = new JPasswordField(10);

        jFrameWindow.add(passwordField);

        TextFieldEventHandler handler = new TextFieldEventHandler();

        /*must register an ActionListener for each field here*/
        usernameField.addActionListener(handler);
        passwordField.addActionListener(handler);

        jFrameWindow.setVisible(true);
    }


    public static void main(String[] args)
    {
        Main guiApp = new Main();
        String input;
        char player = 'O';
        boolean stopRound = false;
        String display;

        while (!stopRound)
        {
            player = 'O';
            display = "";
            input = JOptionPane.showInputDialog(null, "Where would O like to move? " +
                    "(Enter two numbers within the range 0-2)");
            validateInput(input, player);
            displayField(display);
            display = "";
            if(!checkWin())
            {
                player = 'X';
                input = JOptionPane.showInputDialog(null, "Where would X like to move? " +
                    "(Enter two numbers within the range 0-2)");
            validateInput(input, player);

            checkWin();
            displayField(display);
            }

            stopRound = checkWin();

        }
        JOptionPane.showMessageDialog(null, "The winner is " + player);
    }
    public static void displayField(String display)
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

    private class TextFieldEventHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //if the text-field triggered the event
            if(e.getSource() == usernameField)
            {
                //set the focus to the password field
                passwordField.requestFocus();
            }
            //if the password field triggered the event (this could be an if-else)
            if(e.getSource() == passwordField)
            {
                //interestingly, getPassword() returns a char[] rather than a String
                char[] passwordCharacters = passwordField.getPassword();

                //converting the char[] to a String
                String passwordText = new String(passwordCharacters);

                if(usernameField.getText().equals("Joe Bloggs") &&
                        passwordText.equals("123abc"))
                    JOptionPane.showMessageDialog(null,"Welcome to the system " +
                                    usernameField.getText(),"Authenticated",
                            JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"Invalid username/password " +
                            "combination","Not authenticated",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    public static void validateInput(String input, char player)
    {
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

            if (valid && (field[(Character.getNumericValue(input.charAt(0)))][(Character.getNumericValue(input.charAt(1)))] == 'X' || field[(Character.getNumericValue(input.charAt(0)))][(Character.getNumericValue(input.charAt(1)))] == 'O')) {
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
    }

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