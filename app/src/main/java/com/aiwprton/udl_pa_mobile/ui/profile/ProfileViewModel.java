package com.aiwprton.udl_pa_mobile.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aiwprton.udl_pa_mobile.services.AuthService;
import com.aiwprton.udl_pa_mobile.services.ProfileService;

public class ProfileViewModel extends ViewModel {
//    private final ProfileRepository profileRepository;
    private final MutableLiveData<String> mText;


    public ProfileViewModel() {
//        this.profileRepository = instance;
        mText = new MutableLiveData<>();
        mText.setValue(GetFIO());
    }


    public String GetFIO() {
        return ProfileService.GetFIO();
    }

    public void LogOut() {
        AuthService.LogOut();
//        profileRepository.logout();
    }

    public LiveData<String> getText() {
        return mText;
    }
}