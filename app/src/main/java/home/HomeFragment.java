package home;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.app.databinding.FragmentHomeBinding;
import java.util.ArrayList;
import java.util.List;
import model.adapter.HomeAdapter;

import model.TaskModel;
import room.MyApp;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeAdapter adapter;

    private List<TaskModel> list= new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        intRecycler();
        //getFrom();
        getNot();
        getSave();
        return binding.getRoot();

    }

//    private void getFrom() {
//        MyApp.getInstance().noteDao().getAll().observe(requireActivity(), new Observer<List<TaskModel>>() {
//            @Override
//            public void onChanged(List<TaskModel> room) {
//             adapter.setList(room);
//             list = room;
//            }
//        });
   // }

    private void getNot() {
        binding.searchHome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }

        });
    }

    private void filter(String toString) {
        ArrayList<TaskModel> filList= new ArrayList<>();
        for (TaskModel item: list) {
            if (item.getTitle().toLowerCase().contains(toString.toLowerCase())){
                filList.add(item);
          }
       }
        adapter.filterList(filList);
   }

    private void getSave() {
           getParentFragmentManager().setFragmentResultListener("title",getViewLifecycleOwner(),((requestKey, result) -> {
            TaskModel model = (TaskModel) result.getSerializable("not");
            list.add(model);
        }));
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HomeAdapter();

    }

    private void intRecycler() {
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}