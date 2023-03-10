package com.aiwprton.udl_pa_mobile.ui.deals;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aiwprton.udl_pa_mobile.models.DealsModel;
import com.aiwprton.udl_pa_mobile.services.DealsService;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DealsViewModel extends ViewModel {
    private final MutableLiveData<List<DealsModel>> deals;


    public DealsViewModel() throws IOException, ExecutionException, InterruptedException {
        deals = new MutableLiveData<>();
        deals.setValue(GetData());
    }


    public LiveData<List<DealsModel>> getDeals() {
        return deals;
    }

    private List<DealsModel> GetData() throws IOException, ExecutionException, InterruptedException {
        return DealsService.GetDeals();
    }
}