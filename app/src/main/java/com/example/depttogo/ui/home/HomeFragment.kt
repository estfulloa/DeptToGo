package com.example.depttogo.ui.home

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.depttogo.R

class HomeFragment : Fragment() {

    // cosntante para url
    private val BASE_URL = "https://google.com"
    private val SEAR_PATH = "/search?q="
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        return view;
        //Refresh
        swipeResfresh.setOnRefreshListenner{

            webview.reload()
        }
        //search

        searchView.setOnQueryTextListenner(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(p0: String?): Boolean{
                return false

            }
            override fun onQueryTextSubmit(p0: String): Boolean{

                p0?.let{
                    if(URLUtil.isValidUrl(it))
                    //sí es una url
                        webView.loadUrl(it)
                }else{
                    //si no es url
                    webView.loadUrl("$BASE_URL$SEAR_PATH$it")
                }
                return false
            }

        })

        //WebView
        webView.webChromeClient = object : WebChromeClient(){


        }

        webView.webViewClient = object  : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
                 }



                //cuando se carga la pagina
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                    searchView.setQuey(url, false)
                    swipeRefresh.isRefreshing= true


            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipeRefresh.isRefreshing = false
            }

        }
        val settings: webView.settings
        settings.javaScriptEnabled= true

        webView.loadUrl(BASE_URL)


    }
    override fun onBackPressed(){
        if(webView.canGoBack()){
            webView.goBack()

        }else{
            super.onBackPressed()
        }

    }

}