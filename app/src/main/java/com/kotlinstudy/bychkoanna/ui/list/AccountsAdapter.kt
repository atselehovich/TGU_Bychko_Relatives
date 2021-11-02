package com.kotlinstudy.bychkoanna.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinstudy.bychkoanna.R
import com.kotlinstudy.bychkoanna.ui.AccountPresentation
import kotlinx.android.synthetic.main.list_item.view.*

/* AccountsAdapter должен быть наследником RecyclerView.Adapter
 в качестве дженерик-параметра сюда передается AccountViewHolder,
 который определен ниже */

class AccountsAdapter(
    private val itemViewClick: (AccountPresentation)
    -> Unit
) : RecyclerView.Adapter<AccountsAdapter.AccountViewHolder>() {

    private var items: List<AccountPresentation> = emptyList()

    // метод для установки новых элементов?
    // items элементы
        fun setItems(items: List<AccountPresentation>) {
        this.items = items
        notifyDataSetChanged()
    }


    // overriide - замещенный метод

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            AccountViewHolder {
        //передаем элементы в layout list_item
        //здесь важно, какой layout указать
        // !!! дописать дальше конспекты по лекциям
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return AccountViewHolder(itemView, itemViewClick)
    }

    override fun getItemCount(): Int = items.size

// onBindViewHolder - привязать элемент к какой-то view с помощью viewholder
    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val item = getItem(position)

        item?.let { holder.bind(it) }
    }

    private fun getItem(position: Int): AccountPresentation? {
        return items.getOrNull(position)
    }

    // здесь определен класс AccountViewHolder
    class AccountViewHolder(
        itemView: View, val viewClick: (AccountPresentation)
        -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        var latestItem: AccountPresentation? = null

        init {
            with(itemView) {
                setOnClickListener { latestItem?.let { viewClick(it) } }
            }
        }

        fun bind(item: AccountPresentation) {
            latestItem = item

            with(itemView) {
                titleView.text = item.name
                // descriptionView.text = item.contents
            }

        }
    }

}