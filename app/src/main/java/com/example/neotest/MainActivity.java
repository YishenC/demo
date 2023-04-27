package com.example.neotest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;

import io.neow3j.protocol.Neow3j;
import io.neow3j.protocol.Neow3jConfig;
import io.neow3j.protocol.http.HttpService;
import io.neow3j.types.Hash160;
import io.neow3j.wallet.Account;
import io.neow3j.wallet.Wallet;
import io.neow3j.wallet.nep6.NEP6Wallet;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.internal.schedulers.RxThreadFactory;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private EditText RSC;
    private Button RSCLogin;
    private TextView tv;
    private TextView tv2;

    //        L3kCZj6QbFPwbsVhxnB8nUERDy4mhCSrWJew4u5Qh5QmGMfnCTda
    //        Kxs7r2PCERAqpsqaVrPMVnFSpvc1sDf1PB2opMVpBvFkSfKcbdkm
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
        OkHttpClient client = new OkHttpClient.Builder().build();

//        Retrofit retrofit = new Retrofit.Builder()
//                .client(client)
//                .baseUrl("")
//                .addCallAdapterFactory()
//                .addConverterFactory()
//                .build();

        RSCLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("cai", String.valueOf(RSC.getText()));
                //私钥：Kxs7r2PCERAqpsqaVrPMVnFSpvc1sDf1PB2opMVpBvFkSfKcbdkm
                //私钥：
                Account a = Account.fromWIF(String.valueOf(RSC.getText()))
                        .label("MyAccount");

                String address = a.getAddress();
                Log.e("cai",address);
                //公钥：NgS3BKjDsQ5RD1fE87wqyZKFhW5Xy2nmzf
                tv.setText(address);
                Neow3j neow3j = Neow3j.build(new HttpService("http://localhost:40332"));
                Wallet w = Wallet.create();
                Wallet wallet = Wallet.withAccounts(a)
                        .name("MyWallet")
                        .version("1.0");
                NEP6Wallet nep6Wallet = wallet.toNEP6Wallet();
                Log.d("cai",nep6Wallet.toString());

                Log.e("cai",wallet.getName()+"  "+wallet.getAccounts()+"   "+wallet.getDefaultAccount()+"  "+wallet.getScryptParams());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Map<Hash160, BigInteger> nep17Balances = a.getNep17Balances(neow3j);
                            CharSequence charSequence = (CharSequence) nep17Balances.get(a.getScriptHash());
                            tv2.setText(charSequence.toString());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Neow3j neow3j = Neow3j.build(new HttpService("http://localhost:40332"));
        Neow3j obNeo = Neow3j.build(new HttpService("http://localhost:40332"),
                new Neow3jConfig().setNetworkMagic(769));
    }

    private void init() {
    }

    private void initView() {
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        RSC = (EditText) findViewById(R.id.RSC);
        RSCLogin = (Button) findViewById(R.id.RSC_Login);
        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
    }
}