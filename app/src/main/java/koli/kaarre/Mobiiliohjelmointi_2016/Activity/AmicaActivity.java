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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import koli.kaarre.Mobiiliohjelmointi_2016.R;
import koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.AmicaWrappers.MenusForDays;
import koli.kaarre.Mobiiliohjelmointi_2016.Service.JsonUtils.AmicaWrappers.Result;

// The activity to display an Amica restaurant's weekly menu.
// Different activities for different franchises due to the drastically different APIs.
public class AmicaActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amica);

        // Get current date in yyyy-mm-dd format
        Calendar cal = Calendar.getInstance();
        Date currentDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(currentDate);

        // Fetch the correct kitchen's menu data according to what menu item was chosen in MainActivity
        String name = getIntent().getStringExtra("name");
        if (name.equals("Minerva")){
            String url = "http://www.amica.fi/modules/json/json/Index?costNumber=0815&language=fi&firstDay=" + dateStr;
            new AmicaMenuService().execute(url);
        }
        else if (name.equals("Reaktori")){
            String url = "http://www.amica.fi/modules/json/json/Index?costNumber=0812&language=fi&firstDay=" + dateStr;
            new AmicaMenuService().execute(url);
        }
        else if (name.equals("Pirteria")){
            String url = "http://www.amica.fi/modules/json/json/Index?costNumber=0823&language=fi&firstDay=" + dateStr;
            new AmicaMenuService().execute(url);
        }

        lv = (ListView) findViewById(R.id.listView);

        List<String> list = new ArrayList<String>();
        list.add(getString(R.string.PlaceholderMenuItem));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list );

        lv.setAdapter(arrayAdapter);
    }

    private class AmicaMenuService extends AsyncTask<String, Integer, String[]> {
        public String fetchAmicaData(String url){
            Webb webb = Webb.create();

            // Return found Json data as string
            return webb.get(url).asString().getBody();
        }

        @Override
        protected String[] doInBackground(String... urls) {
            int count = urls.length;
            String[] restaurants = new String[count];
            for (int i = 0; i < count; i++){
                restaurants[i] = fetchAmicaData(urls[0]);
            }

            // Return an array of Json data strings
            // However, this should only return a single string every time
            return restaurants;
        }

        @Override
        protected void onPostExecute(String[] data){
            // Map the resulting JSON values to the AmicaWrapper classes
            List<String> arrayList = new ArrayList<String>();
            ObjectMapper objectMapper = new ObjectMapper();
            Result result = new Result();
            try {
                result = objectMapper.readValue(data[0], Result.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            List<MenusForDays> menus = result.getMenusForDays();

            // Parse a readable list of this week's menus
            for (int i = 0; i < menus.size(); i++){
                if (i == 0){
                    arrayList.add("Loppuviikon ruokalistat (" + result.getRestaurantName() + ")");
                    arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                }
                else if ( i == 1) arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                else if ( i == 2) arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                else if ( i == 3) arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                else if ( i == 4) arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                else if ( i == 5) arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                else if ( i == 6) arrayList.add("Päivän " + menus.get(i).getDate() + " ruokalistat");
                for (int j = 0; j < menus.get(i).getSetMenus().size(); j++){
                    arrayList.add("------ " + menus.get(i).getSetMenus().get(j).getName() + " ------");
                    for (int k = 0; k < menus.get(i).getSetMenus().get(j).getComponents().size(); k++){
                        arrayList.add(menus.get(i).getSetMenus().get(j).getComponents().get(k));
                    }
                    if (menus.get(i).getSetMenus().get(j).getComponents().size() == 0){
                        arrayList.add(getString(R.string.NoMenus));
                    }
                }
            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList ){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            };

            // Display the menus
            lv.setAdapter(arrayAdapter);
        }
    }
}