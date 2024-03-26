package com.example.testwork

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.testwork.databinding.FoodinfoBinding
import com.example.testwork.databinding.FoodlistBinding

class FoodAdapter: RecyclerView.Adapter<MyFoodHolder>() {
    private var data: List<FoodList> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<FoodList>) {
        this.data = data
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFoodHolder {
        val binding = FoodlistBinding.inflate(LayoutInflater.from(parent.context))
        val binding2 = FoodinfoBinding.inflate(LayoutInflater.from(parent.context))
        return MyFoodHolder(binding, binding2)
    }

    override fun onBindViewHolder(holder: MyFoodHolder, position: Int) {
        val item = data[position]
        with(holder.binding) {
            nameFood.text = "${item.name}"
            price.text = "${item.price_current}"
            imageFood.load(item.image)
        }
        with(holder.binding2) {
            photoFood.load(item.image)
            nameFoodInfo.text = "${item.name}"
            description.text = "${item.description}"
            energyValue.text = "${item.energy_per_100_grams}"
            protein.text = "${item.proteins_per_100_grams}"
            fat.text = "${item.fats_per_100_grams}"
            carbohydrates.text = "${item.carbohydrates_per_100_grams}"
        }
        }
    }

class MyFoodHolder(val binding: FoodlistBinding, val binding2: FoodinfoBinding): RecyclerView.ViewHolder(binding.root)