package com.example.affirmationsviews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmationsviews.R
import com.example.affirmationsviews.model.Affirmation

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */

class ItemAdapter (
    private val context: Context,
    private val dataset : List<Affirmation>,
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

//    nested class (only used by ItemAdapter).
// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder.
// Each data item is just an Affirmation object.
    class ItemViewHolder(
        private val view : View
    ) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
//            inflate actual list item view
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(view = adapterLayout)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size

//    called by the layout manager in order to replace the contents of a list item view.
    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//    get the item at the given position in the dataset.
        val item = dataset[position]

//    get instance of Resources class through context
//    updates the view holder to show the affirmation string.
        holder.textView.text = context.resources.getString(item.stringResource)
        holder.imageView.setImageResource(item.imageResourceId)
    }

}