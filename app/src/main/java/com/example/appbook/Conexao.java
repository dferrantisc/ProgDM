package com.example.appbook;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Conexao {

    private static FirebaseAuth fbAuth;
    private static FirebaseAuth.AuthStateListener authSL;
    private static FirebaseUser fbUser;

    private Conexao() {
    }

    public static FirebaseAuth getFbAuth()
    {
        if (fbAuth == null)
        {
            initFBAuth();
        }

            return fbAuth;
    }

    private static void initFBAuth() {
        fbAuth = FirebaseAuth.getInstance();
        authSL = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= firebaseAuth.getCurrentUser();
                if(user !=null){
                    fbUser = user;
                }
            }
        };

        fbAuth.addAuthStateListener(authSL);
    }

    public static FirebaseUser getFbUser(){
        return fbUser;
    }

    public static void logoutfb(){
        fbAuth.signOut();
    }
}
