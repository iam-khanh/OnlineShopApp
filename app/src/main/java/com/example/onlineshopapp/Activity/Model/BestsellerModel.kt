package com.example.onlineshopapp.Activity.Model

import android.os.Parcel
import android.os.Parcelable

data class BestsellerModel(
    var title: String = "",
    var description: String ="",
    var picUr: ArrayList<String> = ArrayList(),
    var size: ArrayList<String> = ArrayList(),
    var price:Double = 0.0,
    var rating:Double = 0.0,
    var sellerName: String = "",
    var sellerPic: String = "",
    var sellerTell: Int = 0,
    var numberInCart: Int = 0
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        TODO("picUr"),
        TODO("size"),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeString(sellerName)
        parcel.writeString(sellerPic)
        parcel.writeInt(sellerTell)
        parcel.writeInt(numberInCart)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BestsellerModel> {
        override fun createFromParcel(parcel: Parcel): BestsellerModel {
            return BestsellerModel(parcel)
        }

        override fun newArray(size: Int): Array<BestsellerModel?> {
            return arrayOfNulls(size)
        }
    }
}
