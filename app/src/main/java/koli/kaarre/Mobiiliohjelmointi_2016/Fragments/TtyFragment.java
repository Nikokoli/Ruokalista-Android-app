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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import koli.kaarre.Mobiiliohjelmointi_2016.Activity.AmicaActivity;
import koli.kaarre.Mobiiliohjelmointi_2016.Activity.JuvenesActivity;
import koli.kaarre.Mobiiliohjelmointi_2016.R;

/**
 * Created by Arttu on 4.5.2016.
 */
// Fragment page for the TTY tab
public class TtyFragment extends ListFragment implements AdapterView.OnItemClickListener {

    private String name;
    private int page;

    public static TtyFragment newInstance (int page, String name){
        TtyFragment tty = new TtyFragment();
        Bundle args = new Bundle();
        args.putInt ("pageInt", page);
        args.putString("nameString", name);
        tty.setArguments(args);
        return tty;
    }

    @Override
    public void onCreate (Bundle SavedInstance){
        super.onCreate(SavedInstance);
        page = getArguments().getInt("pageInt", 3);
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
        your_array_list.add("Reaktori");
        your_array_list.add("Newton");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, your_array_list );

        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            Intent intent = new Intent(getActivity(), AmicaActivity.class);
            intent.putExtra("name", "Reaktori");
            startActivity(intent);
        }
        else if (position == 1){
            Intent intent = new Intent(getActivity(), JuvenesActivity.class);
            intent.putExtra("name", "Newton");
            startActivity(intent);
        }
    }
}
