package es.josehector.myplayer

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by josehector on 4/06/17.
 */

object MediaProvider {

    private val thumbBase = "http://lorempixel.com/400/400"

    private var data = emptyList<MediaItem>()

    fun dataAsync(dataType: String, callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                data = dataSync(dataType)
            }
            uiThread {
                callback(data)
            }
        }
    }

    fun dataSync(dataType: String): List<MediaItem> {
        Thread.sleep(2000)
        return (1..10).map {
            MediaItem(it, "Title $it", "$thumbBase/$dataType/$it",
                    if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
        }
    }
}


