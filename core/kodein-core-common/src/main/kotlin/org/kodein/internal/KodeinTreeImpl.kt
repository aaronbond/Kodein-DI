package org.kodein.internal

import org.kodein.*
import org.kodein.bindings.ExternalSource


private typealias BoundTypeTree = MutableMap<TypeToken<*>, ContextTypeTree>

private typealias ContextTypeTree = MutableMap<TypeToken<*>, ArgumentTypeTree>

private typealias ArgumentTypeTree = MutableMap<TypeToken<*>, TagTree>

private typealias TagTree = MutableMap<Any?, Kodein.Key<*, *, *>>

internal class KodeinTreeImpl(
        map: Map<Kodein.Key<*, *, *>, List<KodeinDefining<*, *, *>>>,
        override val externalSource: ExternalSource?
): KodeinTree {
    private val _cache: MutableMap<Kodein.Key<*, *, *>, List<KodeinDefinition<*, *, *>>> = HashMap()
    private val _typeTree: BoundTypeTree = HashMap()

    override val bindings: BindingsMap

    init {
        map.forEach { (key, bindings) ->
            _cache[key] = bindings.map {
                when (it) {
                    is KodeinDefinition<*, *, *> -> it
                    else -> KodeinDefinition(it.binding, it.fromModule, this)
                }
            }

            val contextTree = _typeTree.getOrPut(key.type) { HashMap() }
            val argumentTree = contextTree.getOrPut(key.contextType) { HashMap() }
            val tagTree = argumentTree.getOrPut(key.argType) { HashMap() }
            tagTree[key.tag] = key
        }
        bindings = HashMap(_cache)
    }

    private fun _find(specs: SearchSpecs): List<Kodein.Key<*, *, *>> {
        var bindSeq: Sequence<Map.Entry<TypeToken<*>, ContextTypeTree>> = _typeTree.asSequence()
        val specsBindType = specs.type
        if (specsBindType != null && specsBindType != AnyToken) {
            bindSeq = bindSeq.filter { (bindType) -> specsBindType.isAssignableFrom(bindType) } // Filter keys that are for sub-types of this specs bind type
        }

        var contextSeq = bindSeq.flatMap { (_, contextTree) -> contextTree.asSequence() } // Get all matched context types
        val specsContextType = specs.contextType
        if (specsContextType != null) {
            contextSeq = contextSeq.filter { (contextType) -> contextType == AnyToken || contextType.isAssignableFrom(specsContextType) } // Filter context types that are super-types of this specs context type
        }

        var argSeq = contextSeq.flatMap { (_, argumentTree) -> argumentTree.asSequence() } // Get all corresponding argument types
        val specsArgType = specs.argType
        if (specsArgType != null) {
            argSeq = argSeq.filter { (argType) -> argType == AnyToken || argType.isAssignableFrom(specsArgType) } // Filter argument types that are super-types of this specs argument type
        }

        var tagSeq = argSeq.flatMap { (_, tagTree) -> tagTree.asSequence() } // Get all corresponding tags
        val specsTag = specs.tag
        if (specsTag != SearchSpecs.NoDefinedTag) {
            tagSeq = tagSeq.filter { (tag) -> tag == specsTag } // Filter tags that match this specs tag
        }

        val resultSeq = tagSeq.map { (_, overrideQueue) -> overrideQueue } // Get all corresponding queues
        return resultSeq.toList()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <C, A, T : Any> find(key: Kodein.Key<C, A, T>, overrideLevel: Int): List<Pair<Kodein.Key<C, A, T>, KodeinDefinition<C, A, T>>> {

        _cache[key]?.let { return it.getOrNull(overrideLevel)?.let { listOf(key to it as KodeinDefinition<C, A, T>) } ?: emptyList() }

        if (key.contextType != AnyToken) {
            val anyContextKey = key.copy(contextType = AnyToken)
            _cache[anyContextKey]?.let {
                _cache[key] = it
                return it.getOrNull(overrideLevel)?.let { listOf(key to it as KodeinDefinition<C, A, T>) } ?: emptyList()
            }
        }

        val keys = _find(SearchSpecs(key.contextType, key.argType, key.type, key.tag))
        if (keys.size == 1) {
            val realKey = keys.first()
            _cache[key] = _cache[realKey] ?: throw IllegalStateException("The tree contains a key that is not in the map.")
        }

        val entries = keys.mapNotNull { realKey -> _cache[realKey]?.getOrNull(overrideLevel)?.let { realKey to it } }
        return entries as List<Pair<Kodein.Key<C, A, T>, KodeinDefinition<C, A, T>>>
    }

    @Suppress("UNCHECKED_CAST")
    override fun find(search: SearchSpecs): List<Pair<Kodein.Key<*, *, *>, List<KodeinDefinition<*, *, *>>>> {
        val keys = _find(search)
        return keys.map { realKey -> realKey to _cache[realKey]!! }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <C, A, T: Any> get(key: Kodein.Key<C, A, T>) = _cache[key] as? List<KodeinDefinition<C, A, T>>

//    inner class BindingsMapView : BindingsMap by _cache
}