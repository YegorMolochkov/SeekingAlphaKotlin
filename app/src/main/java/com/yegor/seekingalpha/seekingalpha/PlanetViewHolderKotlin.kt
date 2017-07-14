package com.yegor.seekingalpha.seekingalpha

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

/**
 * View holder
 */
class PlanetViewHolderKotlin(view: View) : RecyclerView.ViewHolder(view) {

    var image: ImageView = view.findViewById(R.id.image) as ImageView
    var name: TextView = view.findViewById(R.id.name) as TextView
    var description: TextView = view.findViewById(R.id.description) as TextView
}