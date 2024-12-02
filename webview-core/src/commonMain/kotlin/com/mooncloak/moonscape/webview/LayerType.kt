package com.mooncloak.moonscape.webview

import kotlin.jvm.JvmInline

@JvmInline
public value class LayerType public constructor(
    public val value: Int
) {

    public companion object {

        public val None: LayerType = LayerType(value = 0)
        public val Software: LayerType = LayerType(value = 1)
        public val Hardware: LayerType = LayerType(value = 2)
    }
}
