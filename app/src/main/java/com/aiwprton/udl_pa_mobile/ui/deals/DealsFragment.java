package com.aiwprton.udl_pa_mobile.ui.deals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.aiwprton.udl_pa_mobile.databinding.FragmentDealsBinding;
import com.aiwprton.udl_pa_mobile.models.DealsModel;

import java.util.List;

public class DealsFragment extends Fragment {
    private FragmentDealsBinding binding;
    private static DealsViewModel dealsVM;
    public TextView textDeals;
//    public TextView dataDeals;

    public static DealsFragment newInstance() {
        return new DealsFragment();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        dealsVM = new ViewModelProvider(this).get(DealsViewModel.class);
        binding = FragmentDealsBinding.inflate(inflater, container, false);

        textDeals = binding.textDeals;
//        dataDeals = binding.dataDeals;

        dealsVM.getText().observe(getViewLifecycleOwner(), textDeals::setText);
//        dealsVM.getDeals().observe(getViewLifecycleOwner(), dataDeals::setText);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//    @BindingAdapter("deals_data")
//    public static List<DealsModel> loadDeals(ListView listView) {
//        return dealsVM.getDeals().getValue();
//    }
}