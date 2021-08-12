package from;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.R;
import com.example.app.databinding.FragmentFromBinding;

import java.util.ArrayList;
import java.util.List;

import model.TaskModel;
import model.adapter.HomeAdapter;
import room.MyApp;


public class FromFragment extends Fragment {
    private FragmentFromBinding binding;
    private TaskModel taskModel;
    private HomeAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFromBinding.inflate(inflater, container, false);
        save();
        return binding.getRoot();
    }

    private void save() {
        binding.etText1.setOnClickListener(v -> {
            String tit = binding.etText1.getText().toString();
            taskModel = new TaskModel(tit);
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("not", taskModel);
//            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
//            navController.navigateUp();
//            getParentFragmentManager().setFragmentResult("title", bundle);

        });
    }


}