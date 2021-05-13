package com.example.depttogo.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.depttogo.R
import com.example.depttogo.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

private lateinit var binding: ActivityMainBinding



class ProductosAdapter(private val productos: List<ListaProductos>):RecyclerView.Adapter<ProductosAdapter.ProductsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosAdapter.ProductsHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return ProductsHolder(layoutInflater.inflate(R.layout.productos_gallery, parent, false))
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onBindViewHolder(holder: ProductosAdapter.ProductsHolder, position: Int) {
        holder.render(productos[position])
    }
    override fun getItemCount(): Int = productos.size

    class ProductsHolder(private val view:View):RecyclerView.ViewHolder(view){

        fun render(productos: ListaProductos){

            binding.tvnombre.text= productos.nombreProducto
            binding.tvdescripcion.text = productos.descripcion
            binding.tvprecio.text = productos.precio
            binding.Picasso.get().load(productos.image).into(view.imgproductos)

            view.setOnClickListener{ Toast.makeText(view.context, "Has seleccionado: ${productos.nombreProducto}", Toast.LENGTH_SHORT)

            }
        }


    }



}


