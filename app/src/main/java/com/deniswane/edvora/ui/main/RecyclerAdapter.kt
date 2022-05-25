package com.deniswane.edvora.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deniswane.edvora.R
import com.deniswane.edvora.databinding.ItemRideViewBinding
import com.deniswane.edvora.model.main.Ride

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val kode = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val kategori = arrayOf("Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana")

    private val isi = arrayOf("pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21")

    var rides = mutableListOf<Ride>()

    fun setRideList(rides: List<Ride>) {
        this.rides = rides.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        /*val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_ride_view, viewGroup, false)*/
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemRideViewBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        /*viewHolder.itemKode.text = kode[i]
        viewHolder.itemKategori.text = kategori[i]
        viewHolder.itemIsi.text = isi[i]*/
        val ride = rides[i]
        holder.binding.rideIdName.text = ride.id.toString();
        holder.binding.originStationName.text = ride.stationPath[0].toString();
        holder.binding.stationPathName.text = ride.stationPath.toString();

        holder.binding.stateName.text = ride.state;
        holder.binding.cityName.text = ride.city;
        holder.binding.dateName.text = ride.date;
        holder.binding.distanceName.text = ride.date;

        Glide.with(holder.itemView.context)
            .load(ride.mapUrl)
            .placeholder(R.drawable.denis)
            .into(holder.binding.map)
    }

    override fun getItemCount(): Int {
        return rides.size
    }

    inner class ViewHolder(val binding: ItemRideViewBinding) : RecyclerView.ViewHolder(binding.root) {

        var rideId: TextView
        /* var itemKategori: TextView
        var itemIsi: TextView */
        init {
            rideId = itemView.findViewById(R.id.ride_id_name)
            //Picasso.with(view.context).load(photo.url).into(view.itemImage)
           /* itemKategori = itemView.findViewById(R.id.kategori)
            itemIsi = itemView.findViewById(R.id.isiPertanyaan)
*/
            itemView.setOnClickListener {
  /*              var position: Int = getAdapterPosition()
                val context = itemView.context
                val intent = Intent(context, DetailPertanyaan::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemKode.text)
                    putExtra("CATEGORY", itemKategori.text)
                    putExtra("CONTENT", itemIsi.text)
                }
                context.startActivity(intent)
  */          }
        }
    }
}

