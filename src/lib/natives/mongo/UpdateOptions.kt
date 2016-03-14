@file:Suppress("unused")

package lib.natives.mongo


class UpdateOptions(
        /**
         * True to modify all matching documents; false to only modify one of the matching documents (the default).
         */
        val multi: Boolean = false,

        /**
         * True to insert a document if no matching documents are found.
         */
        val upsert: Boolean = false
)