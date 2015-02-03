package rajkum.tw.com.stocknotifier;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rajkum on 2/2/15.
 * This class is for
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StockNotifier";
    private static final int VERSION = 1;

    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, VERSION);
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
}
