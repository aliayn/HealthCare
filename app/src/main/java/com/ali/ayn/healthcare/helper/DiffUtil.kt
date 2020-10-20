package com.aliayn.jetpackcomponent.helper

import androidx.recyclerview.widget.DiffUtil
import com.aliayn.jetpackcomponent.data.local.entity.Note
import com.aliayn.jetpackcomponent.data.remote.model.UnsplashPhoto

val noteDiffUtil by lazy {
    object : DiffUtil.ItemCallback<Note>() {

        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean =
            oldItem == newItem
    }
}

val photoDiffUtil by lazy {
    object : DiffUtil.ItemCallback<UnsplashPhoto>() {
        override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean =
            oldItem == newItem

    }
}