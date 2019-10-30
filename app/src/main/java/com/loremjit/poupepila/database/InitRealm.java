package com.loremjit.poupepila.database;

import android.app.Application;
import io.realm.Realm;

public class InitRealm extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        //Realm.deleteRealm(Realm.getDefaultConfiguration());
    }
}
