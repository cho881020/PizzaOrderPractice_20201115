package kr.co.tjoeun.pizzaorderpractice_20201115

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
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

        callBtn.setOnClickListener {

//            전화버튼이 눌리면 => TedPermission 라이브러리로
//            권한 확인하고 => 상황별 대응

//            Code : 상황별 대응 방법 (가이드북-object이용) 먼저 생성 => 가이드북을 들고, 권한 확인

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한이 승인되었다면? => 실제 전화 연결 (ACTION_CALL)

                    val myUri = Uri.parse("tel:${mStore.phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    최종 통화 불가 일때 => 안내 토스트
                    Toast.makeText(mContext, "권한이 거부되어 전화연결이 불가능합니다.", Toast.LENGTH_SHORT).show()
                }

            }

//            가이드북 들고 권한 확인
            TedPermission.with(mContext)
                    .setPermissionListener(permissionListener)
                    .setDeniedMessage("[설정] 에서 권한을 허락하셔야 전화연결이 가능합니다.")
                    .setPermissions(Manifest.permission.CALL_PHONE)
                    .check()

        }

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