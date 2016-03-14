@file:Suppress("unused")

package lib.natives.mongo


class CollectionOptions(
        var connection: Any? = null,
        var idGeneration: IdGeneration = IdGeneration.STRING,
        var transform: ((doc: Json) -> Any)? = null
)
