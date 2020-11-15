package kr.co.tjoeun.pizzaorderpractice_20201115.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kr.co.tjoeun.pizzaorderpractice_20201115.fragments.MyProfileFragment
import kr.co.tjoeun.pizzaorderpractice_20201115.fragments.PizzaStoreFragment

class MyViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> PizzaStoreFragment()
            else -> MyProfileFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }
}