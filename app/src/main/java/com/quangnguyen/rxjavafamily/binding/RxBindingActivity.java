package com.quangnguyen.rxjavafamily.binding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.quangnguyen.rxjavafamily.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.TimeUnit;

public class RxBindingActivity extends AppCompatActivity {

  private TextView logText;
  private EditText emailEdit;
  private Button tapButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_rxbinding);
    logText = (TextView) findViewById(R.id.text_log);
    emailEdit = (EditText) findViewById(R.id.edit_email);
    tapButton = (Button) findViewById(R.id.button_tap);

    validateEmail();
    countTap();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
  }

  /**
   * A small example in which we check if user's input email is valid or not
   * and show message in real-time.
   */
  private void validateEmail() {
    RxTextView.textChanges(emailEdit)
        .map(textChange -> isEmail(textChange.toString()))
        .map(isValid -> isValid ? "OK" : "INVALID EMAIL")
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(msg -> logText.setText(msg));
  }

  /**
   * Counts the number of user's click within 2 seconds.
   */
  private void countTap() {

    RxView.clicks(tapButton)
        .buffer(2000, TimeUnit.MILLISECONDS)
        .filter(clicks -> clicks.size() > 0)
        .map(clicks -> clicks.size())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(tapNum -> logText.setText("TAP COUNT: " + String.valueOf(tapNum)));
  }

  /* Helper method to validate */
  private boolean isEmail(String email) {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches();
  }
}
