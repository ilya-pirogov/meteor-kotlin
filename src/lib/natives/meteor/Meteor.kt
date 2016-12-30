@file:Suppress("unused")
@file:JsModule("meteor/meteor")

package lib.natives.meteor

import lib.annotation.ClientSide
import lib.annotation.ServerSide

typealias CallbackResult<R> = (error: Meteor.Error?, result: R) -> Unit

typealias CallbackAsync<R, C> = C.(cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA1<A1, R, C> = C.(a1: A1, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA2<A1, A2, R, C> = C.(a1: A1, a2: A2, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA3<A1, A2, A3, R, C> = C.(a1: A1, a2: A2, a3: A3, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA4<A1, A2, A3, A4, R, C> = C.(a1: A1, a2: A2, a3: A3, a4: A4, CallbackResult<R>) -> Unit
typealias CallbackAsyncA5<A1, A2, A3, A4, A5, R, C> = C.(a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA6<A1, A2, A3, A4, A5, A6, R, C> = C.(a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA7<A1, A2, A3, A4, A5, A6, A7, R, C> = C.(a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, a7: A7, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA8<A1, A2, A3, A4, A5, A6, A7, A8, R, C> = C.(a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, a7: A7, a8: A8, cb: CallbackResult<R>) -> Unit
typealias CallbackAsyncA9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R, C> = C.(a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, a7: A7, a8: A8, a9: A9, cb: CallbackResult<R>) -> Unit

typealias CallbackSync<R> = () -> R
typealias CallbackSyncA1<A1, R> = (a1: A1) -> R
typealias CallbackSyncA2<A1, A2, R> = (a1: A1, a2: A2) -> R
typealias CallbackSyncA3<A1, A2, A3, R> = (a1: A1, a2: A2, a3: A3) -> R
typealias CallbackSyncA4<A1, A2, A3, A4, R> = (a1: A1, a2: A2, a3: A3, a4: A4) -> R
typealias CallbackSyncA5<A1, A2, A3, A4, A5, R> = (a1: A1, a2: A2, a3: A3, a4: A4, a5: A5) -> R
typealias CallbackSyncA6<A1, A2, A3, A4, A5, A6, R> = (a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6) -> R
typealias CallbackSyncA7<A1, A2, A3, A4, A5, A6, A7, R> = (a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, a7: A7) -> R
typealias CallbackSyncA8<A1, A2, A3, A4, A5, A6, A7, A8, R> = (a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, a7: A7, a8: A8) -> R
typealias CallbackSyncA9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R> = (a1: A1, a2: A2, a3: A3, a4: A4, a5: A5, a6: A6, a7: A7, a8: A8, a9: A9) -> R

external interface MethodContext {
    val isSimulation: Boolean
    val connection: Connection
    val userId: String
    fun setUserId(userId: String)
    fun unblock()
}

external object Meteor {
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
     * True if running in production environment.
     */
    val isDevelopment: Boolean

    /**
     * Run code when a client or a server starts.
     *
     * @param func A function to run on startup.
     */
    fun startup(func: () -> Unit): Unit

    /**
     * Wrap a function that takes a callback function as its final parameter.
     * The signature of the callback of the wrapped function should be
     * function(error, result){}. On the server, the wrapped function can be used
     * either synchronously (without passing a callback) or asynchronously
     * (when a callback is passed). On the client, a callback is always required;
     * errors will be logged if there is no callback. If a callback is provided,
     * the environment captured when the original function was called will be
     * restored in the callback.
     *
     * @param func A function that takes a callback as its final parameter
     */
    fun <R> wrapAsync(func: CallbackAsync<R, Unit>): CallbackSync<R>
    fun <A1, R> wrapAsync(func: CallbackAsyncA1<A1, R, Unit>): CallbackSyncA1<A1, R>
    fun <A1, A2, R> wrapAsync(func: CallbackAsyncA2<A1, A2, R, Unit>): CallbackSyncA2<A1, A2, R>
    fun <A1, A2, A3, R> wrapAsync(func: CallbackAsyncA3<A1, A2, A3, R, Unit>): CallbackSyncA3<A1, A2, A3, R>
    fun <A1, A2, A3, A4, R> wrapAsync(func: CallbackAsyncA4<A1, A2, A3, A4, R, Unit>): CallbackSyncA4<A1, A2, A3, A4, R>
    fun <A1, A2, A3, A4, A5, R> wrapAsync(func: CallbackAsyncA5<A1, A2, A3, A4, A5, R, Unit>): CallbackSyncA5<A1, A2, A3, A4, A5, R>
    fun <A1, A2, A3, A4, A5, A6, R> wrapAsync(func: CallbackAsyncA6<A1, A2, A3, A4, A5, A6, R, Unit>): CallbackSyncA6<A1, A2, A3, A4, A5, A6, R>
    fun <A1, A2, A3, A4, A5, A6, A7, R> wrapAsync(func: CallbackAsyncA7<A1, A2, A3, A4, A5, A6, A7, R, Unit>): CallbackSyncA7<A1, A2, A3, A4, A5, A6, A7, R>
    fun <A1, A2, A3, A4, A5, A6, A7, A8, R> wrapAsync(func: CallbackAsyncA8<A1, A2, A3, A4, A5, A6, A7, A8, R, Unit>): CallbackSyncA8<A1, A2, A3, A4, A5, A6, A7, A8, R>
    fun <A1, A2, A3, A4, A5, A6, A7, A8, A9, R> wrapAsync(func: CallbackAsyncA9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R, Unit>): CallbackSyncA9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R>

    /**
     * Wrap a function that takes a callback function as its final parameter.
     * The signature of the callback of the wrapped function should be
     * function(error, result){}. On the server, the wrapped function can be used
     * either synchronously (without passing a callback) or asynchronously
     * (when a callback is passed). On the client, a callback is always required;
     * errors will be logged if there is no callback. If a callback is provided,
     * the environment captured when the original function was called will be
     * restored in the callback.
     *
     * @param func A function that takes a callback as its final parameter
     * @param context Optional this object against which the original function will be invoked
     */
    fun <R, C> wrapAsync(func: CallbackAsync<R, C>, context: C): CallbackSync<R>
    fun <A1, R, C> wrapAsync(func: CallbackAsyncA1<A1, R, C>, context: C): CallbackSyncA1<A1, R>
    fun <A1, A2, R, C> wrapAsync(func: CallbackAsyncA2<A1, A2, R, C>, context: C): CallbackSyncA2<A1, A2, R>
    fun <A1, A2, A3, R, C> wrapAsync(func: CallbackAsyncA3<A1, A2, A3, R, C>, context: C): CallbackSyncA3<A1, A2, A3, R>
    fun <A1, A2, A3, A4, R, C> wrapAsync(func: CallbackAsyncA4<A1, A2, A3, A4, R, C>, context: C): CallbackSyncA4<A1, A2, A3, A4, R>
    fun <A1, A2, A3, A4, A5, R, C> wrapAsync(func: CallbackAsyncA5<A1, A2, A3, A4, A5, R, C>, context: C): CallbackSyncA5<A1, A2, A3, A4, A5, R>
    fun <A1, A2, A3, A4, A5, A6, R, C> wrapAsync(func: CallbackAsyncA6<A1, A2, A3, A4, A5, A6, R, C>, context: C): CallbackSyncA6<A1, A2, A3, A4, A5, A6, R>
    fun <A1, A2, A3, A4, A5, A6, A7, R, C> wrapAsync(func: CallbackAsyncA7<A1, A2, A3, A4, A5, A6, A7, R, C>, context: C): CallbackSyncA7<A1, A2, A3, A4, A5, A6, A7, R>
    fun <A1, A2, A3, A4, A5, A6, A7, A8, R, C> wrapAsync(func: CallbackAsyncA8<A1, A2, A3, A4, A5, A6, A7, A8, R, C>, context: C): CallbackSyncA8<A1, A2, A3, A4, A5, A6, A7, A8, R>
    fun <A1, A2, A3, A4, A5, A6, A7, A8, A9, R, C> wrapAsync(func: CallbackAsyncA9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R, C>, context: C): CallbackSyncA9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R>

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

    @ClientSide
    fun subscribe(name: String, vararg args: Any, onReady: (error: Meteor.Error?) -> Unit): SubscribeManager

    @ClientSide
    fun subscribe(name: String, vararg args: Any): SubscribeManager

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
