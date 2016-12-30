@file:Suppress("unused")

package lib.natives.ejson


class EqualOptions(
        /**
         * Compare in key sensitive order, if supported by the JavaScript implementation.
         * For example, {a: 1, b: 2} is equal to {b: 2, a: 1} only when keyOrderSensitive is false.
         * The default is false.
         */
        val keyOrderSensitive: Boolean = false
)
