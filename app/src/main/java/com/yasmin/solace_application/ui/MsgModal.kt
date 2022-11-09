package com.yasmin.solace_application.ui

class MsgModal(message: String, sender: String) {
    // getter and setter methods.
    // string to store our message and sender
    var message: String
    var sender: String

    // constructor.
    init {
        this.message = message
        this.sender = sender
    }
}