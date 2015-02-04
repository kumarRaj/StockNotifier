package rajkum.tw.com.stocknotifier;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rajkum on 2/2/15.
 * This class is for
 */
public class StockInfo {
    private int stockId;
    private String stockName;

    public StockInfo(int stockId, String stockName) {
        this.stockId = stockId;
        this.stockName = stockName;
    }

    public static String createTable() {
        return "CREATE TABLE StockInfo (stockId integer, stockName text);";
    }

    public static String dropTable() {
        return "DROP TABLE StockInfo;";
    }


    public int getStockId() {
        return stockId;
    }

    public String getStockName() {
        return stockName;
    }
}
