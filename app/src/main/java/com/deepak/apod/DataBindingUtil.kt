package com.deepak.apod

import android.widget.ImageView
import com.squareup.picasso.Picasso

import androidx.databinding.BindingAdapter


@BindingAdapter("urlImage")
fun bindUrlImage(view: ImageView, imageUrl: String?) {
    if (imageUrl != null) {
        Picasso.get()
            .load(imageUrl)
            .fit()
            .centerInside()
            .noFade()
            .placeholder(R.drawable.ic_image_white_24dp)
            .error( R.drawable.ic_broken_image_white_24dp)
            .into(view)
    } else {
        view.setImageBitmap(null)
    }
}