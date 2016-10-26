package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Inner wrapper class for the MealOptions class
public class MenuItems {
    String Diets;
    String DisplayStyle;
    String HideInPrint;
    String Ingredients;
    String MenuItemID;
    String Name;
    String Name_EN;
    String Name_FI;
    String OrderNumber;
    String Price;
    List<NutritiveValues> NutritiveValues;

    public String getDiets() {
        return Diets;
    }

    public void setDiets(String diets) {
        Diets = diets;
    }

    public String getDisplayStyle() {
        return DisplayStyle;
    }

    public void setDisplayStyle(String displayStyle) {
        DisplayStyle = displayStyle;
    }

    public String getHideInPrint() {
        return HideInPrint;
    }

    public void setHideInPrint(String hideInPrint) {
        HideInPrint = hideInPrint;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public void setIngredients(String ingredients) {
        Ingredients = ingredients;
    }

    public String getMenuItemID() {
        return MenuItemID;
    }

    public void setMenuItemID(String menuItemID) {
        MenuItemID = menuItemID;
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

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public List<NutritiveValues> getNutritiveValues() {
        return NutritiveValues;
    }

    public void setNutritiveValues(List<NutritiveValues> nutritiveValues) {
        NutritiveValues = nutritiveValues;
    }
}
