@file:Suppress("unused")

package lib.natives.meteor

import lib.annotation.ClientSide


@ClientSide
interface Status {
    /**
     * True if currently connected to the server. If false, changes and method invocations will be queued
     * up until the connection is reestablished.
     */
    val connected: Boolean

    /**
     * Describes the current reconnection status. The possible values are connected (the connection is up and running),
     * connecting (disconnected and trying to open a new connection), failed (permanently failed to connect; e.g.,
     * the client and server support different versions of DDP), waiting (failed to connect and waiting
     * to try to reconnect) and offline (user has disconnected the connection).
     */
    val status: String

    /**
     * The number of times the client has tried to reconnect since the connection was lost. 0 when connected.
     */
    val retryCount: Int

    /**
     * The estimated time of the next reconnection attempt. To turn this into an interval until the next reconnection,
     * use  retryTime - (new Date()).getTime(). This key will be set only when status is waiting.
     */
    val retryTime: Int?

    /**
     * If status is failed, a description of why the connection failed.
     */
    val reason: String?
}