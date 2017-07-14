package com.yegor.seekingalpha.seekingalpha

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

const val SELECTED_PLANET = "SELECTED_PLANET"
/**
 * Screen with details of planet
 */
class DetailsActivityKotlin : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var name: TextView
    lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
        initData()
    }

    private fun initViews() {
        image = findViewById(R.id.image) as ImageView
        name = findViewById(R.id.name) as TextView
        description = findViewById(R.id.description) as TextView
    }

    private fun initData() {
        val planet = intent.getSerializableExtra(SELECTED_PLANET) as PlanetKotlin
        name.text = planet.name
        description.text = planet.description
        Picasso.with(this)
                .load(planet.URL)
                .fit()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.error)
                .into(image)
    }
}