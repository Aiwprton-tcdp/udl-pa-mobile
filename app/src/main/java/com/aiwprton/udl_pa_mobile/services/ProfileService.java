package com.aiwprton.udl_pa_mobile.services;

import static com.aiwprton.udl_pa_mobile.App.pref;

public class ProfileService {
    public static String GetFIO() {
        String name = pref.getString("name", "");
        String surname = pref.getString("surname", "");
        String patronymic = pref.getString("patronymic", "");

        return String.format("%s %s %s", surname, name, patronymic);
    }
}
