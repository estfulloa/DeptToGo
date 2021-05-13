package com.example.depttogo.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.depttogo.R
import com.example.depttogo.databinding.ActivityMainBinding
import com.example.depttogo.menu_drawer

class GalleryFragment : Fragment() {
    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var productos_gallery: ActivityMainBinding


    val productosList = listOf(
        ListaProductos("Cubre bocas", "Tamaño grande de color blanco", "https://loquesea.com", 100.00F),
        ListaProductos("Guantes", "Tamaño mediano color negro", "https://loquesea.com", 124.00F),
        ListaProductos("Paquete de modulos", "Diferentes colores", "https://loquesea.com", 250.00F),
        ListaProductos("braquets", "Transparentes", "https://loquesea.com", 1500.00F)

    )
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?




    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
      //  val textView: TextView = root.findViewById(R.id.titulo)
      // galleryViewModel.text.observe(viewLifecycleOwner, Observer {
           //textView.text = it
     //  })
        return root


    }

    fun initRecycler(){
        rvProductos.layoutManager = LinearLayoutManager(this)
        val adapter= ProductosAdapter(rvProductos)
        rvProductos.adapter = adapter


    }
}