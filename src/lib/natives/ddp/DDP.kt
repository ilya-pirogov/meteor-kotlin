@file:Suppress("unused")

package lib.natives.ddp

import lib.natives.meteor.Meteor


@native
object DDP {
    /**
     * Connect to the server of a different Meteor application to subscribe to its document sets
     * and invoke its remote methods.
     *
     * @param url The URL of another Meteor application.
     */
    fun connect(url: String): Meteor
}