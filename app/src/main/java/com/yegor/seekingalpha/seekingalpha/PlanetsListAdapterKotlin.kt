package com.yegor.seekingalpha.seekingalpha

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import java.util.*

/**
 * Adapter for mail list view
 */
class PlanetsListAdapterKotlin(val context: Context, val listener: ItemSelectedListenerKotlin) : RecyclerView.Adapter<PlanetViewHolderKotlin>() {

    private var mPlanets = LinkedList<PlanetKotlin>()

    override fun onBindViewHolder(holder: PlanetViewHolderKotlin, position: Int) {
        val planet = mPlanets[position]
        holder.name.text = planet.name
        holder.description.text = planet.description
        Picasso.with(context)
                .load(planet.URL)
                .fit()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.drawable.error)
                .into(holder.image);

        holder.itemView.setOnClickListener({ listener.onItemSelected(planet) })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlanetViewHolderKotlin {
        val view = LayoutInflater.from(context).inflate(R.layout.list_element, parent, false);
        return PlanetViewHolderKotlin(view)
    }

    override fun getItemCount(): Int {
        return mPlanets.size
    }

    fun addItems(planets : List<PlanetKotlin>?){
        if (planets!=null){
            mPlanets.addAll(planets)
        }
        notifyDataSetChanged()
    }

    interface ItemSelectedListenerKotlin {

        fun onItemSelected(planet: PlanetKotlin)
    }

}
