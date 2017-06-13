package es.josehector.myplayer

/**
 * Created by josehector on 3/06/17.
 */
data class MediaItem(val id: Int, val title: String, val thumbUrl: String, val type: Type) {
    enum class Type {PHOTO, VIDEO}
}