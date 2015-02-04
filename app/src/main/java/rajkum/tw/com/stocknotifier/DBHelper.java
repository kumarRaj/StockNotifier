package rajkum.tw.com.stocknotifier;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by rajkum on 2/2/15.
 * This class is for talking to the database and exposing things as methods.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StockNotifier";
    private static final int VERSION = 1;
    private SQLiteDatabase db;

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(StockInfo.createTable());
        db.execSQL(StockTransaction.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(StockInfo.dropTable());
        db.execSQL(StockTransaction.dropTable());

        onCreate(db);

    }

    public void insertIntoStockInfo(StockInfo stockInfo){
        ContentValues values = new ContentValues();
        values.put("stockId",stockInfo.getStockId());
        values.put("stockName",stockInfo.getStockName());

        db.insert("StockInfo", null, values);
    }

    public void insertStockTransaction(StockTransaction transaction){
        ContentValues values = new ContentValues();
        values.put("stockId",transaction.getStockId());
        values.put("purchaseDate",transaction.getPurchaseDate());
        values.put("price",transaction.getPrice());
        values.put("quantity",transaction.getQuantity());
        values.put("upperThreshold",transaction.getUpperThreshold());
        values.put("lowerThreshold",transaction.getLowerThreshold());
        values.put("status",transaction.getStatus());
        values.put("type",transaction.getType());

        long status = db.insert("StockTransaction",null,values);
        Log.v("DEBUG", "db.insertIntoStockInfo returned:" + String.valueOf(status));
    }
}
