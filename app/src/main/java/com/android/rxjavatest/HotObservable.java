package com.android.rxjavatest;

import com.android.rxjavatest.data.User;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class HotObservable {

    public ConnectableObservable<User> hotObservable(){
        return Observable.fromIterable(JOperator.mUserList).publish();
    }

    public ConnectableObservable<Long> hotObservableTwo(){
        return Observable.interval(1, TimeUnit.SECONDS).publish();
    }
}
