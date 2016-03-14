@file:Suppress("unused")

package lib.natives.ejson


class StringifyOptions(
        /**
         * Indents objects and arrays for easy readability. When true, indents by 2 spaces; when an integer,
         * indents by that number of spaces; and when a string, uses the string as the indentation pattern.
         */
        var indent: Number? = null,

        /**
         * When true, stringifies keys in an object in sorted order.
         */
        var canonical: Boolean = false
)
