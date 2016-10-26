package koli.kaarre.Mobiiliohjelmointi_2016.Fragments;

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

import koli.kaarre.Mobiiliohjelmointi_2016.R;

/**
 * Created by Arttu on 4.5.2016.
 */
public class FavoriteFragment extends ListFragment implements AdapterView.OnItemClickListener{

    private String name;
    private int page;

    public static FavoriteFragment newInstance (int page, String name){
        FavoriteFragment favorite = new FavoriteFragment();
        Bundle args = new Bundle();
        args.putInt ("pageInt", page);
        args.putString("nameString", name);
        favorite.setArguments(args);
        return favorite;
    }

    @Override
    public void onCreate (Bundle SavedInstance){
        super.onCreate(SavedInstance);
        page = getArguments().getInt("pageInt", 0);
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
        your_array_list.add("fav1");
        your_array_list.add("fav2");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, your_array_list );

        setListAdapter(arrayAdapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }
}
