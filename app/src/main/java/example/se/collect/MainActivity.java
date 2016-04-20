package example.se.collect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView idView;
    EditText shopBox;
    EditText addressBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idView = (TextView) findViewById(R.id.id_shop);
        shopBox = (EditText) findViewById(R.id.name_shop);
        addressBox = (EditText) findViewById(R.id.address_shop);

    }
    public void newShop (View view) {
       DBHandler mydb = new DBHandler(this);

        // Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");

        mydb.addShop(new Shop(1, shopBox.getText().toString(), addressBox.getText().toString()));

        /*// Reading all shops
        Log.d("Reading: ", "Reading all shops..");
        List<Shop> shops = mydb.getAllShops();

        for(Shop shop : shops) {
            String log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
            // Writing shops to log
            Log.d("Shop: : ", log);
        }*/
        shopBox.setText("");
        addressBox.setText("");
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


}
