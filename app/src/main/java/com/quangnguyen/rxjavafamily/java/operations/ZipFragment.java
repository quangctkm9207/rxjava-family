package com.quangnguyen.rxjavafamily.java.operations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.quangnguyen.rxjavafamily.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author Quang Nguyen.
 */

public class ZipFragment extends Fragment {
  private TextView logText;

  public ZipFragment() {
    // Required empty public constructor
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_rxjava_zip, container, false);
    logText = (TextView) rootView.findViewById(R.id.text_log);
    return rootView;
  }

  @Override public void onResume() {
    super.onResume();
    demoZip();
  }

  /**
   * Demonstrate 'Zip' operation.
   * Filter - combine the emissions of multiple Observables together via a specified function and emit single items
   * for each combination based on the results of this function.
   * In this case, we combine an Integer Observable (observable1) with a Character Observable (observable2)
   * into a String Observable.
   */
  private void demoZip() {
    observable1.zipWith(observable2, (item1, item2) -> item1 + "" + item2).subscribe(observer);
  }

  private Observable<Integer> observable1 = Observable.just(1, 2, 3);
  private Observable<Character> observable2 = Observable.just('a', 'b', 'c');

  private Observer<String> observer = new Observer<String>() {
    @Override public void onSubscribe(Disposable d) {
      logText.append("\n onSubscribe.");
    }

    @Override public void onNext(String string) {
      logText.append("\n onNext: " + string);
    }

    @Override public void onError(Throwable e) {
      logText.append("\n onError: " + e.getLocalizedMessage());
    }

    @Override public void onComplete() {
      logText.append("\n onComplete.");
    }
  };
}
