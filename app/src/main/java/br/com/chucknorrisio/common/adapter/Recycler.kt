package br.com.chucknorrisio.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.RecyclerView

abstract class Recycler {
    abstract class Adapter<T, V : RecyclerView.ViewHolder> constructor(
        private val context: Context
    ) : RecyclerView.Adapter<V>(), LifecycleObserver {

        private val adapterObserver: AdapterDataObserver by lazy { AdapterDataObserver() }
        private var changedListener: OnCollectionChangedListener? = null
        private var list: List<T> = listOf()

        private fun getItem(position: Int): T = list[position]

        override fun getItemCount(): Int = list.size

        open fun onBindViewHolder(holder: V, item: T) {}

        override fun onBindViewHolder(holder: V, position: Int) {
            onBindViewHolder(holder, getItem(position), position)
        }

        open fun onBindViewHolder(holder: V, item: T, position: Int) {
            onBindViewHolder(holder, item)
        }

        protected fun inflate(parent: ViewGroup, @LayoutRes layout: Int): View {
            return LayoutInflater.from(context).inflate(layout, parent, false)
        }

        fun setOnCollectionChangedListener(listener: OnCollectionChangedListener) {
            changedListener = listener
            registerAdapterDataObserver(adapterObserver)
        }

        fun setDataList(list: List<T>) {
            this.list = list
            notifyDataSetChanged()
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        private fun registerAdapterObserver() {
            if (changedListener != null) {
                registerAdapterDataObserver(adapterObserver)
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        private fun unregisterAdapterObserver() {
            if (changedListener != null) {
                unregisterAdapterDataObserver(adapterObserver)
                changedListener = null
            }
        }

        private inner class AdapterDataObserver : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                collectionChanged()
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                collectionChanged()
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                super.onItemRangeRemoved(positionStart, itemCount)
                collectionChanged()
            }

            private fun collectionChanged() {
                changedListener?.onCollectionChanged((itemCount == 0))
            }
        }
    }
}