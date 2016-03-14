package lib.natives.mongo


class AllowDenyOptions(
    /**
     * The user userId wants to insert the document doc into the collection. Return true if this should be allowed.
     *
     * doc will contain the _id field if one was explicitly set by the client, or if there is an active transform.
     * You can use this to prevent users from specifying arbitrary _id fields.
     */
    var insert: ((userId: String, doc: dynamic) -> Boolean)? = null,

    /**
     * The user userId wants to update a document doc. (doc is the current version of the document from
     * the database, without the proposed update.) Return true to permit the change.
     *
     * fieldNames is an array of the (top-level) fields in doc that the client wants to modify,
     * for example ['name', 'score'].
     *
     * modifier is the raw Mongo modifier that the client wants to execute;
     * for example, {$set: {'name.first': "Alice"}, $inc: {score: 1}}.
     *
     * Only Mongo modifiers are supported (operations like $set and $push). If the user tries to replace
     * the entire document rather than use $-modifiers, the request will be denied without
     * checking the allow functions.
     */
    var update: ((userId: String, doc: dynamic, fieldNames: Array<String>, modifier: Modifier) -> Boolean)? = null,

    /**
     * The user userId wants to remove doc from the database. Return true to permit this.
     */
    var remove: ((userId: String, doc: dynamic) -> Boolean)? = null,

    /**
     * Optional performance enhancement. Limits the fields that will be fetched from the database
     * for inspection by your update and remove functions.
     */
    var fetch: (Array<String>)? = null,

    /**
     * Overrides transform on the  Collection. Pass null to disable transformation.
     */
    var transform: ((doc: Json) -> Any?)? = null
)
