package lib

import lib.natives.meteor.PublishContext
import lib.natives.meteor.SubscribeManager


class Publish<A> (val name: String, func: PublishContext.(arg1: A) -> Unit) {
    init {
        js("Meteor.publish")(name, func)
    }

    fun subscribe(arg1: A): SubscribeManager {
        return js("Meteor.subscribe")(name, arg1)
    }
}
