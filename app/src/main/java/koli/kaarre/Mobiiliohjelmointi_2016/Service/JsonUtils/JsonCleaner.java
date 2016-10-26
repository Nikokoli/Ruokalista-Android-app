package koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils;

/**
 * Created by Arttu on 15.5.2016.
 */
public class JsonCleaner {

    // Juvenes Json data is actually returned in XML, this method should remove all xml tags
    // so we'll end up with raw Json
    static public String cleanJuvenesJson(String str){
        String temp = str;
        temp = temp.replace("<string xmlns=\"Talents.Modules.LunchMenu\">", "");
        temp = temp.replace("</string>", "");
        temp = temp.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");
        return temp;
    }
}
