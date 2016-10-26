package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Inner wrapper class for the MenuItems class
public class NutritiveValues {
    String DailyAmount;
    String Name;
    List<Units> Units;

    public String getDailyAmount() {
        return DailyAmount;
    }

    public void setDailyAmount(String dailyAmount) {
        DailyAmount = dailyAmount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Units> getUnits() {
        return Units;
    }

    public void setUnits(List<Units> units) {
        Units = units;
    }
}
