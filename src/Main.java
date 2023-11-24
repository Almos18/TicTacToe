import javax.swing.*;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener{

    static char[][] field = new char[3][3];
    static ButtonGroup btnGroup = new ButtonGroup();
    static String selected;
    static JButton btn00 = new JButton();
    static JButton btn01 = new JButton();
    static JButton btn02 = new JButton();
    static JButton btn10 = new JButton();
    static JButton btn11 = new JButton();
    static JButton btn12 = new JButton();
    static JButton btn20 = new JButton();
    static JButton btn21 = new JButton();
    static JButton btn22 = new JButton("[]");

    public Main()
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                selected = e.getActionCommand();
                System.out.println("Button selected: " + e.getActionCommand());

            }
        };


        setLayout(new GridLayout(3, 3));

        btn00.addActionListener(listener);
        btn01.addActionListener(listener);
        btn02.addActionListener(listener);
        btn10.addActionListener(listener);
        btn11.addActionListener(listener);
        btn12.addActionListener(listener);
        btn20.addActionListener(listener);
        btn21.addActionListener(listener);
        btn22.addActionListener(listener);

        add(btn00);
        add(btn01);
        add(btn02);
        add(btn10);
        add(btn11);
        add(btn12);
        add(btn20);
        add(btn21);
        add(btn22);

        if(btn00.getModel().isPressed())
        {
            btn00.setText("O");
        }


    }

    public static void main(String[] args)
    {
        char player = 'O';
        boolean stopRound = false;
        displayField();
        boolean inBattle = true;

        while (!stopRound)
        {
            player = 'O';
            displayField();

            while(!inBattle){
                try {
                    Thread.sleep(200);
                } catch(InterruptedException e) {
                    inBattle=true;
                }
            }

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
        JOptionPane.showMessageDialog(null, "The winner is " + player);
    }


    public static void displayField()
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                JFrame frame = new JFrame("ToggleArray");
                Main mainPanel = new Main();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(mainPanel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                //frame.getContentPane().remove(mainPanel);
            }
        });


    }

    public static void setInput(char player)
    {

            btnGroup.getElements();


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


    public static void validateInput(char player)
    {
        //JOptionPane.showMessageDialog(null, selected);
        boolean valid = false;
        int x;
        int y;
        String input = selected;

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

    @Override
    public void actionPerformed(ActionEvent e)
    {

        selected = e.getActionCommand();
        System.out.println("Button selected: " + e.getActionCommand());


    }
}