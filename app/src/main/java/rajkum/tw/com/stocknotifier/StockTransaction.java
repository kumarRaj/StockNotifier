package rajkum.tw.com.stocknotifier;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;

/**
 * Created by rajkum on 2/2/15.
 * This class is for
 */
public class StockTransaction {
    private int tId;
    private int stockId;
    private Date purchaseDate;
    private float price;
    private int quantity;
    private float upperThreshold;
    private float lowerThreshold;
    private boolean status;
    private TransactionType type;

    public StockTransaction() {

    }

    public static String createTable() {
        return "CREATE TABLE StockTransaction (tId integer PRIMARY KEY, stockId integer, purchaseDate integer, price float, quantity integer, upperThreshold float, lowerThreshold float, status integer, type integer);";
    }

    public static String dropTable() {
        return "DROP TABLE StockTransaction;";
    }

//    public int getTransaction(DBHelper dbHelper){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        String selectQuery = "select last_insert_rowid() from StockTransaction";
//        Cursor cursor = db.rawQuery(selectQuery, null);
//        return cursor.getInt(0);
//    }

    public StockTransaction(int stockId, Date purchaseDate, float price, int quantity, float upperThreshold, float lowerThreshold, boolean status, TransactionType type) {
        this.stockId = stockId;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.quantity = quantity;
        this.upperThreshold = upperThreshold;
        this.lowerThreshold = lowerThreshold;
        this.status = status;
        this.type = type;
    }


    public int getType() {
        return type.ordinal();
    }

    public boolean getStatus() {
        return status;
    }

    public float getLowerThreshold() {
        return lowerThreshold;
    }

    public float getUpperThreshold() {
        return upperThreshold;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public long getPurchaseDate() {
        return purchaseDate.getTime();
    }

    public int getStockId() {
        return stockId;
    }
}
