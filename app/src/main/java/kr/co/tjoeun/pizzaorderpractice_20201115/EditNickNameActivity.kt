package kr.co.tjoeun.pizzaorderpractice_20201115

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        okBtn.setOnClickListener {

            val inputNickName = inputNickNameEdt.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("nickName", inputNickName)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()

        }

    }

    override fun setValues() {

    }

}