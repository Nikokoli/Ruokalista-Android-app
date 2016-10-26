package koli.kaarre.Mobiiliohjelmointi_2016.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import koli.kaarre.Mobiiliohjelmointi_2016.Activity.AmicaActivity;
import koli.kaarre.Mobiiliohjelmointi_2016.Activity.JuvenesActivity;
import koli.kaarre.Mobiiliohjelmointi_2016.R;

/**
 * Created by Arttu on 4.5.2016.
 */
// Fragment page for the Tay tab
public class TayFragment extends ListFragment implements AdapterView.OnItemClickListener{

    private String name;
    private int page;

    public static TayFragment newInstance (int page, String name){
        TayFragment tay = new TayFragment();
        Bundle args = new Bundle();
        args.putInt ("pageInt", page);
        args.putString("nameString", name);
        tay.setArguments(args);
        return tay;
    }

    @Override
    public void onCreate (Bundle SavedInstance){
        super.onCreate(SavedInstance);
        page = getArguments().getInt("pageInt", 1);
        name = getArguments().getString("nameString");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tay_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Minerva");
        your_array_list.add("Yliopiston Ravintola");
        your_array_list.add("Fusion Kitchen (Yliopiston Ravintola)");
        your_array_list.add("Cafe Campus");
        your_array_list.add("Cafe Pinni");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, your_array_list );

        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        if (position == 0){
            Intent intent = new Intent(getActivity(), AmicaActivity.class);
            intent.putExtra("name", "Minerva");
            startActivity(intent);
        }
        else if (position == 1){
            Intent intent = new Intent(getActivity(), JuvenesActivity.class);
            intent.putExtra("name", "Yliopiston Ravintola");
            startActivity(intent);
        }
        else if (position == 2){
            Intent intent = new Intent(getActivity(), JuvenesActivity.class);
            intent.putExtra("name", "Fusion Kitchen");
            startActivity(intent);
        }
        else if (position == 3){
            Intent intent = new Intent(getActivity(), JuvenesActivity.class);
            intent.putExtra("name", "Cafe Campus");
            startActivity(intent);
        }
        else if (position == 4){
            Intent intent = new Intent(getActivity(), JuvenesActivity.class);
            intent.putExtra("name", "Cafe Pinni");
            startActivity(intent);
        }
    }
}
