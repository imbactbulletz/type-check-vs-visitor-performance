package com.example.typecheckvsvisitorperformance.model

interface ChatItemTypeVisitor {

    fun type(typeIndicator: TypeIndicator): Int

    fun type(timestamp: Timestamp): Int

    fun type(textChatMessage: TextChatMessage): Int

    fun type(videoChatMessage: VideoChatMessage): Int

    fun type(audioChatMessage: AudioChatMessage): Int

    fun type(imageChatMessage: ImageChatMessage): Int

    fun type(linkChatMessage: LinkChatMessage): Int
}