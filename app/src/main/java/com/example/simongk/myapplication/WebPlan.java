package com.example.simongk.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* Aktywnosc planu Online wyswietlanego w WebView
*
 */
public class WebPlan extends Activity {

    private WebView mWebView;
    public String myPlanUrl;
    Activity activity;
    private ProgressDialog progressDialog;


    /**
    * @param suffix koncowka adresu planu
    * ustawia URL planu i uruchamia go w webview
    * podczas ladowania strony pokazywane jest ProgressDialog
    * */
    public void setPlan(String suffix) {

        String url1 = "http://www.mech.pk.edu.pl/~podzial/stacjonarne/html/plany/";
        String newUrl = url1.concat(suffix);
        setContentView(R.layout.webplan);
        mWebView = (WebView) findViewById(R.id.activity_main2_webview);
        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setLoadWithOverviewMode(true);
        ws.setUseWideViewPort(true);
        ws.setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressDialog.dismiss();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView wv, String url) {
                progressDialog.show();
                wv.loadUrl(url);
                return true;
            }
        });

        mWebView.loadUrl(newUrl);
    }

    public void progress() {
        progressDialog = ProgressDialog.show(activity, "Ładowanie", "Proszę czekać...", true);
        progressDialog.setCancelable(true);

    }

    /**
    * Obsluga listy grup i przypisywanie im adresow URL planow
    * */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webplan);
        Intent i = getIntent();

        activity = this;

        final Dialog dialog = new Dialog(this);
        dialog.setCancelable(true);
        dialog.setTitle("Wybór grupy");
        dialog.setContentView(R.layout.listagrup);
        ListView lvItems = (ListView) dialog.findViewById(R.id.lvGroups);
        List<String> items = new ArrayList<String>();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        String[] tempList = new String[]{"11A1", "11A2", "11B1", "11B2", "11E1", "11E2", "11E3",
                "11K1", "11K2", "11L1", "11L2", "11M1", "11M2", "11M3", "11M4", "11P1",
                "11T1", "11T2", "11T3", "11W1", "11Z1", "11Z2", "11Z3",

                "12A1", "12A2", "12A3",
                "12B1", "12B2", "12E1", "12E2", "12E3", "12K1", "12K2", "12L1", "12L2", "12M1", "12M2",
                "12M3", "12M4", "12M5", "12P1", "12T1", "12T2", "12T3", "12Z1", "12Z2",

                "13A1", "13A4",
                "13A5", "13A6", "13B2", "13B3", "13E1", "13E6", "13E8", "13K4", "13K5", "13L1", "13L3",
                "13M1", "13M2", "13M3", "13M4", "13M9", "53M1", "13P1", "13P2", "13T1", "13T2", "13T4", "13T7",
                "13W1", "13W2", "13Z2", "13Z6", "13Z7"};

        items.addAll(Arrays.asList(tempList));
        itemsAdapter.addAll(items);


        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getItemAtPosition(position).toString()) {
                    case "11A1":
                        setPlan("o1.html");
                        break;
                    case "11A2":
                        setPlan("o2.html");
                        break;
                    case "11B1":
                        setPlan("o4.html");
                        break;
                    case "11B2":
                        setPlan("o5.html");
                        break;
                    case "11E1":
                        setPlan("o6.html");
                        break;
                    case "11E2":
                        setPlan("o7.html");
                        break;
                    case "11E3":
                        setPlan("o8.html");
                        break;
                    case "11K1":
                        setPlan("o9.html");
                        break;
                    case "11K2":
                        setPlan("o10.html");
                        break;
                    case "11L1":
                        setPlan("o11.html");
                        break;
                    case "11L2":
                        setPlan("o12.html");
                        break;
                    case "11M1":
                        setPlan("o13.html");
                        break;
                    case "11M2":
                        setPlan("o14.html");
                        break;
                    case "11M3":
                        setPlan("o15.html");
                        break;
                    case "11M4":
                        setPlan("o16.html");
                        break;
                    case "11P1":
                        setPlan("o18.html");
                        break;
                    case "11T1":
                        setPlan("o19.html");
                        break;
                    case "11T2":
                        setPlan("o20.html");
                        break;
                    case "11T3":
                        setPlan("o21.html");
                        break;
                    case "11W1":
                        setPlan("o22.html");
                        break;
                    case "11Z1":
                        setPlan("o23.html");
                        break;
                    case "11Z2":
                        setPlan("o24.html");
                        break;
                    case "11Z3":
                        setPlan("o25.html");
                        break;

                    case "12A1":
                        setPlan("o26.html");
                        break;
                    case "12A2":
                        setPlan("o27.html");
                        break;
                    case "12A3":
                        setPlan("o28.html");
                        break;
                    case "12B1":
                        setPlan("o29.html");
                        break;
                    case "12B2":
                        setPlan("o30.html");
                        break;
                    case "12E1":
                        setPlan("o31.html");
                        break;
                    case "12E2":
                        setPlan("o32.html");
                        break;
                    case "12E3":
                        setPlan("o33.html");
                        break;
                    case "12K1":
                        setPlan("o34.html");
                        break;
                    case "12K2":
                        setPlan("o35.html");
                        break;
                    case "12L1":
                        setPlan("o36.html");
                        break;
                    case "12L2":
                        setPlan("o37.html");
                        break;
                    case "12M1":
                        setPlan("o38.html");
                        break;
                    case "12M2":
                        setPlan("o39.html");
                        break;
                    case "12M3":
                        setPlan("o40.html");
                        break;
                    case "12M4":
                        setPlan("o41.html");
                        break;
                    case "12M5":
                        setPlan("o42.html");
                        break;
                    case "12P1":
                        setPlan("o44.html");
                        break;
                    case "12T1":
                        setPlan("o45.html");
                        break;
                    case "12T2":
                        setPlan("o46.html");
                        break;
                    case "12T3":
                        setPlan("o47.html");
                        break;
                    case "12Z1":
                        setPlan("o49.html");
                        break;
                    case "12Z2":
                        setPlan("o50.html");
                        break;

                    case "13A1":
                        setPlan("o51.html");
                        break;
                    case "13A4":
                        setPlan("o52.html");
                        break;
                    case "13A5":
                        setPlan("o53.html");
                        break;
                    case "13A6":
                        setPlan("o54.html");
                        break;
                    case "13B2":
                        setPlan("o56.html");
                        break;
                    case "13B3":
                        setPlan("o57.html");
                        break;
                    case "13E1":
                        setPlan("o58.html");
                        break;
                    case "13E6":
                        setPlan("o60.html");
                        break;
                    case "13E8":
                        setPlan("o61.html");
                        break;
                    case "13K4":
                        setPlan("o62.html");
                        break;
                    case "13K5":
                        setPlan("o63.html");
                        break;
                    case "13L1":
                        setPlan("o64.html");
                        break;
                    case "13L3":
                        setPlan("o65.html");
                        break;
                    case "13M1":
                        setPlan("o66.html");
                        break;
                    case "13M2":
                        setPlan("o67.html");
                        break;
                    case "13M3":
                        setPlan("o68.html");
                        break;
                    case "13M4":
                        setPlan("o69.html");
                        break;
                    case "13M9":
                        setPlan("o72.html");
                        break;
                    case "53M1":
                        setPlan("o73.html");
                        break;
                    case "13P1":
                        setPlan("o74.html");
                        break;
                    case "13P2":
                        setPlan("o75.html");
                        break;
                    case "13T1":
                        setPlan("o76.html");
                        break;
                    case "13T2":
                        setPlan("o77.html");
                        break;
                    case "13T4":
                        setPlan("o78.html");
                        break;
                    case "13T7":
                        setPlan("o79.html");
                        break;
                    case "13W1":
                        setPlan("o80.html");
                        break;
                    case "13W2":
                        setPlan("o81.html");
                        break;
                    case "13Z2":
                        setPlan("o82.html");
                        break;
                    case "13Z6":
                        setPlan("o85.html");
                        break;
                    case "13Z7":
                        setPlan("o86.html");
                        break;

                    default:
                        setPlan("");
                        Toast.makeText(WebPlan.this, "Oops!", Toast.LENGTH_SHORT).show();
                        break;
                }
                progress();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

