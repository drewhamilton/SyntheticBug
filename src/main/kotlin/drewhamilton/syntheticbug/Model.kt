package drewhamilton.syntheticbug

import java.util.*

class Model private constructor(
    val title: String,
    val description: String?
) {
    override fun toString() = "Model(title=$title, description=$description)"
    override fun equals(other: Any?) = other is Model &&
            title == other.title &&
            description == other.description
    override fun hashCode() = Objects.hash(title, description)

    class Builder {
        @set:JvmSynthetic // Hide from Java callers so setTitle can return Builder
        var title: String? = null

        @set:JvmSynthetic // Hide from Java callers so setDescription can return Builder
        var description: String? = null

        fun setTitle(title: String) = apply { this.title = title }
        fun setDescription(description: String?) = apply { this.description = description }

        fun build() = Model(title!!, description)
    }
}

@JvmSynthetic // Hide from Java callers who should use Builder
@Suppress("FunctionName")
fun Model(initializer: Model.Builder.() -> Unit): Model = Model.Builder().apply(initializer).build()
