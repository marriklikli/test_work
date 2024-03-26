package com.example.testwork


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope

import com.example.testwork.databinding.ActivityCatalogeBinding

import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class CatalogeActivity : AppCompatActivity() {
    private val cont = 0
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityCatalogeBinding
    private lateinit var foodAdapter: FoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatalogeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageButton.setOnClickListener{
            FilterFragment().show(supportFragmentManager, "Filter")
        }
        viewModel.price.observe(this){
            binding.filter.text = String.format("Filter: %$", it)
        }
        binding.moreButton.setOnClickListener{
            val item = Intent(this, FoodListActivity::class.java)
            startActivity(item)
        }
        binding.addButton.setOnClickListener{
            binding.basketFood.text = (cont + 1).toString()
        }
        binding.minusButton.setOnClickListener{
            binding.basketFood.text = (cont - 1).toString()
        }

    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        binding.foodList.adapter = foodAdapter
        lifecycleScope.launch{viewModel.data.onEach {
            foodAdapter.setData(it)
        }}
        viewModel.onGetData()
        return super.onCreateView(name, context, attrs)
    }
}



