package com.example.typecheckvsvisitorperformance.model

class ChatItemTypeVisitorImpl: ChatItemTypeVisitor {
    override fun type(typeIndicator: TypeIndicator): Int {
        return 1
    }

    override fun type(timestamp: Timestamp): Int {
        return 2
    }

    override fun type(textChatMessage: TextChatMessage): Int {
        return 3
    }

    override fun type(videoChatMessage: VideoChatMessage): Int {
        return 4
    }

    override fun type(audioChatMessage: AudioChatMessage): Int {
        return 5
    }

    override fun type(imageChatMessage: ImageChatMessage): Int {
        return 6
    }

    override fun type(linkChatMessage: LinkChatMessage): Int {
        return 7
    }
}