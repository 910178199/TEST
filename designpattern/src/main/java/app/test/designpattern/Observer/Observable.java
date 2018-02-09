package app.test.designpattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.Observer
 * @class describe :
 * @time 2018-02-08 9:53
 */
public class Observable<T> {
    List<Observer<T>> mObservers = new ArrayList<Observer<T>>();

    public void register(Observer<T> tObserver) {
        if (tObserver == null) {
            throw new NullPointerException("tObserver==null");
        }
        synchronized (this) {
            if (!mObservers.contains(tObserver)) {
                mObservers.add(tObserver);
            }
        }
    }

    public synchronized void unregister(Observer<T> tObserver) {
        mObservers.remove(tObserver);
    }

    public void notifyObservers(T data) {
        for (Observer<T> observer : mObservers) {
            observer.onUpdate(this, data);
        }
    }

}
