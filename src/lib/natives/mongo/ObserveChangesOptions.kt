@file:Suppress("unused")

package lib.natives.mongo


class ObserveChangesOptions(
        /**
         * A new document entered the result set. It has the id and fields specified.
         * fields contains all fields of the document excluding the _id field
         */
        var added: (id: String, fields: Array<String>) -> Unit,

        /**
         * A new document entered the result set. It has the id and fields specified. fields contains all fields of
         * the document excluding the _id field. The new document is before the document identified by before, or
         * at the end if before is null.
         */
        var addedBefore: (id: String, fields: Array<String>, before: String?) -> Unit,

        /**
         * The document identified by id has changed. fields contains the changed fields with their new values.
         * If a field was removed from the document then it will be present in fields with a value of undefined.
         */
        var changed: (id: String, fields: Array<String>) -> Unit,

        /**
         * The document identified by id changed its position in the ordered result set, and now appears before
         * the document identified by before.
         */
        var movedBefore: (id: String, before: String?) -> Unit,

        /**
         * The document identified by id was removed from the result set.
         */
        var removed: (id: String) -> Unit
)