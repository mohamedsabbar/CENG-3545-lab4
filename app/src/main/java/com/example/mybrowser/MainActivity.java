package com.example.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    EditText txtAdress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGo = findViewById(R.id.btnGO);;

        txtAdress = findViewById(R.id.txtAddress);
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());

       if((getIntent()!= null)&&(getIntent().getData()!=null)){
           txtAdress.setText( getIntent().getData().toString());
            webView.loadUrl( getIntent().getData().toString());
        }
        //btnGo

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("https://" + txtAdress.getText());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }
}