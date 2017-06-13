package es.josehector.myplayer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

/**
 * Created by josehector on 3/06/17.
 */

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun MediaAdapter.ViewHolder.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    itemView.context.toast(message,length)
}

fun ViewGroup.inflate(layoutRes: Int, attachToRoot: Boolean = false) : View {
    return LayoutInflater.from(context).inflate(layoutRes,this,attachToRoot)
}

fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

inline fun <reified T : View> View.find(idRes: Int) : T{
    return findViewById(idRes) as T
}


inline fun <reified T : View> RecyclerView.ViewHolder.find(idRes: Int) : T{
    return itemView.findViewById(idRes) as T
}
