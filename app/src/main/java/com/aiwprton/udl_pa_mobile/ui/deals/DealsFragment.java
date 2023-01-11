package com.aiwprton.udl_pa_mobile.ui.deals;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import com.aiwprton.udl_pa_mobile.databinding.FragmentDealsBinding;
import com.aiwprton.udl_pa_mobile.models.Deal;
import com.aiwprton.udl_pa_mobile.models.DealsModel;

import java.util.ArrayList;
import java.util.List;

public class DealsFragment extends ListFragment {
    private FragmentDealsBinding binding;
    private static DealsViewModel dealsVM;

    public static DealsFragment newInstance() {
        return new DealsFragment();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        dealsVM = new ViewModelProvider(this).get(DealsViewModel.class);
        binding = FragmentDealsBinding.inflate(inflater, container, false);

        ArrayList<DealsModel> ld = (ArrayList<DealsModel>)loadDeals();
        ArrayList<ArrayList<String>> lds = new ArrayList<>();
        ArrayList<String> _cdt = new ArrayList<>();
        ArrayList<Deal> deals = new ArrayList<>();

        ld.forEach((DealsModel d) -> {
            if (d.Deals.length == 0) return;
            ArrayList<String> cdt = new ArrayList<>();

            for (Deal deal : d.Deals) {
                cdt.add(deal.ID);
                deals.add(deal);

//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd", Locale.GERMANY);
//                LocalDateTime dateTime = LocalDateTime.parse(deal.BEGINDATE);
//
//                String date_s = formatter.format(dateTime);
                String s = String.format("№ %s (%s)", deal.ID, deal.BEGINDATE);// date_s);
                _cdt.add(s);
            }
            lds.add(cdt);
        });

        ListView dn = binding.list.findViewById(android.R.id.list);
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, _cdt);
//        DealsListAdapter adapter = new DealsListAdapter(getContext(), deals);
        dn.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //    @BindingAdapter("deals_data")
    private static List<DealsModel> loadDeals() {
        return dealsVM.getDeals().getValue();
    }
}