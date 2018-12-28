import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JPanel {

    // constant values
    static final int INIT_STATE = -1;
    static final int WIN_STATE = 1;
    static final int DRAW_STATE = 2;

    // static variables
    static int player_tracker = 0;      // To swap player after the game end
    static int winnerState = INIT_STATE;            // To track state if it's {INIT_STATE, WIN_STATE or DRAW_STATE}
    static String[] playerString = new String[2];   // To store player indicator
    static String[] array = new String[9];  //For store strings for array
    static JLabel label;
    // instantaneous variables
    String winner = null;               // Winner
    int tracker = 0;                    // Tracker the game turn for each player
    JButton[] buttons = new JButton[9]; // Button array
    private JPanel panel1;              // Panel

    // Constructor for TicTacToeGUI
    public TicTacToeGUI(JFrame frame) {
        if (player_tracker % 2 == 0) {
            // for player one
            playerString[0] = "1";
            playerString[1] = "2";
            //player_tracker++;
        } else {
            // for player 2
            playerString[0] = "2";
            playerString[1] = "1";
            //player_tracker++;
        }
        setLayout(new GridLayout(0, 3));
        createButtons(frame);
        populateEmptyArray();
        add(new JLabel(), BorderLayout.CENTER);
        add(label, BorderLayout.CENTER);
        add(new JLabel(), BorderLayout.CENTER);
    }

    // Main method
    public static void main(String[] args) {
        JFrame jframe = new JFrame("Tic Tac Toe");
        label = new JLabel();
        label.setText("Good Luck!");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().add(new TicTacToeGUI(jframe));
        jframe.setBounds(300, 200, 300, 300);
        jframe.setVisible(true);
    }

    // Create the initial array
    private static void populateEmptyArray() {
        for (int index = 0; index < 9; index++) {
            array[index] = "0";
        }
    }

    // Check win or draw
    public static String checkWin() {
        for (int i = 0; i < 8; i++) {
            String stringLine = null;
            switch (i) {
                case 0:
                    stringLine = array[0] + array[1] + array[2];
                    break;
                case 1:
                    stringLine = array[3] + array[4] + array[5];
                    break;
                case 2:
                    stringLine = array[6] + array[7] + array[8];
                    break;
                case 3:
                    stringLine = array[0] + array[3] + array[6];
                    break;
                case 4:
                    stringLine = array[1] + array[4] + array[7];
                    break;
                case 5:
                    stringLine = array[2] + array[5] + array[8];
                    break;
                case 6:
                    stringLine = array[0] + array[4] + array[8];
                    break;
                case 7:
                    stringLine = array[2] + array[4] + array[6];
                    break;
            }// Switch
            if (stringLine.equals(playerString[0] + playerString[0] + playerString[0])) {
                return playerString[0];
            } else if (stringLine.equals(playerString[1] + playerString[1] + playerString[1])) {
                return playerString[1];
            }
        }// loop

        for (int i = 0; i < 9; i++) {
            String str = String.join("", array);
            if (str.length() < 9) {
                continue;
            } else if (i == 8) return "draw";
        }
        return null;
    }//checkWin

    // Update the array for each button click
    private void updateArray() {
        for (int i = 0; i < 9; i++) {
            array[i] = buttons[i].getText();
        }
    }

    // Method to lock buttonClick if the game ends
    public void lockButtonClick() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    // Method for creating and setting initial states of buttons
    public void createButtons(JFrame frame) {
        int count = 0;
        while (count < 9) {
            buttons[count] = new JButton();
            buttons[count].setText("");
            buttons[count].addActionListener(new ButtonClickListener(frame));
            add(buttons[count]);
            count++;
        }
    }

    // Check if user specifies a new game after end of the current game
    private int checkNextGame(JFrame frame, int winnerState, String winner) {

        String MSG = null;
        switch (winnerState) {
            case WIN_STATE:
                MSG = "Congratulations! Player - " + winner + " have won!\nStart a new game?";
                break;
            case DRAW_STATE:
                MSG = "Game draw!\nStart a new game?";
                break;
            case INIT_STATE:
                MSG = "Game draw!\nStart a new game?";
                break;
        }// switch

        int result = JOptionPane.showConfirmDialog(frame, MSG);
        if (result == JOptionPane.YES_OPTION) {
            //start new game
            return 1;
        } else if (result == JOptionPane.CANCEL_OPTION) {
            //lock game
            return 0;
        } else {
            //close game
            return -1;
        }
    }// checkNextGame

    // cMethod to create a new game if specified
    private void createNewGame() {
        winnerState = INIT_STATE;
        JFrame jframe = new JFrame("Tic Tac Toe");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.getContentPane().add(new TicTacToeGUI(jframe));
        jframe.setBounds(300, 200, 300, 300);
        jframe.setVisible(true);
        label.setText("Good Luck!");
    }// createNewGame

    // Action Listener implementation for button click
    private class ButtonClickListener implements ActionListener {
        boolean isClicked = false;
        JFrame frame;

        // ButtonClickAction listener for the buttons
        public ButtonClickListener(JFrame frame) {
            this.frame = frame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource(); //getting the particular button that was clicked
            if ((tracker % 2) == 0 && !isClicked) {
                isClicked = true;
                clickedButton.setText(playerString[0]);     // Actual Player - 1
                label.setText("Player " + playerString[1] + "'s turn");
                tracker++;
            } else if ((tracker % 2) != 0 && !isClicked) {
                isClicked = true;
                clickedButton.setText(playerString[1]);     // Actual Player - 2
                label.setText("Player " + playerString[0] + "'s turn");
                tracker++;
            }
            updateArray();
            winner = checkWin();
            if (winner != null) {
                if (winner.equalsIgnoreCase("draw")) {
                    winnerState = DRAW_STATE;    // DRAW state
                } else {
                    winnerState = WIN_STATE;    // WIN state
                }
                int res = checkNextGame(this.frame, winnerState, winner);
                if (res == 1) {
                    frame.dispose();
                    createNewGame();
                } else if (res == 0) {
                    // lock button click
                    lockButtonClick();
                } else {
                    //TODO : close game
                    System.exit(0);
                }
            }
        }//actionPerformed
    }// class ButtonClickListener

}

