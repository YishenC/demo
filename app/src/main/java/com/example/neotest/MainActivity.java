package com.example.neotest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.neow3j.protocol.Neow3j;
import io.neow3j.protocol.Neow3jConfig;
import io.neow3j.protocol.http.HttpService;
import io.neow3j.wallet.Account;
import io.neow3j.wallet.Wallet;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private EditText RSC;
    private Button RSCLogin;
    private TextView tv;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();

        RSCLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("cai", String.valueOf(RSC.getText()));
                //私钥：Kxs7r2PCERAqpsqaVrPMVnFSpvc1sDf1PB2opMVpBvFkSfKcbdkm
                Account a = Account.fromWIF(String.valueOf(RSC.getText()))
                        .label("MyAccount");

                String address = a.getAddress();
                Log.e("cai",address);
                //公钥：NgS3BKjDsQ5RD1fE87wqyZKFhW5Xy2nmzf
                tv.setText(address);

            }
        });
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

    private void init() {

//        L3kCZj6QbFPwbsVhxnB8nUERDy4mhCSrWJew4u5Qh5QmGMfnCTda
//        Kxs7r2PCERAqpsqaVrPMVnFSpvc1sDf1PB2opMVpBvFkSfKcbdkm
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        RSC = (EditText) findViewById(R.id.RSC);
        RSCLogin = (Button) findViewById(R.id.RSC_Login);
        tv = (TextView) findViewById(R.id.tv);
    }
}