package rajkum.tw.com.stocknotifier;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText datePicker = (EditText) findViewById(R.id.editText_date);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerFragment newFragment = new DatePickerFragment();
                newFragment.setDate(datePicker);
                newFragment.show(getSupportFragmentManager(), "datePicker");

            }


        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addToStock(View view) {
        DBHelper dbHelper = new DBHelper(this);

        addStockInfo(dbHelper);
        addStockTransaction(dbHelper);
    }

    private void addStockTransaction(DBHelper dbHelper) {
        int stockId = Integer.parseInt(((EditText) findViewById(R.id.editText_stockId)).getText().toString());
        Date date = getDate();
        float price = Float.parseFloat(((EditText) findViewById(R.id.editText_price)).getText().toString());
        int quantity = Integer.parseInt(((EditText) findViewById(R.id.editText_quantity)).getText().toString());
        float upperThreshold = Float.parseFloat(((EditText)findViewById(R.id.editText_upperLimit)).getText().toString());
        float lowerThreshold = Float.parseFloat(((EditText)findViewById(R.id.editText_lowerLimit)).getText().toString());
        boolean status = ((CheckBox)findViewById(R.id.checkBox_status)).isChecked();
        TransactionType transactionType = getTransactionType();

        dbHelper.insertStockTransaction(new StockTransaction(stockId, date, price, quantity, upperThreshold, lowerThreshold, status, transactionType));
    }

    private Date getDate() {
        EditText dateText = (EditText) findViewById(R.id.editText_date);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(dateText.getText().toString());
        }
        catch(ParseException exception) {
            Log.v("DEBUG", exception.toString());
        }
        return date;
    }

    private TransactionType getTransactionType() {
        Spinner spinner = (Spinner) findViewById(R.id.spinner_TransactionType);
        String selectedItem = spinner.getSelectedItem().toString();
        return TransactionType.valueOf(selectedItem);
    }

    private void addStockInfo(DBHelper dbHelper) {
        String stockName = ((EditText) findViewById(R.id.editText_stockName)).getText().toString();
        int stockId = Integer.parseInt(((EditText) findViewById(R.id.editText_stockId)).getText().toString());
        dbHelper.insertIntoStockInfo(new StockInfo(stockId, stockName));
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
