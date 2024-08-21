package com.example.onlineshopapp.Activity.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopapp.Activity.Model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel:ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance("https://onlineshopapp-c97df-default-rtdb.asia-southeast1.firebasedatabase.app")

    private val _banner = MutableLiveData<List<SliderModel>>()

    val banners: LiveData<List<SliderModel>> = _banner

    fun LoadBanner(){
        val databaseReference = firebaseDatabase.getReference("Banner")
        databaseReference.addValueEventListener(object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val lists = mutableListOf<SliderModel>()
                    for (childSnapshot in snapshot.children) {
                        val list = childSnapshot.getValue(SliderModel::class.java)
                        if (list != null) {
                            lists.add(list)
                        }
                    }
                    _banner.value = lists
                    Log.d("Firebase", "Data successfully retrieved: ${lists.size} items")
                } else {
                    Log.d("Firebase", "Snapshot does not exist")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.e("Firebase", "Error: ${error.message}")
            }

        })
    }

}