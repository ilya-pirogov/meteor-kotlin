@file:Suppress("unused")

package lib.natives.meteor

import lib.annotation.ServerSide


@ServerSide
@native("this")
class PublishContext {
    /**
     * Access inside the publish function. The id of the logged-in user, or null if no user is logged in.
     */
    val userId: String?

    /**
     * Call inside the publish function. Informs the subscriber that a document has been added to the record set.
     */
    fun added(collection: String, id: String, fields: Json)

    /**
     * Call inside the publish function. Informs the subscriber that a document in the record set has been modified.
     *
     * @param collection The name of the collection that contains the changed document.
     * @param id The changed document's ID.
     * @param fields The fields in the document that have changed, together with their new values. If a field is
     *               not present in fields it was left unchanged; if it is present in fields and has a value of
     *               undefined it was removed from the document. If _id is present it is ignored.
     */
    fun changed(collection: String, id: String, fields: Json)

    /**
     * Call inside the publish function. Informs the subscriber that a document has been removed from the record set.
     *
     * @param collection The name of the collection that the document has been removed from.
     * @param id The ID of the document that has been removed.
     */
    fun removed(collection: String, id: String)

    /**
     * Call inside the publish function. Informs the subscriber that an initial, complete snapshot of the record
     * set has been sent. This will trigger a call on the client to the onReady callback passed to
     * Meteor.subscribe, if any.
     *
     * @see Meteor.subscribe
     */
    fun ready()

    /**
     * Call inside the publish function. Registers a callback function to run when the subscription is stopped.
     *
     * @param func The callback function
     */
    fun onStop(func: () -> Unit)

    /**
     * Call inside the publish function. Stops this client's subscription, triggering a call on the client to
     * the onStop callback passed to Meteor.subscribe, if any. If error is not a Meteor.Error, it will be sanitized.
     *
     * @param error The error to pass to the client.
     *
     * @see Meteor.subscribe
     * @see Meteor.Error
     */
    fun error(error: Meteor.Error)

    /**
     * Call inside the publish function. Stops this client's subscription and invokes the client's onStop
     * callback with no error.
     */
    fun stop()

    /**
     * Access inside the publish function. The incoming connection for this subscription.
     */
    val connection: ConnectionManager
}
