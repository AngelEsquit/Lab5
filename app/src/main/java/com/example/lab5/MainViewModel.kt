package com.example.lab5

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel : ViewModel() {
    val items = listOf(
        Item(1, "Concierto 1", R.drawable.image_fx_, "Los Angeles",
            "2024-10-10", "20:00"),
        Item(2, "Concierto 2", R.drawable.image_fx_1, "París",
            "2024-11-24", "21:00"),
        Item(3, "Concierto 3", R.drawable.image_fx_2, "Tokio",
            "2024-12-15", "18:00"),
        Item(4, "Concierto 4", R.drawable.image_fx_3, "Nueva York",
            "2025-01-20", "19:00"),
        Item(5, "Concierto 5", R.drawable.image_fx_4, "Londres",
            "2025-02-14", "22:00"),
        Item(6, "Concierto 6", R.drawable.image_fx_5, "Madrid",
            "2025-03-30", "20:30"),
        Item(7, "Concierto 7", R.drawable.image_fx_6, "Roma",
            "2025-04-05", "21:30"),
        Item(8, "Concierto 8", R.drawable.image_fx_7, "Berlín",
            "2025-05-10", "19:30"),
        Item(9, "Concierto 9", R.drawable.image_fx_8, "Moscú",
            "2025-06-20", "20:30"),
        Item(10, "Concierto 10", R.drawable.image_fx_9, "Pekín",
            "2025-07-15", "18:30"),
    )

    val favorites = mutableListOf<Item>()

    fun addOrRemoveFavorite(item: Item, context: Context) {
        if (item in favorites) {
            favorites.remove(item)
        } else {
            favorites.add(item)
        }
        saveFavorites(context)
    }

    private fun saveFavorites(context: Context) {
        val sharedPref = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val gson = Gson()
        val jsonString = gson.toJson(favorites)
        editor.putString("favorites_list", jsonString)
        editor.apply()
    }

    fun loadFavorites(context: Context) {
        val sharedPref = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)
        val jsonString = sharedPref.getString("favorites_list", null)
        if (jsonString != null) {
            val gson = Gson()
            val type = object : TypeToken<List<Item>>() {}.type
            favorites.addAll(gson.fromJson(jsonString, type))}
    }
}