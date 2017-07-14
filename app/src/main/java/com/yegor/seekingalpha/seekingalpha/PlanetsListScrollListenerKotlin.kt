package com.yegor.seekingalpha.seekingalpha

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Doing endless scrolling, taken from (https://gist.github.com/ssinss/e06f12ef66c51252563e)
 */
abstract class PlanetsListScrollListenerKotlin(var layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {

    private val VISIBLE_THRESHOLD = 5
    private var previousTotal = 0
    private var mCurrentPage = 0
    private var loading = true
    private var mFirstVisibleItem = 0
    private var mVisibleItemCount = 0
    private var mTotalItemCount = 0

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        mVisibleItemCount = recyclerView.childCount
        mTotalItemCount = layoutManager.itemCount
        mFirstVisibleItem = layoutManager.findFirstVisibleItemPosition()

        if (loading) {
            if (mTotalItemCount > previousTotal) {
                loading = false
                previousTotal = mTotalItemCount
            }
        }
        if (!loading && mTotalItemCount - mVisibleItemCount <= mFirstVisibleItem + VISIBLE_THRESHOLD) {
            // End has been reached

            // Do something
            mCurrentPage++

            onLoadMore(mCurrentPage)

            loading = true
        }
    }

    abstract fun onLoadMore(currentPage: Int)
}