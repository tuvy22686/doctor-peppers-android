package com.tuvy.tomosugi.minimalpairs.controller

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.tuvy.tomosugi.minimalpairs.view.MatchingListFragment
import com.tuvy.tomosugi.minimalpairs.view.UserListFragment

class MainFragmentStatePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(i: Int): Fragment {
        when (i) {
            0 -> return UserListFragment()
            else -> return MatchingListFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        if (position == 0) {
            return "さがす"
        }
        else {
            return "メッセージ"
        }
    }
}
