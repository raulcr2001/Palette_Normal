package com.example.palette

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.appbar)
        setSupportActionBar(toolbar)

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.drawable.image1))
        items.add(Tarjeta(R.drawable.image2))
        items.add(Tarjeta(R.drawable.image3))
        items.add(Tarjeta(R.drawable.image4))
        items.add(Tarjeta(R.drawable.image5))
        items.add(Tarjeta(R.drawable.image6))
        items.add(Tarjeta(R.drawable.image7))
        items.add(Tarjeta(R.drawable.image8))

        val recView = findViewById<RecyclerView>(R.id.recview)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adaptador.onClick  = {
            val intent = Intent(this, PaletteActivity::class.java)
            val item = items[recView.getChildAdapterPosition(it)]
            val bundle = bundleOf("img" to item.imagen)

            intent.putExtras(bundle)
            startActivity(intent, bundle)
        }
    }
}