@file:Suppress("unused")

package lib.natives.mongo


class FindOptions(
        val sort: Json? = null,
        val skip: Number? = null,
        val limit: Number? = null,
        val fields: Json? = null,
        val reactive: Boolean = true,
        val transform: ((Json) -> Any)? = null
)
