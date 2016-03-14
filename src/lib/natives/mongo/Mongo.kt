@file:Suppress("unused")

package lib.natives.mongo


@native
object Mongo {
    class Collection(name: String, options: CollectionOptions? = null) {
        /**
         * Find the documents in a collection that match the selector.
         */
        fun find(id: String): Cursor

        /**
         * Find the documents in a collection that match the selector.
         */
        fun find(id: ObjectID): Cursor

        /**
         * Find the documents in a collection that match the selector.
         */
        fun find(id: Json): Cursor
        fun find(selector: Expression): Cursor

        /**
         * Finds the first document that matches the selector, as ordered by sort and skip options.
         */
        fun findOne(id: String): dynamic

        /**
         * Finds the first document that matches the selector, as ordered by sort and skip options.
         */
        fun findOne(id: ObjectID): dynamic

        /**
         * Finds the first document that matches the selector, as ordered by sort and skip options.
         */
        fun findOne(id: Json): dynamic
        fun findOne(selector: Expression): dynamic

        /**
         * Insert a document in the collection. Returns its unique _id.
         */
        fun insert(doc: Json): String?

        /**
         * Insert a document in the collection. Returns its unique _id.
         */
        fun insert(doc: Json, callback: (error: Error?, id: String?) -> Unit)

        /**
         * Modify one or more documents in the collection. Returns the number of affected documents.
         */
        fun update(selector: Expression, modifier: Modifier, options: UpdateOptions? = null): Int?

        /**
         * Modify one or more documents in the collection. Returns the number of affected documents.
         */
        fun update(selector: Expression, modifier: Modifier, options: UpdateOptions? = null, callback: (Error?, Int?) -> Unit)

        /**
         * Modify one or more documents in the collection, or insert one if no matching documents were found.
         * Returns an object with keys numberAffected (the number of documents modified) and insertedId
         * (the unique _id of the document that was inserted, if any).
         */
        fun upsert(selector: Expression, modifier: Modifier, options: UpdateOptions? = null): Int?

        /**
         * Modify one or more documents in the collection, or insert one if no matching documents were found.
         * Returns an object with keys numberAffected (the number of documents modified) and insertedId
         * (the unique _id of the document that was inserted, if any).
         */
        fun upsert(selector: Expression, modifier: Modifier, options: UpdateOptions? = null, callback: (Error?, Int?) -> Unit)

        /**
         * Remove documents from the collection
         */
        fun remove(selector: Expression): Int?

        /**
         * Remove documents from the collection
         */
        fun remove(selector: Expression, callback: (Error?, Int?) -> Unit)

        /**
         * Allow users to write directly to this collection from client code, subject to limitations you define.
         */
        fun allow(options: AllowDenyOptions)

        /**
         * Override allow rules.
         */
        fun deny(options: AllowDenyOptions)
    }

    class Cursor {
        /**
         * Call callback once for each matching document, sequentially and synchronously.
         *
         * @param callback Function to call. It will be called with three arguments: the document, a 0-based index,
         *                 and cursor itself.
         * @param thisArg An object which will be the value of this inside callback.
         */
        fun forEach(callback: (dynamic, Int, Cursor) -> Unit, thisArg: Any? = null)

        /**
         * Map callback over all matching documents. Returns an Array.
         *
         * @param callback Function to call. It will be called with three arguments: the document, a 0-based index,
         *                 and cursor itself.
         * @param thisArg An object which will be the value of this inside callback.
         */
        fun <T> map(callback: (dynamic, Int, Cursor) -> T, thisArg: Any? = null): Array<T>

        /**
         * Return all matching documents as an Array.
         */
        fun fetch(): Array<dynamic>

        /**
         * Returns the number of documents that match a query.
         */
        fun count(): Int

        /**
         * Watch a query. Receive callbacks as the result set changes.
         *
         * @param callbacks Functions to call to deliver the result set as it changes
         */
        fun observe(callbacks: ObserveOptions): ObserveManager

        /**
         * Watch a query. Receive callbacks as the result set changes. Only the differences between
         * the old and new documents are passed to the callbacks.
         *
         * @param callback Functions to call to deliver the result set as it changes
         */
        fun observeChanges(callback: ObserveChangesOptions): ObserveManager
    }

    class ObjectID(hexString: String? = null)
}
