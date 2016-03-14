@file:Suppress("unused")

package lib.natives.meteor

import lib.annotation.ClientSide
import lib.annotation.ServerSide


@native
object Meteor {
    /**
     * True if running in client environment.
     */
    val isClient: Boolean

    /**
     * True if running in server environment.
     */
    val isServer: Boolean

    /**
     * True if running in a Cordova mobile environment.
     */
    val isCordova: Boolean

    /**
     * Run code when a client or a server starts.
     *
     * @param func A function to run on startup.
     */
    fun startup(func: () -> Unit): Unit

    /**
     * Generate an absolute URL pointing to the application. The server reads from the ROOT_URL environment
     * variable to determine where it is running. This is taken care of automatically for apps deployed
     * with meteor deploy, but must be provided when using meteor build.
     *
     * @param path A path to append to the root URL. Do not include a leading "/".
     */
    fun absoluteUrl(path: String = "", options: AbsoluteUrlOptions = AbsoluteUrlOptions())

    /**
     * Meteor.settings contains deployment-specific configuration options. You can initialize settings by passing
     * the --settings option (which takes the name of a file containing JSON data) to meteor run or meteor deploy.
     * When running your server directly (e.g. from a bundle), you instead specify settings by putting the JSON
     * directly into the METEOR_SETTINGS environment variable. If the settings object contains a key named public,
     * then Meteor.settings.public will be available on the client as well as the server. All other properties of
     * Meteor.settings are only defined on the server. You can rely on Meteor.settings and Meteor.settings.public
     * being defined objects (not undefined) on both client and server even if there are no settings specified.
     * Changes to Meteor.settings.public at runtime will be picked up by new client connections.
     */
    val settings: Json

    /**
     * Meteor.release is a string containing the name of the release with which the project was built
     * (for example, "1.2.3"). It is undefined if the project was built using a git checkout of Meteor.
     */
    val release: String

    /**
     * Publish a record set.
     *
     * @param name Name of the record set. If null, the set has no name, and the record set is automatically
     *             sent to all connected clients.
     * @param func Function called on the server each time a client subscribes. Inside the function, this is
     *             the publish handler object, described below. If the client passed arguments to subscribe,
     *             the function is called with the same arguments.
     */
    @ServerSide
    fun publish(name: String, func: PublishContext.() -> Unit)

    /**
     * Subscribe to a record set. Returns a handle that provides stop() and ready() methods.
     */
    @ClientSide
    fun subscribe(name: String, vararg args: Any, callbacks: SubscribeOptions): SubscribeManager

    /**
     * Defines functions that can be invoked over the network by clients.
     */
    fun methods(methods: dynamic)

    /**
     * Invokes a method passing any number of arguments.
     */
    fun call(name: String, vararg args: Json, asyncCallback: dynamic = null): dynamic

    /**
     * Invoke a method passing an array of arguments.
     */
    fun apply(name: String, args: Array<Json>, options: AbsoluteUrlOptions): dynamic

    /**
     * Get the current connection status. A reactive data source.
     */
    @ClientSide
    fun status(): Status

    /**
     * Force an immediate reconnection attempt if the client is not connected to the server.
     *
     * This method does nothing if the client is already connected.
     */
    @ClientSide
    fun reconnect()

    /**
     * Disconnect the client from the server.
     */
    @ClientSide
    fun disconnect()

    /**
     * Register a callback to be called when a new DDP connection is made to the server.
     *
     * @param callback The function to call when a new DDP connection is established
     */
    @ServerSide
    fun onConnection(callback: (connection: Connection) -> Unit): ConnectionManager



    class Error(error: String, reason: String? = null, details: String? = null)
}