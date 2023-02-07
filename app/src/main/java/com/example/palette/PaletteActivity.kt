package com.example.palette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette

class PaletteActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_palette)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val image = findViewById<ImageView>(R.id.image2)

        val bundle = intent.extras

        image.setImageResource(bundle!!.getInt("img"))

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, bundle.getInt("img"))

        Palette.from(bitmap).generate { palette ->

            val vibrant: Palette.Swatch? = palette?.vibrantSwatch
            val darkvibrant: Palette.Swatch? = palette?.darkVibrantSwatch
            val lightvibrant: Palette.Swatch? = palette?.lightVibrantSwatch
            val muted: Palette.Swatch? = palette?.mutedSwatch
            val darkmuted: Palette.Swatch? = palette?.darkMutedSwatch
            val lightmuted: Palette.Swatch? = palette?.lightMutedSwatch

            if (lightvibrant != null) {findViewById<TextView>(R.id.textViewLightVariant).setBackgroundColor(lightvibrant!!.rgb)}
            if (muted != null) {findViewById<TextView>(R.id.textViewMuted).setBackgroundColor(muted!!.rgb)}
            if (darkmuted != null) {findViewById<TextView>(R.id.textViewDarkMuted).setBackgroundColor(darkmuted!!.rgb)}
            if (lightmuted != null) { findViewById<TextView>(R.id.textViewLightMuted).setBackgroundColor(lightmuted!!.rgb)}



            if (vibrant != null) {
                toolbar.setBackgroundColor(vibrant.rgb)
                toolbar.setTitleTextColor(vibrant.titleTextColor)
            }
        }
    }
}