package app

import lib.natives.meteor.CallbackResult
import lib.natives.meteor.Meteor
import lib.natives.meteor.MethodContext
import lib.wrappers.register

class User(var username: String, var email: String? = null) {
    operator fun invoke() {
        println(1)
    }

    operator fun invoke(a: String) {
        println(2)
    }
}

val bar = Meteor.wrapAsync({ enable: Boolean, resolve: CallbackResult<String> ->
    kotlin.js.println(this.isClient)
    if (enable) {
        resolve(null, "asd")
    }
}, Meteor)

fun MethodContext.baz(): Date {
    if (Meteor.isClient) {

    } else {
        this.setUserId("asd")
    }

    return Date()
}

object Methods {
    val baz = register("baz") { a: String ->
        return@register Date()

    }
}

fun main(args: Array<String>) {
    Methods.baz("khjg") { err, res ->
        res.getTime()
    }

    val async {}

}
