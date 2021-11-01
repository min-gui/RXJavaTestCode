package com.android.rxjavatest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.rxjavatest.data.User;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class MainActivity extends AppCompatActivity {

    private String greeting = "Hello From RxJava";
    private Observable<String> myObservable;
    private TextView tvMain;
    private String TAG = "TAG";
    private JOperator mJOperator = new JOperator();
    private ObservableTest mObservableTest = new ObservableTest();

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

        /*mJOperator.filterOperator().filter(new Predicate<User>() {
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
        });*/

        /* mJOperator.lastOperator()
                //.last(new User(1,"demo1",15))
                .lastOrError()
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull User user) {
                        Log.e(TAG,user.name);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });*/

        /*mJOperator.distinctOperator().distinct(new Function<User, Object>() {
            @Override
            public Object apply(User user) throws Throwable {

                return user.name;
            }
        }).subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,user.name);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

        /*mJOperator.skipOperator()
                .skip(100,TimeUnit.MICROSECONDS)
                .subscribe(new Observer<User>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe");
            }

            @Override
            public void onNext(@NonNull User user) {
                Log.e(TAG,user.name);
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
        /*mJOperator.bufferOperator()
                .buffer(3)
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull List<User> users) {
                        Log.e(TAG,users.size()+"");
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

        /*mJOperator.mapOperator()
                .map(new Function<User, Object>() {

                    @Override
                    public Object apply(User user) throws Throwable {
                        return user.age * 2;
                    }
                })
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Object o) {
                        Log.e(TAG,o.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/

        /*mObservableTest.createObservable().subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG,"onSubscribe ");
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.e(TAG,integer+" ");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG,"onError+");
            }

            @Override
            public void onComplete() {
                Log.e(TAG,"onComplete");
            }
        });*/
        /*mObservableTest.createSingleObservable().
                subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Integer integer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });*/

        //mObservableTest.createMaybeObservable().subscribe(mObservableTest.observerMayObservable());
        //mObservableTest.createCompletableObservable().subscribe(mObservableTest.observerCompletableObservable());
        mObservableTest.createFlowableObservableT2()
                .toFlowable(BackpressureStrategy.LATEST)
                .observeOn(Schedulers.io(),false, 2)

                .subscribe(new DisposableSubscriber<Integer>() {
                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG,integer.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG,t.toString() );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });
    }

    void getLocation() {
        Log.e(TAG, "Latitude: 102.0303 Longitude : 1.2355");
    }

}
