package com.android.rxjavatest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.rxjavatest.data.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private String greeting = "Hello From RxJava";
    private Observable<String> myObservable;
    private TextView tvMain;
    private String TAG = "TAG";
    private JOperator mJOperator = new JOperator();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tv_main);



        //mJOperator.fromIterableOperator();

        /*mJOperator.rangeOperator().subscribe(new Observer<Integer>() {
                                      @Override
                                      public void onSubscribe(@NonNull Disposable d) {
                                          Log.e(TAG,"onComplete");
                                      }

                                      @Override
                                      public void onNext(@NonNull Integer integer) {
                                          Log.e(TAG,integer.toString());
                                      }

                                      @Override
                                      public void onError(@NonNull Throwable e) {
                                          Log.e(TAG,"onError");
                                      }

                                      @Override
                                      public void onComplete() {
                                          Log.e(TAG,"onComplete");
                                      }
                                  }

        );*/

        /*mJOperator.repeatOperator().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onComplete");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG,integer.toString());
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }

        });*/

        /*mJOperator.intervalOperator().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Long Long) {
                Log.e(TAG,Long.toString());
                getLocation();
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/
        /*mJOperator.timerOperator().subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Long Long) {
                Log.e(TAG,Long.toString());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/

        /*mJOperator.createOperator().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG,integer.toString());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/

        mJOperator.filterOperator().filter(new Predicate<User>() {
            @Override
            public boolean test(User user) throws Throwable {

                if (user.age <= 18){
                    return true;
                }

                return false;
            }
        }).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,"next "+user.name);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    void getLocation(){
        Log.e(TAG, "Latitude: 102.0303 Longitude : 1.2355");
    }

}
