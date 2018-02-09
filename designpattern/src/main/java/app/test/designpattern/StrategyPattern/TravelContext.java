package app.test.designpattern.StrategyPattern;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.StrategyPattern
 * @class describe :
 * @time 2018-02-08 17:00
 */
public class TravelContext {
    Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void travel() {
        if (strategy != null) {
            strategy.travel();
        }
    }
}
