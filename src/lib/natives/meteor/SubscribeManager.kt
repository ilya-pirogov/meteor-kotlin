@file:Suppress("unused")

package lib.natives.meteor


interface SubscribeManager {
    /**
     * Cancel the subscription. This will typically result in the server directing the client to remove
     * the subscription's data from the client's cache.
     */
    fun stop()

    /**
     * True if the server has marked the subscription as ready. A reactive data source.
     */
    fun ready(): Boolean

    /**
     * The id of the subscription this handle is for. When you run Meteor.subscribe inside of Tracker.autorun,
     * the handles you get will always have the same subscriptionId field. You can use this to deduplicate
     * subscription handles if you are storing them in some data structure.
     */
    val subscriptionId: String
}