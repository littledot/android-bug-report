package com.littledot.androidbugreport

import android.content.Context
import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * A pattern for easier view binding with an [EpoxyHolder]
 *
 * See [com.airbnb.epoxy.kotlinsample.models.ItemEpoxyHolder] for a usage example.
 */
abstract class BaseEpoxyHolder : EpoxyHolder() {
    
    lateinit var rootView: View
    lateinit var context: Context
    
    override fun bindView(itemView: View) {
        rootView = itemView
        context = itemView.context
    }
    
    protected fun <V : View> bind(id: Int): ReadOnlyProperty<BaseEpoxyHolder, V> =
        Lazy { holder: BaseEpoxyHolder, prop ->
            holder.rootView.findViewById(id) as V?
                ?: throw IllegalStateException("View ID $id for '${prop.name}' not found.")
        }
    
    /**
     * Taken from Kotterknife.
     * https://github.com/JakeWharton/kotterknife
     */
    private class Lazy<V>(
        private val initializer: (BaseEpoxyHolder, KProperty<*>) -> V
    ) : ReadOnlyProperty<BaseEpoxyHolder, V> {
        
        private object EMPTY
        
        private var value: Any? = EMPTY
        
        override fun getValue(thisRef: BaseEpoxyHolder, property: KProperty<*>): V {
            if (value == EMPTY) {
                value = initializer(thisRef, property)
            }
            @Suppress("UNCHECKED_CAST") return value as V
        }
    }
}
