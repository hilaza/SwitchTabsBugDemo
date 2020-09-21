package com.example.android.demofocusbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val palettesAdapter = PagesAdapter(this)
        viewPager.adapter = palettesAdapter
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.setIcon(palettesAdapter.getIcon(position))
        }.attach()
    }
}

/**
 * Palettes fragments creator
 */
class PagesAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    private val pages: Array<Int>

    init {
        val p = mutableListOf(0, 1, 2, 3)
        pages = p.toTypedArray()
    }

    override fun getItemCount(): Int {
        return pages.count()
    }

    override fun createFragment(position: Int): Fragment {
        return TabFragment(position)
    }

    fun getIcon(position: Int): Int {
        return when (position) {
            0 -> R.drawable.ic_baseline_filter_1_24
            1 -> R.drawable.ic_baseline_filter_2_24
            2 -> R.drawable.ic_baseline_filter_3_24
            else -> R.drawable.ic_baseline_filter_4_24
        }
    }
}
