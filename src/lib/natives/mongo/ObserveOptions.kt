@file:Suppress("unused")

package lib.natives.mongo


class ObserveOptions(
        /**
         * A new document document entered the result set.
         */
        var added: (document: dynamic) -> Unit,

        /**
         * A new document document entered the result set. The new document appears at position atIndex. It is
         * immediately before the document whose _id is before. before will be null if the new document is
         * at the end of the results.
         */
        var addedAt: (document: dynamic, atIndex: Int, before: String?) -> Unit,

        /**
         * The contents of a document were previously oldDocument and are now newDocument.
         */
        var changed: (newDocument: dynamic, oldDocument: dynamic) -> Unit,

        /**
         * The contents of a document were previously oldDocument and are now newDocument.
         * The position of the changed document is atIndex.
         */
        var changedAt: (newDocument: dynamic, oldDocument: dynamic, atIndex: Int) -> Unit,

        /**
         * The document oldDocument is no longer in the result set.
         */
        var removed: (oldDocument: dynamic) -> Unit,

        /**
         * The document oldDocument is no longer in the result set. It used to be at position atIndex.
         */
        var removedAt: (oldDocument: dynamic, atIndex: Int) -> Unit,

        /**
         * A document changed its position in the result set, from fromIndex to toIndex (which is before
         * the document with id before). Its current contents is document.
         */
        var movedTo: (document: dynamic, fromIndex: Int, toIndex: Int, before: String?) -> Unit
)