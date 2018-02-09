package app.test.designpattern.StrategyPattern;

import android.util.Log;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.StrategyPattern
 * @class describe :
 * @time 2018-02-08 16:58
 */
public class PlaneStrategy implements Strategy {
    @Override
    public void travel() {
        Log.d("PlaneStrategy", "plane");
    }
}
