package lib.natives.meteor


class AbsoluteUrlOptions(
        /**
         * Create an HTTPS URL.
         */
        val secure: Boolean = false,

        /**
         * Replace localhost with 127.0.0.1. Useful for services that don't recognize localhost as a domain name.
         */
        val replaceLocalhost: Boolean = false,

        /**
         * Override the default ROOT_URL from the server environment. For example: "http://foo.example.com"
         */
        val rootUrl: String = ""
)
