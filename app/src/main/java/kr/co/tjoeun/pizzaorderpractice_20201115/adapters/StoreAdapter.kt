package kr.co.tjoeun.pizzaorderpractice_20201115.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.pizzaorderpractice_20201115.R
import kr.co.tjoeun.pizzaorderpractice_20201115.datas.Store

class StoreAdapter(
    val mContext: Context,
    resId: Int,
    val mList: ArrayList<Store>) : ArrayAdapter<Store>(mContext, resId, mList) {

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


//        완성된 row가 리스트뷰에 뿌려질 결과물
        return row

    }

}