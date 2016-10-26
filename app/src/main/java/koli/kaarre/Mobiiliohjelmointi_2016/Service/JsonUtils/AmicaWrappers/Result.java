package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.AmicaWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Wrapper class for the resulting Json data we get from Amica's API
public class Result {
    String RestaurantName;
    String RestaurantUrl;
    String PriceHeader;
    String Footer;
    List<MenusForDays> MenusForDays;
    String ErrorText;

    public String getErrorText() {
        return ErrorText;
    }

    public void setErrorText(String errorText) {
        ErrorText = errorText;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        RestaurantName = restaurantName;
    }

    public String getRestaurantUrl() {
        return RestaurantUrl;
    }

    public void setRestaurantUrl(String restaurantUrl) {
        RestaurantUrl = restaurantUrl;
    }

    public String getPriceHeader() {
        return PriceHeader;
    }

    public void setPriceHeader(String priceHeader) {
        PriceHeader = priceHeader;
    }

    public String getFooter() {
        return Footer;
    }

    public void setFooter(String footer) {
        Footer = footer;
    }

    public List<MenusForDays> getMenusForDays() {
        return MenusForDays;
    }

    public void setMenusForDays(List<MenusForDays> menusForDays) {
        this.MenusForDays = menusForDays;
    }


}
