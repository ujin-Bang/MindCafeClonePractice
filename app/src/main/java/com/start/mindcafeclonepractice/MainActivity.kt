package com.start.mindcafeclonepractice


import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.start.mindcafeclonepractice.databinding.ActivityMainBinding
import com.start.mindcafeclonepractice.fragments.CommunityFragment
import com.start.mindcafeclonepractice.fragments.ConsultingFragment
import com.start.mindcafeclonepractice.fragments.ExpertFindFragment
import com.start.mindcafeclonepractice.fragments.HomeFragment

class MainActivity : BaseActivity() {

    lateinit var binding: ActivityMainBinding

    private val mOnNavigationiItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item ->

        when(item.itemId){
            R.id.home -> {
                println("home pressed")
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.community -> {
                println("community pressed")
                replaceFragment(CommunityFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.expertFind -> {
                println("expertFind pressed")
                replaceFragment(ExpertFindFragment())
                return@OnNavigationItemSelectedListener true
            }

            R.id.consulting -> {
                println("consulting pressed")
                replaceFragment(ConsultingFragment())
                return@OnNavigationItemSelectedListener true
            }

            else -> false
        }
    }

override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        setCustomActionBarForMain()
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        binding.btnWrite.setOnClickListener {

            startActivity(Intent(mContext, WriteActivity::class.java))

        }

    }

    override fun setValues() {

        binding.mainBottomNavView.setOnNavigationItemSelectedListener(mOnNavigationiItemSelectedListener)

        replaceFragment(HomeFragment())


    }
        fun replaceFragment(fragment: Fragment){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragment)
            fragmentTransaction.commit()


    }


}