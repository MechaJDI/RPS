package mechaapps.com.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Add selection to screen
    public void addChoice(View view) {
        TextView text = (TextView) findViewById(R.id.input);
        Button button = (Button) view;
        String choice = (String) button.getText();
        text.append(choice);
        //text.setText("Test");
    }

    //Clear selection screen
    public void clearChoice(View view) {
        TextView text = (TextView) findViewById(R.id.input);
        text.setText("");
        //text.setText("Test");
    }

    //Run the game
    public void submission(View view) {
        GameEngine game = new GameEngine();
        String message = new String();
        String input = new String();
        TextView inText = (TextView) findViewById(R.id.input);
        TextView outText = (TextView) findViewById(R.id.output);
        input = inText.getText().toString();
        message = game.getInput(input);
        outText.setText(message);
    }
}
