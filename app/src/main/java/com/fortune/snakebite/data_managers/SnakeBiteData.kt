package com.fortune.snakebite.data_managers

import android.os.Parcel
import android.os.Parcelable

data class Disease (val diseaseId: String, val title: String ,val causingSnake: String ,var symptom: Array<String>,var treatment: Array<String>,var pharmacy: Array<String>):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArray(),
        parcel.createStringArray(),
        parcel.createStringArray()
    ) {
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return title
    }

    companion object CREATOR : Parcelable.Creator<Disease> {
        override fun createFromParcel(parcel: Parcel): Disease {
            return Disease(parcel)
        }

        override fun newArray(size: Int): Array<Disease?> {
            return arrayOfNulls(size)
        }
    }
}

//data class Symptom(var disease: Disease? = null, var title: String? = null, var text: String? = null)

