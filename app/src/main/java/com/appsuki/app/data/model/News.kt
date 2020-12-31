package com.appsuki.app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize

data class News(
    val nama_makanan: String = "",
    val jumlah: String = "",
    val gambar: String = "",
    val harga: String = ""

) : Parcelable