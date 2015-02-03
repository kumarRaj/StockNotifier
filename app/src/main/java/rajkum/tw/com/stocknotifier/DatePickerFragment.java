package rajkum.tw.com.stocknotifier;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by rajkum on 2/3/15.
 * This class is for
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

//
//    public DatePickerFragment(View activity) {
//
//    }
    private EditText date;

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String selectedDate = year + "/" + monthOfYear + "/" + dayOfMonth;
        this.date.setText(selectedDate);
//        view.init(year,monthOfYear,dayOfMonth,null);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public void setDate(EditText date) {
        this.date = date;
    }
}
