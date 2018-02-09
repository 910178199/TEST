package app.test.designpattern.Observer;

/**
 * @author think
 * @name TEST
 * @class name：app.test.designpattern.Observer
 * @class describe :
 * @time 2018-02-08 9:52
 */
public class WeatherBean {
    private String description;

    public WeatherBean(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "description='" + description + '\'' +
                '}';
    }
}
