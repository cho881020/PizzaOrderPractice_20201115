package kr.co.tjoeun.pizzaorderpractice_20201115

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_store_detail.*
import kr.co.tjoeun.pizzaorderpractice_20201115.datas.Store

class ViewStoreDetailActivity : BaseActivity() {

    lateinit var mStore: Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        setupEvents()
        setValues()
    }


    override fun setupEvents() {

    }

    override fun setValues() {
//        이전 목록화면에서 보내준 데이터를 멤버변수에 저장
        mStore = intent.getSerializableExtra("store") as Store

//        mStore를 활용해서 실 데이터 반영
        storeNameTxt.text = mStore.name
        storePhoneNumTxt.text = mStore.phoneNum

        Glide.with(mContext).load(mStore.logoURL).into(storeLogoImg)

    }

}