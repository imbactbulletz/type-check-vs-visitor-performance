package com.example.typecheckvsvisitorperformance.model

sealed class ChatItem {
    abstract val id: Int

    abstract fun type(visitor: ChatItemTypeVisitor): Int
}

class TypeIndicator(override val id: Int): ChatItem() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}

class Timestamp(override val id: Int): ChatItem() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}

sealed class ChatMessage: ChatItem() {
    abstract val createdAt: String
}

data class TextChatMessage(override val id: Int, override val createdAt: String): ChatMessage() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}

data class VideoChatMessage(override val id: Int, override val createdAt: String): ChatMessage() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}

data class AudioChatMessage(override val id: Int, override val createdAt: String): ChatMessage() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}

data class ImageChatMessage(override val id: Int, override val createdAt: String): ChatMessage() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}

data class LinkChatMessage(override val id: Int, override val createdAt: String): ChatMessage() {
    override fun type(visitor: ChatItemTypeVisitor): Int {
        return visitor.type(this)
    }
}
