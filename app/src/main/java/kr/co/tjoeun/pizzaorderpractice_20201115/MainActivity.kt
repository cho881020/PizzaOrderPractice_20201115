package kr.co.tjoeun.pizzaorderpractice_20201115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.tjoeun.pizzaorderpractice_20201115.adapters.MyViewPagerAdapter

class MainActivity : BaseActivity() {

    lateinit var myViewPagerAdapter : MyViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        myViewPagerAdapter = MyViewPagerAdapter(supportFragmentManager)
        myViewPager.adapter = myViewPagerAdapter

    }

}