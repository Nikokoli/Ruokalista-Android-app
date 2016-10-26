package koli.kaarre.Mobiiliohjelmointi_2016.Activity;

import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.goebl.david.Webb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import koli.kaarre.Mobiiliohjelmointi_2016.R;
import koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JuvenesWrappers.Result;
import koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.JsonCleaner;

// The activity to display a Juvenes restaurant's daily menu.
// Different activities for different franchises due to the drastically different APIs.
public class JuvenesActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juvenes);

        // Get a calendar instance to get current week and day of week for the urls
        Calendar cal = Calendar.getInstance();

        // Fetch the correct kitchen's menu data according to what menu item was chosen in MainActivity
        String name = getIntent().getStringExtra("name");
        if (name.equals("Yliopiston Ravintola")) {
            new JuvenesMenuService().execute("http://www.juvenes.fi/DesktopModules/Talents.LunchMenu/LunchMenuServices.asmx/GetMenuByWeekday?KitchenId=13&MenuTypeId=60&Week=" + cal.get(Calendar.WEEK_OF_YEAR) + "&Weekday=" + cal.get(Calendar.DAY_OF_WEEK) + "&lang=%27fi%27&format=xml");
        }
        else if (name.equals("Fusion Kitchen")){
            new JuvenesMenuService().execute("http://www.juvenes.fi/DesktopModules/Talents.LunchMenu/LunchMenuServices.asmx/GetMenuByWeekday?KitchenId=13&MenuTypeId=3&Week=" + cal.get(Calendar.WEEK_OF_YEAR) + "&Weekday=" + cal.get(Calendar.DAY_OF_WEEK) + "&lang=%27fi%27&format=xml");
        }
        else if (name.equals("Cafe Campus")){
            // Actually the same as Yliopiston Ravintola due to lack of documentation on Juvenes' part
            new JuvenesMenuService().execute("http://www.juvenes.fi/DesktopModules/Talents.LunchMenu/LunchMenuServices.asmx/GetMenuByWeekday?KitchenId=13&MenuTypeId=60&Week=" + cal.get(Calendar.WEEK_OF_YEAR) + "&Weekday=" + cal.get(Calendar.DAY_OF_WEEK) + "&lang=%27fi%27&format=xml");
        }
        else if (name.equals("Cafe Pinni")){
            // Actually the same as Yliopiston Ravintola due to lack of documentation on Juvenes' part
            new JuvenesMenuService().execute("http://www.juvenes.fi/DesktopModules/Talents.LunchMenu/LunchMenuServices.asmx/GetMenuByWeekday?KitchenId=13&MenuTypeId=60&Week=" + cal.get(Calendar.WEEK_OF_YEAR) + "&Weekday=" + cal.get(Calendar.DAY_OF_WEEK) + "&lang=%27fi%27&format=xml");
        }
        else if (name.equals("Newton")){
            new JuvenesMenuService().execute("http://www.juvenes.fi/DesktopModules/Talents.LunchMenu/LunchMenuServices.asmx/GetMenuByWeekday?KitchenId=6&MenuTypeId=60&Week=" + cal.get(Calendar.WEEK_OF_YEAR) + "&Weekday=" + cal.get(Calendar.DAY_OF_WEEK) + "&lang=%27fi%27&format=xml");
        }
        else if (name.equals("Bio + Kliininen")){
            // Actually the same as Yliopiston Ravintola due to lack of documentation on Juvenes' part
            new JuvenesMenuService().execute("http://www.juvenes.fi/DesktopModules/Talents.LunchMenu/LunchMenuServices.asmx/GetMenuByWeekday?KitchenId=13&MenuTypeId=60&Week=" + cal.get(Calendar.WEEK_OF_YEAR) + "&Weekday=" + cal.get(Calendar.DAY_OF_WEEK) + "&lang=%27fi%27&format=xml");
        }

        // Display a placeholder item in the list during Json fetching
        lv = (ListView) findViewById(R.id.listView2);

        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.PlaceholderMenuItem));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list );

        lv.setAdapter(arrayAdapter);
    }

    private class JuvenesMenuService extends AsyncTask<String, Integer, String[]> {
        public String fetchJuvenesData(String url){
            Webb webb = Webb.create();

            // Return found Json data as string
            return webb.get(url).asString().getBody();
        }

        @Override
        protected String[] doInBackground(String... urls) {
            int count = urls.length;
            String[] restaurants = new String[count];
            for (int i = 0; i < count; i++){
                restaurants[i] = fetchJuvenesData(urls[0]);
            }

            // Return an array of Json data strings
            // However, this should only return a single string every time
            return restaurants;
        }

        @Override
        protected void onPostExecute(String[] data){
            // Clean the obtained string
            String dataStr = JsonCleaner.cleanJuvenesJson(data[0]);

            // Map the resulting JSON values to the JuvenesWrapper classes
            ObjectMapper objectMapper = new ObjectMapper();
            Result result = new Result();
            try {
                result = objectMapper.readValue(dataStr, Result.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Parse a readable list of today's menu
            List<String> list = new ArrayList<>();
            list.add(result.getKitchenName() + " tämän päivän ateriat");
            list.add("------ " + result.getMenuTypeName() + " -------");
            for (int i = 0; i < result.getMealOptions().size(); i++){
                for (int j = 0; j < result.getMealOptions().get(i).getMenuItems().size(); j++){
                    list.add(result.getMealOptions().get(i).getMenuItems().get(j).getName());
                }
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, list ){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            };

            // Display the menu
            lv.setAdapter(arrayAdapter);
        }
    }
}