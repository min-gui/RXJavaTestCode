package com.android.rxjavatest;

import android.util.Log;

import com.android.rxjavatest.data.User;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ColdObservable {

    private String TAG = getClass().getSimpleName();
    public Observable coldObservable(){
        return Observable.fromIterable(JOperator.mUserList);
    }

    public Observer<User> coldObserver(){
        return new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,"onNext"+user.name);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError " + e);
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        };
    }
}
