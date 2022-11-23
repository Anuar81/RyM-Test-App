package com.anuar81.ryckandmortytestapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.anuar81.ryckandmortytestapp.R
import com.anuar81.ryckandmortytestapp.databinding.ItemCharacterBinding
import com.anuar81.ryckandmortytestapp.domain.character.CharacterData

class HomeAdapter(private val listener: CharacterObserver) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    var characterList: List<CharacterData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(characterList[position])
        holder.itemView.setOnClickListener {
            listener.itemListener(characterList[position])
        }
    }

    override fun getItemCount(): Int = characterList.size

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemCharacterBinding.bind(itemView)

        fun bind(character: CharacterData) = with(binding) {
            characterSpecies.text = character.species
            characterName.text = character.name
            characterImage.load(character.image)
        }
    }

    interface CharacterObserver {
        fun itemListener(character: CharacterData)
    }
}
