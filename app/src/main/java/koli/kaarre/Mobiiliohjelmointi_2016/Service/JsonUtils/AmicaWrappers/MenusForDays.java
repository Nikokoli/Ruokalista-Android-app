package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.AmicaWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Inner wrapper class for the Result class
public class MenusForDays {
    String Date;
    String LunchTime;
    List<SetMenus> SetMenus;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getLunchTime() {
        return LunchTime;
    }

    public void setLunchTime(String lunchTime) {
        LunchTime = lunchTime;
    }

    public List<SetMenus> getSetMenus() {
        return SetMenus;
    }

    public void setSetMenus(List<SetMenus> setMenus) {
        this.SetMenus = setMenus;
    }


}
