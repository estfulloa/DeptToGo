package com.example.depttogo.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.depttogo.R
import com.example.depttogo.databinding.ActivityMainBinding
import com.example.depttogo.menu_drawer
import com.example.depttogo.retrofit.IProductos
import com.example.depttogo.retrofit.RetrofitClase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryFragment : Fragment() {
    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var productos_gallery: ActivityMainBinding
    private lateinit var rvProductos: RecyclerView
    private lateinit var searchView: SearchView


    val productosList = listOf(
        ListaProductos("Cubre bocas", "Tamaño grande de color blanco", "https://loquesea.com", 100.00F),
        ListaProductos("Guantes", "Tamaño mediano color negro", "https://loquesea.com", 124.00F),
        ListaProductos("Paquete de modulos", "Diferentes colores", "https://loquesea.com", 250.00F),
        ListaProductos("braquets", "Transparentes", "https://loquesea.com", 1500.00F)

    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View?{

        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        //BUSCAR RECYCLER
        rvProductos = root.findViewById(R.id.rvProductos)
        llamadaRetrofit()
        initRecycler()
        searchView = root.findViewById(R.id.searchView)
        return root


    //): View? {
       // galleryViewModel =
          //  ViewModelProvider(this).get(GalleryViewModel::class.java)

      //  val textView: TextView = root.findViewById(R.id.titulo)
      // galleryViewModel.text.observe(viewLifecycleOwner, Observer {
           //textView.text = it
     //  })
    }
    fun searView(){
        //searchView = llamadaRetrofit()

    }

    fun initRecycler(lista: List<ListaProductos>) {
        rvProductos.layoutManager = LinearLayoutManager(context)
        val adapter= ProductosAdapter(lista)
        rvProductos.adapter =adapter

    }

    fun llamadaRetrofit() {
        val retrofit = RetrofitClase.getRetrofit()
        //interfaz mapeada directamene con retrofit
        val retrofitService = retrofit.create(IProductos::class.java)
        //preticio, primero se crea con el service y una lista de productos
        val peticion: Call<List<ListaProductos>> = retrofitService.listProductos()
        // se realiza la peticion
        peticion.enqueue(object: Callback<List<ListaProductos>>{
            override fun onResponse(
                call: Call<List<ListaProductos>>,
                response: Response<List<ListaProductos>>
            ) {
                // cuando si responde y utilizo la libreria
                val listaProductos = response.body()
                initRecycler(listaProductos!!)
            }

            override fun onFailure(call: Call<List<ListaProductos>>, t: Throwable) {
                //Cuando nos da un problema
                Log.e("ERROR:", "Hubo un problema ${t.message}")

            }


        });
       /* fun initRecycler(lista: List<ListaProductos>){
            rvProductos.layoutManager = LinearLayoutManager(context)
            val adapter= ProductosAdapter(lista)
            rvProductos.adapter = adapter
        */

        }


    }
