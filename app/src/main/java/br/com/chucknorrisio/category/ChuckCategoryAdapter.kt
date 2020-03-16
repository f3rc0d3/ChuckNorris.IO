package br.com.chucknorrisio.category

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.chucknorrisio.R
import br.com.chucknorrisio.category.data.model.Category
import br.com.chucknorrisio.common.adapter.Recycler
import br.com.chucknorrisio.common.tool.ScaledDownImage
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.row_category.view.*

class ChuckCategoryAdapter(private val context: Context) : Recycler.Adapter<String, ChuckCategoryAdapter.ChuckCategoryViewHolder>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChuckCategoryViewHolder =
        ChuckCategoryViewHolder(inflate(parent, R.layout.row_category))

    override fun onBindViewHolder(holder: ChuckCategoryViewHolder, item: String) =
        holder.bind(item)

    inner class ChuckCategoryViewHolder(override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        private val scaledDownImage = ScaledDownImage(itemView.iv_category, context)

        fun bind(item: String) {
            itemView.tv_category_name.text = item

            itemView.tv_desc.setText(bindDescWithTitle(item))

            itemView.iv_category.setImageResource(bindImageWithTitle(item))
            itemView.iv_category.setImageBitmap(scaledDownImage.scaleDown())
        }
    }

    fun bindImageWithTitle(title: String): Int {
        return when (title) {
            Category.ANIMAL     -> R.drawable.chuck_animal
            Category.CAREER     -> R.drawable.chuck_career
            Category.CELEBRITY  -> R.drawable.chuck_celebrity
            Category.DEV        -> R.drawable.chuck_dev
            Category.EXPLICIT   -> R.drawable.chuck_explicit
            Category.FASHION    -> R.drawable.chuck_fashion
            Category.FOOD       -> R.drawable.chuck_food
            Category.HISTORY    -> R.drawable.chuck_history
            Category.MONEY      -> R.drawable.chuck_money
            Category.MOVIE      -> R.drawable.chuck_movie
            Category.MUSIC      -> R.drawable.chuck_music
            Category.POLITICAL  -> R.drawable.chuck_politic
            Category.RELIGION   -> R.drawable.chuck_religion
            Category.SCIENCE    -> R.drawable.chuck_science
            Category.SPORT      -> R.drawable.chuck_sport
            Category.TRAVEL     -> R.drawable.chuck_travel
            else -> R.drawable.chuck_default
        }
    }

    fun bindDescWithTitle(title: String): Int {
        return when (title) {
            Category.ANIMAL     -> R.string.chuck_animal_phrase
            Category.CAREER     -> R.string.chuck_career_phrase
            Category.CELEBRITY  -> R.string.chuck_celebrity_phrase
            Category.DEV        -> R.string.chuck_dev_phrase
            Category.EXPLICIT   -> R.string.chuck_explicit_phrase
            Category.FASHION    -> R.string.chuck_fashion_phrase
            Category.FOOD       -> R.string.chuck_food_phrase
            Category.HISTORY    -> R.string.chuck_history_phrase
            Category.MONEY      -> R.string.chuck_money_phrase
            Category.MOVIE      -> R.string.chuck_movie_phrase
            Category.MUSIC      -> R.string.chuck_music_phrase
            Category.POLITICAL  -> R.string.chuck_political_phrase
            Category.RELIGION   -> R.string.chuck_religion_phrase
            Category.SCIENCE    -> R.string.chuck_science_phrase
            Category.SPORT      -> R.string.chuck_sport_phrase
            Category.TRAVEL     -> R.string.chuck_travel_phrase
            else -> R.string.chuck_default_phrase
        }
    }
}