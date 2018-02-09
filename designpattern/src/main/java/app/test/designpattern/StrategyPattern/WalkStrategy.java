package app.test.designpattern.StrategyPattern;

import android.util.Log;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.StrategyPattern
 * @class describe :
 * @time 2018-02-08 16:57
 */
public class WalkStrategy implements Strategy {
    @Override
    public void travel() {
        Log.d("walkstrategy", "walk");
    }
}
