package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Inner wrapper class for the Result class
public class MealOptions {
    String AlsoAvailable;
    String ExternalGroupId;
    String ExtraItems;
    String ForceMajeure;
    String MealOptionId;
    String MenuDate;
    String Name;
    String Name_EN;
    String Name_FI;
    String Price;
    List<MenuItems> MenuItems;

    public String getAlsoAvailable() {
        return AlsoAvailable;
    }

    public void setAlsoAvailable(String alsoAvailable) {
        AlsoAvailable = alsoAvailable;
    }

    public String getExternalGroupId() {
        return ExternalGroupId;
    }

    public void setExternalGroupId(String externalGroupId) {
        ExternalGroupId = externalGroupId;
    }

    public String getExtraItems() {
        return ExtraItems;
    }

    public void setExtraItems(String extraItems) {
        ExtraItems = extraItems;
    }

    public String getForceMajeure() {
        return ForceMajeure;
    }

    public void setForceMajeure(String forceMajeure) {
        ForceMajeure = forceMajeure;
    }

    public String getMealOptionId() {
        return MealOptionId;
    }

    public void setMealOptionId(String mealOptionId) {
        MealOptionId = mealOptionId;
    }

    public String getMenuDate() {
        return MenuDate;
    }

    public void setMenuDate(String menuDate) {
        MenuDate = menuDate;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName_EN() {
        return Name_EN;
    }

    public void setName_EN(String name_EN) {
        Name_EN = name_EN;
    }

    public String getName_FI() {
        return Name_FI;
    }

    public void setName_FI(String name_FI) {
        Name_FI = name_FI;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public List<koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers.MenuItems> getMenuItems() {
        return MenuItems;
    }

    public void setMenuItems(List<koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers.MenuItems> menuItems) {
        MenuItems = menuItems;
    }
}
