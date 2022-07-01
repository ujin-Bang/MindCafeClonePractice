package com.start.mindcafeclonepractice.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.start.mindcafeclonepractice.newexpertdetailviewpager2infragment.NewExpertProfileDetailViewPager2in1
import com.start.mindcafeclonepractice.newexpertdetailviewpager2infragment.NewExpertProfileDetailViewPager2in2
import com.start.mindcafeclonepractice.newexpertdetailviewpager2infragment.NewExpertProfileDetailViewPager2in3

class NewExpertDetailViewPager2Adapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {

        return 3
    }

    override fun createFragment(position: Int): Fragment {

        return when(position){

            0 ->  {
                val myFrag = NewExpertProfileDetailViewPager2in1()
//                myFrag.NED = NewExpertDetailActivity().data //액티비티에서 어댑터 콜할때 사용할 데이터도 같이 넣으시면 낫긴 할것 같은데
                return myFrag
            }
            1 -> NewExpertProfileDetailViewPager2in2()
            else -> NewExpertProfileDetailViewPager2in3()
        }
    }
}