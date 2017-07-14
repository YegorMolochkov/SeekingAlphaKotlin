package com.yegor.seekingalpha.seekingalpha

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivityKotlin : AppCompatActivity() {

    private var mAdapter: PlanetsListAdapterKotlin? = null
    private var mListener: PlanetsListScrollListenerKotlin? = null
    private var mListView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initList()
        loadPage(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        mListView?.removeOnScrollListener(mListener)
    }

    private fun initList() {
        mListView = findViewById(R.id.list) as RecyclerView
        val manager = LinearLayoutManager(this)
        mListView?.layoutManager = manager
        mListener = object : PlanetsListScrollListenerKotlin(manager) {

            override fun onLoadMore(currentPage: Int) {
                loadPage(currentPage)
            }
        }
        mListView?.addOnScrollListener(mListener)
        mAdapter = PlanetsListAdapterKotlin(this, object : PlanetsListAdapterKotlin.ItemSelectedListenerKotlin {

            override fun onItemSelected(planet: PlanetKotlin) {
                goToDetails(planet)
            }
        })
        mListView?.adapter = mAdapter
    }

    private fun loadPage(pageNum: Int) {
        val service = createService()
        val call = service.loadPlanetsInfo(pageNum.toString())
        call.enqueue(object : Callback<PlanetsResponseKotlin> {

            override fun onResponse(call: Call<PlanetsResponseKotlin>?, response: Response<PlanetsResponseKotlin>?) {
                mAdapter?.addItems(response?.body()?.planets)
            }

            override fun onFailure(call: Call<PlanetsResponseKotlin>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    private fun goToDetails(planet: PlanetKotlin) {
        val intent = Intent(this, DetailsActivityKotlin::class.java)
        intent.putExtra(SELECTED_PLANET, planet)
        startActivity(intent)
    }
}