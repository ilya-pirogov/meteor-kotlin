@file:Suppress("unused")

package lib.natives.meteor


@native
interface Connection {
    /**
     * A globally unique id for this connection.
     */
    val id: String

    /**
     * Close this DDP connection. The client is free to reconnect, but will receive a different connection
     * with a new id if it does.
     */
    fun close()

    /**
     * Register a callback to be called when the connection is closed. If the connection is already closed,
     * the callback will be called immediately.
     */
    fun onClose(callback: () -> Unit)

    /**
     * The IP address of the client in dotted form (such as "127.0.0.1").
     *
     * If you're running your Meteor server behind a proxy (so that clients are connecting to the proxy instead
     * of to your server directly), you'll need to set the HTTP_FORWARDED_COUNT environment variable for
     * the correct IP address to be reported by clientAddress.
     *
     * Set HTTP_FORWARDED_COUNT to an integer representing the number of proxies in front of your server.
     * For example, you'd set it to "1" when your server was behind one proxy.
     */
    val clientAddress: String

    /**
     * When the connection came in over an HTTP transport (such as with Meteor's default SockJS implementation),
     * this field contains whitelisted HTTP headers.
     *
     * Cookies are deliberately excluded from the headers as they are a security risk for this transport.
     * For details and alternatives, see the SockJS documentation.
     */
    val httpHeaders: Json
}