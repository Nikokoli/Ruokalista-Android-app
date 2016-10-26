package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.AmicaWrappers;

import java.util.List;

/**
 * Created by Arttu on 15.5.2016.
 */
// Inner wrapper class for the MenusForDays class
public class SetMenus {
    String SortOrder;
    String Name;
    String Price;
    List<String> Components;

    public List<String> getComponents() {
        return Components;
    }

    public void setComponents(List<String> components) {
        Components = components;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSortOrder() {
        return SortOrder;
    }

    public void setSortOrder(String sortOrder) {
        SortOrder = sortOrder;
    }


}
