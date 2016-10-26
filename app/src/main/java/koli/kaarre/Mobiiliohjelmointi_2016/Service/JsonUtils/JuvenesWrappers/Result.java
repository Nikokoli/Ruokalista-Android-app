package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Wrapper class for the resulting Json data we get from Juvenes's API
public class Result {
    String AdditionalName;
    String KitchenName;
    List<MealOptions> MealOptions;
    String MenuId;
    String MenuTypeId;
    String MenuTypeName;
    String Name;
    String Week;

    public String getWeekday() {
        return Weekday;
    }

    public void setWeekday(String weekday) {
        Weekday = weekday;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
        Week = week;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMenuTypeName() {
        return MenuTypeName;
    }

    public void setMenuTypeName(String menuTypeName) {
        MenuTypeName = menuTypeName;
    }

    public String getMenuTypeId() {
        return MenuTypeId;
    }

    public void setMenuTypeId(String menuTypeId) {
        MenuTypeId = menuTypeId;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public List<MealOptions> getMealOptions() {
        return MealOptions;
    }

    public void setMealOptions(List<MealOptions> mealOptions) {
        MealOptions = mealOptions;
    }

    public String getKitchenName() {
        return KitchenName;
    }

    public void setKitchenName(String kitchenName) {
        KitchenName = kitchenName;
    }

    public String getAdditionalName() {
        return AdditionalName;
    }

    public void setAdditionalName(String additionalName) {
        AdditionalName = additionalName;
    }

    String Weekday;
}
