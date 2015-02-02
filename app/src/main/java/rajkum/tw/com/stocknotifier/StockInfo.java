package rajkum.tw.com.stocknotifier;

/**
 * Created by rajkum on 2/2/15.
 * This class is for
 */
public class StockInfo {
    private int stockId;
    private String stockName;

    public static String createTable() {
        return "CREATE TABLE StockInfo (stockId integer, stockName text);";
    }

    public static String dropTable() {
        return "DROP TABLE StockInfo;";
    }
}
