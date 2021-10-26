package com.example.tez_sat.ui.activities.main

import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.tez_sat.R
import com.example.tez_sat.core.ui.BaseActivity
import com.example.tez_sat.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel:MainViewModel by viewModel()

    override fun setupUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun setupLiveData() {

    }

    override fun inflateBinding(from: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    companion object{
        const val KEY = "key"
    }
}


//ТЗ:
//- Ознакомиться с основным API
//- Сделать BottomNavigation с 4 табами для:
//Персонажей, Локаций, Эпизодов и Поиска
//- В 3 первых табах отобразить нужные элементы.
//- Сделать возможность поиска и фильтрации
//- Для выбора фильтрации сделать отдельное диалоговое окно
//- В 4 табе сделать поиск по параметру name всех запросов,
// объединить весь результат в один и отобразить с фильтрацией по дате добавления:
//с нового – к старому
//- Дать возможность открыть элементы детально
