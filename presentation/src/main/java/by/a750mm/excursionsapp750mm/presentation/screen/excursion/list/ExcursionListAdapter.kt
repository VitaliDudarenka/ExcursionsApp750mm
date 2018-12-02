package by.a750mm.excursionsapp750mm.presentation.screen.excursion.list

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ExcursionListAdapter : RecyclerView.Adapter<ExcursionListAdapter.Holder>() {
    private var excursionlist: ArrayList<Excursion>? = ArrayList()
    @SuppressLint("SimpleDateFormat")
    private val df2 = SimpleDateFormat("dd/MM/yyyy")
    var listData: MutableList<Excursion>? = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
            excursionlist!!.addAll(this.listData!!)
        }
    internal var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): Holder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.excursion_item, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = listData!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val excursion = listData!![position]
        holder.nameTextView.text = excursion.name
        val millis = System.currentTimeMillis() % 1000
        if (excursion.nextDate < millis) {
            holder.dateTextView.text = "Планируется"
            holder.dateTextView.setTextColor(Color.RED)
        } else {
            val date = Date(excursion.nextDate)
            val dateText = df2.format(date)
            holder.dateTextView.text = dateText
            holder.dateTextView.setTextColor(Color.BLACK)
        }
        Picasso.get().load(excursion.imgUrl).fit().error(R.drawable.rails).centerInside()
                .placeholder(R.drawable.progress_animation).transform(CropCircleTransformation()).into(holder.excImageView)

    }

    inner class Holder : RecyclerView.ViewHolder {
        var nameTextView: TextView
        var dateTextView: TextView
        var excImageView: ImageView

        constructor(view: View) : super(view) {
            nameTextView = view.findViewById(R.id.nameTextView)
            dateTextView = view.findViewById(R.id.dateTextView)
            excImageView = view.findViewById(R.id.excImageView)
            itemView.setOnClickListener {
                val excursion = listData!![layoutPosition]
                onItemClickListener!!.onItemClick(excursion)
            }
        }

    }
    interface OnItemClickListener {
        fun onItemClick(excursion: Excursion)
    }



}