@file:Suppress("UnsafeCastFromDynamic")
package lib.wrappers

import lib.natives.meteor.CallbackResult
import lib.natives.meteor.Meteor
import lib.natives.meteor.MethodContext as MC

fun <R> register(n: String, f: MC.() -> R): (cb: CallbackResult<R>?) -> Unit = proxy(n, f)
fun <A1, R> register(n: String, f: MC.(a1: A1) -> R): (a1: A1, cb: CallbackResult<R>?) -> Unit = proxy(n, f)

@Suppress("UnsafeCastFromDynamic")
private fun proxy(name: String, func: Any): dynamic {
    val obj = js("function(s,f) {return {s: f}}")(name, func)
    Meteor.methods(obj)
    return js("function(n) { return Meteor.call.bind(Meteor, n); }")(name)
}
