@file:Suppress("unused")
@file:JsModule("meteor/ejson")

package lib.natives.ejson

external object EJSON {
    /**
     * Parse a string into an EJSON value. Throws an error if the string is not valid EJSON.
     *
     * @param str A string to parse into an EJSON value.
     */
    fun parse(str: String): Json

    /**
     * Serialize a value to a string.
     *
     * For EJSON values, the serialization fully represents the value. For non-EJSON values, serializes
     * the same way as JSON.stringify.
     *
     * @param value A value to stringify.
     */
    fun stringify(value: Any, option: StringifyOptions): String

    /**
     * Deserialize an EJSON value from its plain JSON representation.
     *
     * @param value A value to deserialize into EJSON.
     */
    fun fromJSONValue(value: Any): Json

    /**
     * Serialize an EJSON-compatible value into its plain JSON representation.
     *
     * @param value A value to serialize to plain JSON.
     */
    fun toJSONValue(value: Any): Json

    /**
     * Return true if a and b are equal to each other. Return false otherwise. Uses the equals method
     * on a if present, otherwise performs a deep comparison.
     */
    fun <T> equals(a: Comparable<T>, b: Comparable<T>, options: EqualOptions): Boolean

    /**
     * Return a deep copy of val.
     *
     * @param value A value to copy.
     */
    fun clone(value: Any): Json

    /**
     * Allocate a new buffer of binary data that EJSON can serialize.
     *
     * @param size The number of bytes of binary data to allocate.
     */
    fun newBinary(size: Int): Array<Byte>

    /**
     * Returns true if x is a buffer of binary data, as returned from EJSON.newBinary.
     *
     * @param x The variable to check.
     */
    fun isBinary(x: Any): Boolean

    /**
     * Add a custom datatype to EJSON.
     *
     * @param name A tag for your custom type; must be unique among custom data types defined in your project,
     *             and must match the result of your type's typeName method.
     */
    fun <T: ICustomType> addType(name: String, factory: (Json) -> T)
}
