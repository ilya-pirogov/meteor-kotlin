@file:Suppress("unused")

package lib.natives.mongo

import java.util.*


class Expression() {
    constructor(field: String, operator: String, value: Any?) : this() {
        this[field] = json("$" + operator to value)
    }

    constructor(field: String, value: Any) : this() {
        this[field] = value
    }

    constructor(left: Expression, operator: String, right: Expression) : this() {
        if (operator in arrayOf("and", "or", "nor")) {
            var array: ArrayList<Expression>? = this["$" + operator]
            if (array == null) {
                array = arrayListOf<Expression>()
                this["$" + operator] = array
            }
            array.add(left)
            array.add(right)
        }
    }

    operator fun get(propertyName: String): dynamic {
        return js("this")[propertyName]
    }

    operator fun set(propertyName: String, value: dynamic): Unit {
        js("this")[propertyName] = value
    }
}

/**
 * Matches values that are equal to a specified value.
 */
infix fun String.eq(value: Any?): Expression {
    return Expression(this, "eq", value)
}

/**
 * Matches values that are greater than a specified value.
 */
infix fun String.gt(value: Any): Expression {
    return Expression(this, "gt", value)
}

/**
 * Matches values that are greater than or equal to a specified value.
 */
infix fun String.gte(value: Any): Expression {
    return Expression(this, "gte", value)
}

/**
 * Matches values that are less than a specified value.
 */
infix fun String.lt(value: Any): Expression {
    return Expression(this, "lt", value)
}

/**
 * Matches values that are less than or equal to a specified value.
 */
infix fun String.lte(value: Any): Expression {
    return Expression(this, "lte", value)
}

/**
 * Matches all values that are not equal to a specified value.
 */
infix fun String.ne(value: Any?): Expression {
    return Expression(this, "ne", value)
}

/**
 * Matches any of the values specified in an array.
 */
infix fun <T> String.ina(value: ArrayList<T>): Expression {
    return Expression(this, "in", value)
}

/**
 * Matches none of the values specified in an array.
 */
infix fun <T> String.nin(value: ArrayList<T>): Expression {
    return Expression(this, "nin", value)
}

/**
 * Joins query clauses with a logical OR returns all documents that match the conditions of either clause.
 */
infix fun Expression.or(expression: Expression): Expression {
    return Expression(this, "or", expression)
}

/**
 * Joins query clauses with a logical AND returns all documents that match the conditions of both clauses.
 */
infix fun Expression.and(expression: Expression): Expression {
    return Expression(this, "and", expression)
}

/**
 * Joins query clauses with a logical NOR returns all documents that fail to match both clauses.
 */
infix fun Expression.nor(expression: Expression): Expression {
    return Expression(this, "nor", expression)
}

/**
 * Inverts the effect of a query expression and returns documents that do not match the query expression.
 */
operator fun Expression.not(): Expression {
    // Yeah, I know it's ugly :(
    val field: String = js("Object.keys")(this)[0]
    return Expression(field, "not", this[field])
}

/**
 * Matches documents that have the specified field.
 */
infix fun String.exists(value: Boolean): Expression {
    return Expression(this, "exists", value)
}

/**
 * Selects documents if a field is of the specified type.
 */
infix fun String.type(value: String): Expression {
    return Expression(this, "type", value)
}

/**
 * Performs a modulo operation on the value of a field and selects documents with a specified result.
 */
infix fun String.mod(value: Pair<Int, Int>): Expression {
    return Expression(this, "mod", arrayOf(value.first, value.second))
}

/**
 * Selects documents where values match a specified regular expression.
 */
infix fun String.regex(value: Regex): Expression {
    return Expression(this, "regex", value)
}

/**
 * Performs text search.
 */
fun search(search: String, language: String? = null, caseSensitive: Boolean? = null, diacriticSensitive: Boolean? = null): Expression {
    val value = json("\$search" to search)
    if (language != null) {
        value["\$language"] = language
    }

    if (caseSensitive != null) {
        value["\$caseSensitive"] = caseSensitive
    }

    if (diacriticSensitive != null) {
        value["\$diacriticSensitive"] = diacriticSensitive
    }

    return Expression("\$text", value)
}

/**
 * Matches documents that satisfy a JavaScript expression.
 */
fun where(func: dynamic.() -> Boolean): Expression {
    return Expression("\$where", func)
}

/**
 * Selects geometries within a bounding GeoJSON geometry. The 2dsphere and 2d indexes support $geoWithin.
 */
infix fun String.geoWithin(geometry: Json): Expression {
    return Expression(this, "geoWithin", geometry)
}

/**
 * Selects geometries that intersect with a GeoJSON geometry. The 2dsphere index supports $geoIntersects.
 */
infix fun String.geoIntersects(geometry: Json): Expression {
    return Expression(this, "geoIntersects", geometry)
}

/**
 * Returns geospatial objects in proximity to a point. Requires a geospatial index. The 2dsphere and 2d indexes support $near.
 */
infix fun String.near(geometry: Json): Expression {
    return Expression(this, "near", geometry)
}

/**
 * Returns geospatial objects in proximity to a point on a sphere. Requires a geospatial index. The 2dsphere and 2d indexes support $nearSphere.
 */
infix fun String.nearSphere(geometry: Json): Expression {
    return Expression(this, "nearSphere", geometry)
}

/**
 * Matches arrays that contain all elements specified in the query.
 */
infix fun String.all(value: Array<Any>): Expression {
    return Expression(this, "all", value)
}

/**
 * Returns geospatial objects in proximity to a point on a sphere. Requires a geospatial index. The 2dsphere and 2d indexes support $nearSphere.
 */
infix fun String.elemMatch(elem: Json): Expression {
    return Expression(this, "elemMatch", elem)
}

/**
 * Selects documents if the array field is a specified size.
 */
infix fun String.size(value: Int): Expression {
    return Expression(this, "size", value)
}

/**
 * Matches numeric or binary values in which a set of bit positions all have a value of 1.
 */
infix fun String.bitsAllSet(bitmask: Long): Expression {
    return Expression(this, "bitsAllSet", bitmask)
}

/**
 * Matches numeric or binary values in which any bit from a set of bit positions has a value of 1.
 */
infix fun String.bitsAnySet(bitmask: Long): Expression {
    return Expression(this, "bitsAnySet", bitmask)
}

/**
 * Matches numeric or binary values in which a set of bit positions all have a value of 0.
 */
infix fun String.bitsAllClear(bitmask: Long): Expression {
    return Expression(this, "bitsAllClear", bitmask)
}

/**
 * Matches numeric or binary values in which any bit from a set of bit positions has a value of 0.
 */
infix fun String.bitsAnyClear(bitmask: Long): Expression {
    return Expression(this, "bitsAnyClear", bitmask)
}
