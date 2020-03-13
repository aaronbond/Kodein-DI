@file:Suppress("UNCHECKED_CAST")

package org.kodein.di.erased

import org.kodein.di.*
import org.kodein.di.bindings.*
import org.kodein.type.TypeToken
import org.kodein.type.erasedComp
import org.kodein.type.generic

const val DEPRECATED_ERASED_GENERIC_7X = "!!! This will be removed from 7.1 !!! As soon as you are using _Kodein-DI 7.x_, you must move from this implementation to the new one, defined in the package org.kodein.di."

@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DI.Builder.bind(tag: Any? = null, overrides: Boolean? = null): DI.Builder.TypeBinder<T> = Bind(generic<T>(), tag, overrides)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
fun DI.Builder.bind(tag: Any? = null, overrides: Boolean? = null): DI.Builder.DirectBinder = Bind(tag, overrides)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline infix fun <reified T : Any> DI.Builder.ConstantBinder.with(value: T) = With(generic(), value)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> SearchDSL.binding(tag: Any? = null) = SearchDSL.Binding(generic<T>(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> SearchDSL.context() = Context(generic<T>())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> SearchDSL.argument() = Argument(generic<T>())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any> DI.Builder.scoped(scope: Scope<C>): DI.BindBuilder.WithScope<C> = DI.BindBuilder.WithScope.Impl(generic(), scope)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any> DI.Builder.contexted(): DI.BindBuilder.WithContext<C> = DI.BindBuilder.WithContext.Impl(generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <C : Any, reified A : Any, reified T: Any> DI.BindBuilder.WithContext<C>.factory(noinline creator: BindingDI<C>.(A) -> T) = Factory<C, A, T>(contextType, generic(), generic(), creator)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <C : Any, reified T: Any> DI.BindBuilder.WithContext<C>.provider(noinline creator: NoArgBindingDI<C>.() -> T) = Provider(contextType, generic(), creator)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <C : Any, reified T: Any> DI.BindBuilder.WithScope<C>.singleton(ref: RefMaker? = null, sync: Boolean = true, noinline creator: NoArgSimpleBindingDI<C>.() -> T) = Singleton(scope, contextType, generic(), ref, sync, creator)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <C : Any, reified A : Any, reified T: Any> DI.BindBuilder.WithScope<C>.multiton(ref: RefMaker? = null, sync: Boolean = true, noinline creator: SimpleBindingDI<C>.(A) -> T) = Multiton<C, A, T>(scope, contextType, generic(), generic(), ref, sync, creator)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T: Any> DI.Builder.eagerSingleton(noinline creator: NoArgSimpleBindingDI<Any>.() -> T) = EagerSingleton(containerBuilder, generic(), creator)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T: Any> DI.Builder.instance(instance: T) = InstanceBinding(generic(), instance)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any, reified S : Any> contextTranslator(noinline t: (C) -> S): ContextTranslator<C, S> = SimpleContextTranslator(generic(), generic(), t)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any, reified S : Any> DI.Builder.registerContextTranslator(noinline t: (C) -> S) = RegisterContextTranslator(org.kodein.di.contextTranslator(t))
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified S : Any> contextFinder(noinline t: () -> S) : ContextTranslator<Any, S> = SimpleAutoContextTranslator(generic(), t)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified S : Any> DI.Builder.registerContextFinder(noinline t: () -> S) = RegisterContextTranslator(org.kodein.di.contextFinder(t))
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.factory(tag: Any? = null) = Factory<A, T>(generic(), generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.factoryOrNull(tag: Any? = null) = FactoryOrNull<A, T>(generic(), generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DIAware.provider(tag: Any? = null) = Provider<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.provider(tag: Any? = null, arg: A) = Provider<A, T>(generic(), generic(), tag) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DIAware.provider(tag: Any? = null, arg: Typed<A>) = Provider<A, T>(arg.type, generic(), tag) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.provider(tag: Any? = null, noinline fArg: () -> A) = Provider<A, T>(generic(), generic(), tag, fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DIAware.providerOrNull(tag: Any? = null) = ProviderOrNull<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.providerOrNull(tag: Any? = null, arg: A) = ProviderOrNull<A, T>(generic(), generic(), tag, { arg })
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DIAware.providerOrNull(tag: Any? = null, arg: Typed<A>) = ProviderOrNull<A, T>(arg.type, generic(), tag, { arg.value })
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.providerOrNull(tag: Any? = null, noinline fArg: () -> A) = ProviderOrNull<A, T>(generic(), generic(), tag, fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DIAware.instance(tag: Any? = null) = Instance<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.instance(tag: Any? = null, arg: A) = Instance<A, T>(generic(), generic(), tag) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DIAware.instance(tag: Any? = null, arg: Typed<A>) = Instance<A, T>(arg.type, generic(), tag) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.instance(tag: Any? = null, noinline fArg: () -> A) = Instance<A, T>(generic(), generic(), tag, fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DIAware.instanceOrNull(tag: Any? = null) = InstanceOrNull<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.instanceOrNull(tag: Any? = null, arg: A) = InstanceOrNull<A, T>(generic(), generic(), tag) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DIAware.instanceOrNull(tag: Any? = null, arg: Typed<A>) = InstanceOrNull<A, T>(arg.type, generic(), tag) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DIAware.instanceOrNull(tag: Any? = null, noinline fArg: () -> A) = InstanceOrNull<A, T>(generic(), generic(), tag, fArg)
@Deprecated(DEPRECATED_KODEIN_7X, ReplaceWith("diContext(context)"), DeprecationLevel.ERROR)
inline fun <reified C : Any> kcontext(context: C) = DIContext(generic(), context)
@Deprecated(DEPRECATED_KODEIN_7X, ReplaceWith("diContext(getContext)"), DeprecationLevel.ERROR)
inline fun <reified C : Any> kcontext(crossinline getContext: () -> C) = DIContext<C>(generic()) { getContext() }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any> DIAware.on(context: C, trigger: DITrigger? = this.diTrigger) = On(diContext(context), trigger)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any> DIAware.on(trigger: DITrigger? = this.diTrigger, crossinline getContext: () -> C) = On(diContext(getContext), trigger)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
fun DIAware.on(trigger: DITrigger?) = On(diContext, trigger)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.factory(tag: Any? = null) = directDI.Factory<A, T>(generic(), generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.factoryOrNull(tag: Any? = null) = directDI.FactoryOrNull<A, T>(generic(), generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DirectDIAware.provider(tag: Any? = null) = directDI.Provider<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.provider(tag: Any? = null, arg: A) = directDI.Provider<A, T>(generic(), generic(), tag) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DirectDIAware.provider(tag: Any? = null, arg: Typed<A>) = directDI.Provider<A, T>(arg.type, generic(), tag) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.provider(tag: Any? = null, noinline fArg: () -> A) = directDI.Provider<A, T>(generic(), generic(), tag, fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DirectDIAware.providerOrNull(tag: Any? = null) = directDI.ProviderOrNull<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.providerOrNull(tag: Any? = null, arg: A) = directDI.ProviderOrNull<A, T>(generic(), generic(), tag) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DirectDIAware.providerOrNull(tag: Any? = null, arg: Typed<A>) = directDI.ProviderOrNull<A, T>(arg.type, generic(), tag) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.providerOrNull(tag: Any? = null, noinline fArg: () -> A) = directDI.ProviderOrNull<A, T>(generic(), generic(), tag, fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DirectDIAware.instance(tag: Any? = null) = directDI.Instance<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.instance(tag: Any? = null, arg: A) = directDI.Instance<A, T>(generic(), generic(), tag, arg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DirectDIAware.instance(tag: Any? = null, arg: Typed<A>) = directDI.Instance<A, T>(arg.type, generic(), tag, arg.value)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DirectDIAware.instanceOrNull(tag: Any? = null) = directDI.InstanceOrNull<T>(generic(), tag)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> DirectDIAware.instanceOrNull(tag: Any? = null, arg: A) = directDI.InstanceOrNull<A, T>(generic(), generic(), tag, arg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> DirectDIAware.instanceOrNull(tag: Any? = null, arg: Typed<A>) = directDI.InstanceOrNull<A, T>(arg.type, generic(), tag, arg.value)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified C : Any> DirectDIAware.on(context: C) = directDI.On(diContext(context))
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.factory() = Factory<A, T>(generic(), generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.factoryOrNull() = FactoryOrNull<A, T>(generic(), generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> Named.provider() = Provider<T>(generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.provider(arg: A) = Provider<A, T>(generic(), generic()) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A : Any, reified T : Any> Named.provider(arg: Typed<A>) = Provider<A, T>(arg.type, generic()) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.provider(noinline fArg: () -> A) = Provider<A, T>(generic(), generic(), fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> Named.providerOrNull() = ProviderOrNull<T>(generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.providerOrNull(arg: A) = ProviderOrNull<A, T>(generic(), generic(), { arg })
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> Named.providerOrNull(arg: Typed<A>) = ProviderOrNull<A, T>(arg.type, generic(), { arg.value })
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.providerOrNull(noinline fArg: () -> A) = ProviderOrNull<A, T>(generic(), generic(), fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> Named.instance() = Instance<T>(generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.instance(arg: A) = Instance<A, T>(generic(), generic()) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> Named.instance(arg: Typed<A>) = Instance<A, T>(arg.type, generic()) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.instance(noinline fArg: () -> A) = Instance<A, T>(generic(), generic(), fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> Named.instanceOrNull() = InstanceOrNull<T>(generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.instanceOrNull(arg: A) = InstanceOrNull<A, T>(generic(), generic()) { arg }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <A, reified T : Any> Named.instanceOrNull(arg: Typed<A>) = InstanceOrNull<A, T>(arg.type, generic()) { arg.value }
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T : Any> Named.instanceOrNull(noinline fArg: () -> A) = InstanceOrNull<A, T>(generic(), generic(), fArg)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T : Any> DIAware.constant() = Constant<T>(generic())
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T: Any> DI.Builder.setBinding() = SetBinding(TypeToken.Any, generic<T>(), erasedComp(Set::class, generic<T>()) as TypeToken<Set<T>>)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified A : Any, reified T: Any> DI.Builder.argSetBinding() = ArgSetBinding(TypeToken.Any, generic<A>(), generic<T>(), erasedComp(Set::class, generic<T>()) as TypeToken<Set<T>>)
@Deprecated(DEPRECATED_ERASED_GENERIC_7X)
inline fun <reified T: Any> DI.Builder.TypeBinder<T>.inSet() = InSet(erasedComp(Set::class, generic<T>()) as TypeToken<Set<T>>)