package kr.co.tjoeun.pizzaorderpractice_20201115.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_my_profile.*
import kr.co.tjoeun.pizzaorderpractice_20201115.EditNickNameActivity
import kr.co.tjoeun.pizzaorderpractice_20201115.R

class MyProfileFragment : Fragment() {

    val REQ_FOR_NICKNAME = 1005

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        내 닉네임 변경 관련 기능 작성해야함

        changeNickNameBtn.setOnClickListener {

            val myIntent = Intent(context!!, EditNickNameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)


        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        받아온 닉네임 반영 작업 필요

        if (requestCode == REQ_FOR_NICKNAME) {

            if (resultCode == Activity.RESULT_OK) {

                val newNickName = data?.getStringExtra("nickName")

                nickNameTxt.text = newNickName

            }

        }


    }

}