package app.test.designpattern.Observer;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.Observer
 * @class describe :
 * @time 2018-02-08 9:56
 */
public interface Observer<T> {
    void onUpdate(Observable<T> observable, T data);
}
