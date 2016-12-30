@file:Suppress("unused")

package lib.natives.meteor

import lib.annotation.ServerSide


@ServerSide
interface ConnectionManager {
    /**
     * Calling stop unregisters the callback, so that this callback will no longer be called on new connections.
     */
    fun stop()
}
