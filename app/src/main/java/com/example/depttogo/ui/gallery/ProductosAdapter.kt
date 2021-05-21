package com.example.depttogo.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.depttogo.R
import com.example.depttogo.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class ProductosAdapter(private val productos: List<ListaProductos>):RecyclerView.Adapter<ProductosAdapter.ProductsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosAdapter.ProductsHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ProductsHolder(layoutInflater.inflate(R.layout.productos_gallery, parent, false))
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

    }

    override fun onBindViewHolder(holder: ProductosAdapter.ProductsHolder, position: Int) {
        holder.render(productos[position])
    }
    override fun getItemCount(): Int = productos.size

    class ProductsHolder(private val view:View):RecyclerView.ViewHolder(view){
        private val tvnombre = view.findViewById<TextView>(R.id.textView2)
        private val  tvdescripcion = view.findViewById<TextView>(R.id.textView)
        private val tvprecio = view.findViewById<TextView>(R.id.textView)
        private val imgproductos = view.findViewById<ImageView>(R.id.imgproductos)
        fun render(productos: ListaProductos){

            tvnombre.text= productos.nombreProducto
            tvdescripcion.text = productos.descripcion
            tvprecio.text = productos.precio.toString()
            Picasso.get().load(productos.image).into(imgproductos)

            view.setOnClickListener{ Toast.makeText(view.context, "Has seleccionado: ${productos.nombreProducto}", Toast.LENGTH_SHORT)

            }
        }


    }



}


