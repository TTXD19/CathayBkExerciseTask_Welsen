package com.android.project.cathaybkexercisetask_welsen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.android.project.cathaybkexercisetask_welsen.databinding.ActivityMainBinding
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // region Life cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        if (savedInstanceState == null) showUserListFragment()
    }

    // endregion

    // region - View Update

    private fun showUserListFragment() {
        supportFragmentManager.beginTransaction().add(R.id.fl_main, UserListFragment.newInstance()).commit()
    }

    // endregion
}