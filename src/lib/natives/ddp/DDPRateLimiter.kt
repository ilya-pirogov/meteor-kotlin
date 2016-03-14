@file:Suppress("unused")

package lib.natives.ddp

import lib.annotation.ServerSide


@ServerSide
@native
object DDPRateLimiter {
    /**
     * Add a rule that matches against a stream of events describing method or subscription attempts.
     * Each event is an object with the following properties:
     *
     * - type: Either "method" or "subscription"
     * - name: The name of the method or subscription being called
     * - userId: The user ID attempting the method or subscription
     * - connectionId: A string representing the user's DDP connection
     * - clientAddress: The IP address of the user
     *
     * Returns unique ruleId that can be passed to removeRule.
     *
     * @param matcher
     * @param numRequests number of requests allowed per time interval. Default = 10
     * @param timeInterval time interval in milliseconds after which rule's counters are reset. Default = 1000
     */
    fun addRule(matcher: Json, numRequests: Int = 10, timeInterval: Int = 1000): String

    /**
     * Removes the specified rule from the rate limiter. If rule had hit a rate limit, that limit is removed as well.
     *
     * @param id 'ruleId' returned from addRule
     */
    fun removeRule(id: String)

    /**
     * Set error message text when method or subscription rate limit exceeded.
     *
     * @param message Functions are passed in an object with a timeToReset field that specifies the number
     *                of milliseconds until the next method or subscription is allowed to run. The function
     *                must return a string of the error message.
     */
    fun setErrorMessage(message: String)
}