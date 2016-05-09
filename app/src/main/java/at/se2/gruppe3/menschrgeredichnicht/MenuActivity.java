package at.se2.gruppe3.menschrgeredichnicht;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static android.hardware.SensorManager.*;

/**
 * Created by oliver on 15.04.16.
 */
public class MenuActivity extends Activity implements View.OnClickListener{


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    Button btnNewGame, btnJoinGame, btnHelp, btnConnect;
    Spieler spieler;
    String textname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        initialize();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();





    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Menu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://at.se2.gruppe3.menschrgeredichnicht/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Menu Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://at.se2.gruppe3.menschrgeredichnicht/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }



    @Override
    public void onClick(View view) {


        switch(view.getId()){
            case R.id.btnNewGame:
                Intent newGameScreen = new Intent(getApplicationContext(),
                        BoardActivity.class);
                startActivity(newGameScreen);

                break;
            case R.id.btnJoinGame:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                final AlertDialog alertDialog = new AlertDialog.Builder(MenuActivity.this).create();
                alertDialog.setTitle("Spiel Beitreten");
                alertDialog.setMessage("Gib deinen Namen ein:");
                // Set up the input
                final EditText input = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_CLASS_TEXT);
                alertDialog.setView(input);



                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                textname = input.getText().toString();

                                spieler= new Spieler(textname);
                                Toast.makeText(getApplicationContext(), spieler.getName() + " ist beigetreten", Toast.LENGTH_LONG).show();
                                Intent newGameScreen = new Intent(getApplicationContext(),BoardActivity.class);
                                startActivity(newGameScreen);
                            }
                        });

                if(!alertDialog.isShowing()){
                    alertDialog.show();

                }



                break;
            case R.id.btnHelp:
                Intent newHilfeScreen = new Intent(getApplicationContext(),
                        Hilfe.class);
                startActivity(newHilfeScreen);
                break;
            case R.id.btnConnect:
                Intent newConnectScreen = new Intent(getApplicationContext(),
                        Connect.class);
                startActivity(newConnectScreen);

                break;

        }
    }

    public void initialize(){
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(this);
        btnJoinGame = (Button) findViewById(R.id.btnJoinGame);
        btnJoinGame.setOnClickListener(this);
        btnHelp = (Button) findViewById(R.id.btnHelp);
        btnHelp.setOnClickListener(this);
        btnConnect = (Button) findViewById(R.id.btnConnect);
        btnConnect.setOnClickListener(this);
    }



    /**
     * SHAKE LISTENER TESTS FROM HERE
     * not working very well :D
     * still too sensitive
     */

    /**TODO
     * improve Shake Listener
     */


}
