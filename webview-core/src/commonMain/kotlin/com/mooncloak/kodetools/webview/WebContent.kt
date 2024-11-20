package com.mooncloak.kodetools.webview

import androidx.compose.runtime.Immutable

/**
 * Sealed class for constraining possible web content.
 */
@Immutable
public sealed interface WebContent {

    public val currentUrl: String?

    /**
     * Url content
     */
    @Immutable
    public data class Url public constructor(
        public val url: String,
        public val additionalHttpHeaders: Map<String, String> = emptyMap(),
    ) : WebContent {

        override val currentUrl: String = url
    }

    /**
     * Data content
     */
    @Immutable
    public data class Data public constructor(
        public val data: String,
        public val baseUrl: String? = null,
        public val encoding: String = "utf-8",
        public val mimeType: String? = null,
        public val historyUrl: String? = null,
    ) : WebContent {

        override val currentUrl: String? = baseUrl
    }

    @Immutable
    public data class File public constructor(
        public val path: String,
    ) : WebContent {

        override val currentUrl: String = path
    }

    /**
     * Post content
     */
    @Immutable
    public data class Post public constructor(
        public val url: String,
        public val postData: ByteArray,
    ) : WebContent {

        override val currentUrl: String = url

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || this::class != other::class) return false

            other as Post

            if (url != other.url) return false
            if (!postData.contentEquals(other.postData)) return false

            return true
        }

        override fun hashCode(): Int {
            var result = url.hashCode()
            result = 31 * result + postData.contentHashCode()
            return result
        }
    }

    @Immutable
    public data object NavigatorOnly : WebContent {

        override val currentUrl: String? = null
    }

    public companion object
}
