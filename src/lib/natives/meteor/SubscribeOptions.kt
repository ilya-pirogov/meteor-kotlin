package lib.natives.meteor


data class SubscribeOptions(
        val onStop: (error: Meteor.Error?) -> Unit,
        val onReady: (error: Meteor.Error?) -> Unit
)