@file:Suppress("unused")

package lib.natives.ejson


interface ICustomType {
    /**
     * Return the tag used to identify this type. This must match the tag used to register
     * this type with EJSON.addType.
     */
    fun typeName(): String

    /**
     * Serialize this instance into a JSON-compatible value.
     */
    fun toJSONValue(): Json

    /**
     * Return a value r such that this.equals(r) is true, and modifications to r do not affect this and vice versa.
     */
    fun clone(): ICustomType

    /**
     * Return true if other has a value equal to this; false otherwise.
     *
     * @param other Another object to compare this to.
     */
    fun equals(other: ICustomType): Boolean
}