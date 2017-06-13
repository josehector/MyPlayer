package es.josehector.myplayer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    val adapter = MediaAdapter() { (id) -> navigateToDetail(id)}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.adapter = adapter
        loadFilteredData(Filter.None)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true;
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.items = when (item.itemId) {
            R.id.filter_photos -> MediaProvider.dataAsync().filter { it.type == MediaItem.Type.PHOTO }
            R.id.filter_videos -> MediaProvider.dataAsync().filter { it.type == MediaItem.Type.VIDEO }
            else -> MediaProvider.dataAsync()

        }
        return true
    }*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val filter: Filter =  when (item.itemId) {
            R.id.filter_photos -> Filter.ByType(MediaItem.Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            else -> Filter.None
        }

        loadFilteredData(filter)


        return true
    }

    private fun  loadFilteredData(filter: Filter) {
    /*    MediaProvider.dataAsync { media ->
            adapter.items = when (filter) {
                is Filter.None -> media
                is Filter.ByType -> media.filter { it.type == filter.type }
            }
        }*/
        async(UI) {
            val cats = bg {MediaProvider.dataSync("cats")}
            val nature = bg { MediaProvider.dataSync("nature") }
            adapter.items = cats.await() + nature.await()
        }
    }

    private fun  navigateToDetail(id: Int) {
        startActivity<DetailActivity>(DetailActivity.ID to id)
    }

}

sealed class Filter {
    object None: Filter()
    class ByType(val type: MediaItem.Type): Filter()
}