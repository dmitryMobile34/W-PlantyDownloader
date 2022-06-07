package com.newgenepsilumx.plantyoveralldownloader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.artjimlop.altex.AltexImageDownloader
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_img_manager.*

class ImgManager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_img_manager)



        Glide.with(this).load(R.drawable.placeholder).into(imageView)

        editBox.doAfterTextChanged {
            if (editBox.text.isNullOrEmpty()) {
                Glide.with(this).load(R.drawable.placeholder).into(imageView)
            } else {
                Glide.with(this).load(editBox.text.toString()).into(imageView)
            }
        }

        download_btn.setOnClickListener() {
            AltexImageDownloader.writeToDisk(this, editBox.text.toString(), "Planty Images")
            Toast.makeText(this,"Скачивание завершено.", Toast.LENGTH_SHORT).show()
        }

        backBtn.setOnClickListener {
            finish()
        }

    }
}