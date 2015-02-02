package rajkum.tw.com.stocknotifier;

import java.util.Date;

/**
 * Created by rajkum on 2/2/15.
 * This class is for
 */
public class Transaction {
    private int tId;
    private int stockId;
    private Date purchaseDate;
    private float price;
    private int quantity;
    private float upperThreshold;
    private float lowerThreshold;
    private boolean status;
    private TransactionType type;

    public static String createTable() {
        return "CREATE TABLE Transaction (tId integer, stockId integer, purchaseDate integer, price real, quantity integer, upperThreshold real, lowerThreshold real, status boolean, type integer);";
    }

    public static String dropTable() {
        return "DROP TABLE Transaction;";
    }
}
