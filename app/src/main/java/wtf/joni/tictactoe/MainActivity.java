package wtf.joni.tictactoe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String[][] field = new String[3][3];
    private static int turn;
    private static boolean gameOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetField();
    }

    private void resetField() {
        turn = 1;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = "";
            }
        }
        ((TextView) findViewById(R.id.b1)).setText("");
        ((TextView) findViewById(R.id.b2)).setText("");
        ((TextView) findViewById(R.id.b3)).setText("");
        ((TextView) findViewById(R.id.b4)).setText("");
        ((TextView) findViewById(R.id.b5)).setText("");
        ((TextView) findViewById(R.id.b6)).setText("");
        ((TextView) findViewById(R.id.b7)).setText("");
        ((TextView) findViewById(R.id.b8)).setText("");
        ((TextView) findViewById(R.id.b9)).setText("");
        gameOn = true;
    }
    public String whoseTurn() {
        if (turn % 2 == 0) {
            return "O";
        } else {
            return "X";
        }
    }
    private void fieldClicked(int row, int column, int button) {
        if (gameOn) {
            if (field[row][column] == "") {
                field[row][column] = whoseTurn();
                ((TextView) findViewById(button)).setText(whoseTurn());
                if (checkWinner()) {
                    ((TextView) findViewById(R.id.whoseTurnText)).setText("Game over!");
                    gameOn = false;
                } else {
                    turn++;
                    if (turn == 10) {
                        ((TextView) findViewById(R.id.whoseTurnText)).setText("Game over, nobody won!");
                        gameOn = false;
                    } else {
                        ((TextView) findViewById(R.id.whoseTurnText)).setText(whoseTurn() + "'s turn");
                    }
                }
            } else {
                showToast("That space is not free!");
            }
        } else {
            if (turn == 10) {
                showToast("Nobody won!");
            } else {
                showToast(whoseTurn() + " won the game!");
            }
        }
    }
    private void showToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private boolean checkWinner() {
        // row 1
        if (!field[0][0].equals("") && field[0][0].equals(field[0][1]) && field[0][0].equals(field[0][2])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // row 2
        if (!field[1][0].equals("") && field[1][0].equals(field[1][1]) && field[1][0].equals(field[1][2])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // row 3
        if (!field[2][0].equals("") && field[2][0].equals(field[2][1]) && field[2][0].equals(field[2][2])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // column 1
        if (!field[0][0].equals("") && field[0][0].equals(field[1][0]) && field[0][0].equals(field[2][0])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // column 2
        if (!field[0][1].equals("") && field[0][1].equals(field[1][1]) && field[0][1].equals(field[2][1])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // column 3
        if (!field[0][2].equals("") && field[0][2].equals(field[1][2]) && field[0][2].equals(field[2][2])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // \
        if (!field[0][0].equals("") && field[0][0].equals(field[1][1]) && field[0][0].equals(field[2][2])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        // /
        if (!field[0][2].equals("") && field[0][2].equals(field[1][1]) && field[0][2].equals(field[2][0])) {
            showToast(whoseTurn() + " won the game!");
            return true;
        }
        return false;
    }
    public void newGame(View v) {
        resetField();
    }
    public void clickB1(View v) {
        fieldClicked(0,0, R.id.b1);
    }
    public void clickB2(View v) {
        fieldClicked(0, 1, R.id.b2);
    }
    public void clickB3(View v) {
        fieldClicked(0, 2, R.id.b3);
    }
    public void clickB4(View v) {
        fieldClicked(1, 0, R.id.b4);
    }
    public void clickB5(View v) {
        fieldClicked(1, 1, R.id.b5);
    }
    public void clickB6(View v) {
        fieldClicked(1, 2, R.id.b6);
    }
    public void clickB7(View v) {
        fieldClicked(2, 0, R.id.b7);
    }
    public void clickB8(View v) {
        fieldClicked(2, 1, R.id.b8);
    }
    public void clickB9(View v) {
        fieldClicked(2, 2, R.id.b9);
    }
}
