package com.abaferastech.watermyplants.data.local.converters

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.util.Base64

class ImageConverters {
//    @TypeConverter
//    fun getStringFromBitmap(bitmap: Bitmap?): ByteArray {
//        if (bitmap == null) {
//            return ByteArray(10)
//        }
//        val outputStream = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
//        return outputStream.toByteArray()
//    }
//
//    @TypeConverter
//    fun getBitmapFromString(byteArray: ByteArray): Bitmap{
//        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
//    }
    @TypeConverter
    fun bitmapToBase64(bitmap: Bitmap) : String{
        // create a ByteBuffer and allocate size equal to bytes in   the bitmap
        val byteBuffer = ByteBuffer.allocate(bitmap.height * bitmap.rowBytes)
        //copy all the pixels from bitmap to byteBuffer
        bitmap.copyPixelsToBuffer(byteBuffer)
        //convert byte buffer into byteArray
        val byteArray = byteBuffer.array()
        //convert byteArray to Base64 String with default flags
        return String(Base64.getEncoder().encode(byteArray))
    }


    @TypeConverter
    fun base64ToBitmap(base64String: String):Bitmap{
        //convert Base64 String into byteArray
        val byteArray = Base64.getDecoder().decode(base64String)
        //byteArray to Bitmap
//        BitmapFactory.Options().inJustDecodeBounds = false
        return BitmapFactory.decodeByteArray(byteArray,
            0, byteArray.size )
    }
}