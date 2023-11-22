import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel {

    static char[][] field = new char[3][3];
    static JButton topLeft;
    static JButton topMiddle;
    JButton topRight = new JButton("[]");
    JButton middleLeft = new JButton("[]");
    JButton middle = new JButton("[]");
    JButton middleRight = new JButton("[]");
    JButton bottomLeft = new JButton("[]");
    JButton bottomMiddle = new JButton("[]");
    JButton bottomRight = new JButton("[]");

    public Main()
    {
        ActionListener listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button selected: " + e.getActionCommand());
            }
        };

        setLayout(new GridLayout(3, 3));
        ButtonGroup btnGroup = new ButtonGroup();
        for (int i = 0; i < 3 * 3; i++) {
            String text = String.format("[%d, %d]", i % 3, i / 3);
            JToggleButton btn = new JToggleButton(text);
            btn.addActionListener(listener);
            btnGroup.add(btn);
            add(btn);
        }

        /*JFrame jFrameWindow = new JFrame("TicTacToe");
        FlowLayout flowLayout = new FlowLayout();
        jFrameWindow.setLayout(flowLayout);
        jFrameWindow.setSize(400,400);
        jFrameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        topLeft = new JButton(Character.toString(field[0][0]));
        jFrameWindow.add(topLeft);
        topMiddle = new JButton(Character.toString(field[1][0]));
        jFrameWindow.add(topMiddle);*/
        //jFrameWindow.setVisible(true);







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
            inputField(player);
           /* input = JOptionPane.showInputDialog(null, "Where would O like to move? " +
                    "(Enter two numbers within the range 0-2)");*/
            //validateInput(input, player);
            //displayField(display);
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


    public static void inputField(char player)
    {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
        /*topLeft.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                field[0][0] = 'O';
            }
        });*/

        /*if(e.getSource() == topLeft)
        {
            topLeft.requestFocus();
        }
        if(e.getSource() == topMiddle)
        {
            topMiddle.requestFocus();
        }*/
    }
    private static void createAndShowGui() {
        Main mainPanel = new Main();

        JFrame frame = new JFrame("ToggleArray");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
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