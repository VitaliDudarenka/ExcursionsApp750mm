package by.a750mm.excursionsapp750mm.presentation.screen.portfolio.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import by.a750mm.excursionsapp750mm.R
import by.a750mm.excursionsapp750mm.domain.entity.Portfolio
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import kotlin.collections.ArrayList


class PortfolioListAdapter : RecyclerView.Adapter<PortfolioListAdapter.Holder>() {
    private var portfolioList: ArrayList<Portfolio>? = ArrayList()
    var listData: MutableList<Portfolio>? = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
            portfolioList!!.addAll(this.listData!!)
        }
    internal var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): Holder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.portfolio_item, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = listData!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val portfolio = listData!![position]
        holder.nameTextView.text = portfolio.name
        Picasso.get().load(portfolio.imgUrl).fit().error(R.drawable.rails).centerInside()
                .placeholder(R.drawable.progress_animation)
                .transform(CropCircleTransformation()).into(holder.portfImageView)

    }

    inner class Holder : RecyclerView.ViewHolder {
        var nameTextView: TextView
        var portfImageView: ImageView

        constructor(view: View) : super(view) {
            nameTextView = view.findViewById(R.id.nameTextView)
            portfImageView = view.findViewById(R.id.portfImageView)
            itemView.setOnClickListener {
                val portfolio = listData!![layoutPosition]
                onItemClickListener!!.onItemClick(portfolio)
            }
        }

    }
    interface OnItemClickListener {
        fun onItemClick(portfolio: Portfolio)
    }



}