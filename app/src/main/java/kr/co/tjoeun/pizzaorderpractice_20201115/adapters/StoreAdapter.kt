package kr.co.tjoeun.pizzaorderpractice_20201115.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import kr.co.tjoeun.pizzaorderpractice_20201115.R
import kr.co.tjoeun.pizzaorderpractice_20201115.datas.Store

class StoreAdapter(
    val mContext: Context,
    resId: Int,
    val mList: List<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

//    mContext, mList => m으로 시작 : 멤버변수임을 명시
//    멤버변수 : 변수중, 클래스 내부의 어느곳(=어떤 함수)에서든 사용가능한 변수.
//    resId => 그냥 시작  : 멤버변수가 아님.
//    다른 함수 내에서는 가져다 사용할 수 없다. (임시로 사용하기 위함) : 클래스 첫 중괄호 까지만 OK

    val mInf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        리스트뷰의 재사용성 활용 : convertView 변수 활용
//        convertView는 내용 변경 불가 => "var" tempRow를 활용
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = mInf.inflate(R.layout.store_list_item, null)
        }

        val row = tempRow!!

//        실제로 뿌려주기 전 row에 데이터들을 집어넣고

//        (1) row내부의 TextView / ImageView 등등 에게
//        (2) ArrayList 안에 있는 데이터를 꺼내서 => (3) 문구 / src 등 반영

        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val logoImg = row.findViewById<ImageView>(R.id.logoImg)

//        현재 그려주려는 위치(position 변수)에 맞는 데이터 (mList에서) 꺼내서 => 변수에 저장

        val storeData = mList[position]

        nameTxt.text = storeData.name

//        storeData.logoUrl에 적힌 주소에 있는 이미지를 => logoImg에 뿌려주자.
//        웹상의 이미지를 => 이미지뷰에 뿌려주자 => Glide 라이브러리 활용.

        Glide.with(mContext).load(storeData.logoURL).into(logoImg)

//        완성된 row가 리스트뷰에 뿌려질 결과물
        return row

    }

}