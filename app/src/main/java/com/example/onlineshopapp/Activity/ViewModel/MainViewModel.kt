package com.example.onlineshopapp.Activity.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopapp.Activity.Model.BestsellerModel
import com.example.onlineshopapp.Activity.Model.CategoryModel
import com.example.onlineshopapp.Activity.Model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel:ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance("https://onlineshopapp-c97df-default-rtdb.asia-southeast1.firebasedatabase.app")

    private val _banner = MutableLiveData<List<SliderModel>>()
    private val _Category = MutableLiveData<MutableList<CategoryModel>>()
    private val _bestseller = MutableLiveData<MutableList<BestsellerModel>>()

    val banners: LiveData<List<SliderModel>> = _banner
    val categories: LiveData<MutableList<CategoryModel>> = _Category
    val bestseller: LiveData<MutableList<BestsellerModel>> = _bestseller

    fun LoadBanner(){
        val databaseReference = firebaseDatabase.getReference("Banner")
        databaseReference.addValueEventListener(object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                    val lists = mutableListOf<SliderModel>()
                    for (childSnapshot in snapshot.children) {
                        val list = childSnapshot.getValue(SliderModel::class.java)
                        if (list != null) {
                            lists.add(list)
                        }
                    }
                    _banner.value = lists

            }
            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

   fun LoadCategory(){
        val databaseReference = firebaseDatabase.getReference("Category")
       databaseReference.addValueEventListener(object : ValueEventListener{

           override fun onDataChange(snapshot: DataSnapshot) {
               val lists = mutableListOf<CategoryModel>()
               for(childSnapshot in snapshot.children) {
                   val list = childSnapshot.getValue(CategoryModel::class.java)
                   if(list != null){
                       lists.add(list)
                   }
               }
               _Category.value = lists
           }

           override fun onCancelled(error: DatabaseError) {

           }

       })
    }
    fun LoadBestseller(){
        val databaseReference = firebaseDatabase.getReference("Items")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<BestsellerModel>()
                for(childSnapshot in snapshot.children){
                    val list = childSnapshot.getValue(BestsellerModel::class.java)
                    if(list !=null){
                        lists.add(list)
                    }
                }
                _bestseller.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

}