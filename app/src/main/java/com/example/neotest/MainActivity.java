package com.example.neotest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.neow3j.protocol.Neow3j;
import io.neow3j.protocol.Neow3jConfig;
import io.neow3j.protocol.http.HttpService;
import io.neow3j.wallet.Account;
import io.neow3j.wallet.Wallet;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button MonUser;
    private TextView money;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    @Override
    protected void onResume() {
        super.onResume();
        Neow3j neow3j = Neow3j.build(new HttpService("http://localhost:40332"));
        Neow3j obNeo = Neow3j.build(new HttpService("http://localhost:40332"),
                new Neow3jConfig().setNetworkMagic(769));



        Wallet w = Wallet.create();
        Wallet wallet = Wallet.withAccounts(Account.create())
                .name("MyWallet")
                .version("1.0");




    }

    private void init(){
        button = findViewById(R.id.Neo);
        MonUser = findViewById(R.id.MonUser);
        money = findViewById(R.id.money);
    }

}