@file:Suppress("unused")

package lib.wrappers

import lib.natives.mongo.AllowDenyOptions
import lib.natives.mongo.CollectionOptions
import lib.natives.mongo.Mongo


fun Mongo.Collection.allow(options: AllowDenyOptions.() -> Unit) {
    val obj = AllowDenyOptions()
    obj.options()
    this.allow(obj)
}

/**
 * Allows to use it like:
 * @sample Mongo.Collection("posts") { idGeneration = ... }
 */
fun Mongo.Collection(name: String, options: CollectionOptions.() -> Unit): Mongo.Collection {
    val obj = CollectionOptions()
    obj.options()
    return Mongo.Collection(name, obj)
}

class Collection<T: Any>(name: String, val constructor: (doc: Json) -> T) {
    private val collection: Mongo.Collection

    init {
        collection = Mongo.Collection(name) {
            transform = { constructor(it) }
        }
    }

    fun findOne(id: String): T? {
        return collection.findOne(id)
    }
}
