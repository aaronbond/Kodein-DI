package com.github.salomonbrys.kodein.android

import android.app.Dialog
import android.app.Fragment
import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.content.Loader
import android.view.View
import com.github.salomonbrys.kodein.*


/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val Context.appKodein: () -> Kodein get() = { (applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val Fragment.appKodein: () -> Kodein get() = { (activity.applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val android.support.v4.app.Fragment.appKodein: () -> Kodein get() = { (activity.applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val Dialog.appKodein: () -> Kodein get() = { (context.applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val View.appKodein: () -> Kodein get() = { (context.applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val AbstractThreadedSyncAdapter.appKodein: () -> Kodein get() = { (context.applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val Loader<*>.appKodein: () -> Kodein get() = { (context.applicationContext as KodeinAware).kodein }

/**
 * Function to get the application global Kodein, provided that the Application object is `KodeinAware`.
 */
val android.support.v4.content.Loader<*>.appKodein: () -> Kodein get() = { (context.applicationContext as KodeinAware).kodein }


// Cannot use extension functions :( https://youtrack.jetbrains.com/issue/KT-9630

/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param ctx The context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(ctx: Context): CurriedKodeinFactory<Context> = with(ctx)

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param ctx The context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(ctx: Context): CurriedInjectorFactory<Context> = with(ctx)

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param ctx The context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(ctx: Context): CurriedLazyKodeinFactory<Context> = with(ctx)


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param f The fragment whose activity context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(f: Fragment): CurriedKodeinFactory<Context> = with { f.activity }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param f The fragment whose activity context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(f: Fragment): CurriedInjectorFactory<Context> = with { f.activity }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param f The fragment whose activity context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(f: Fragment): CurriedLazyKodeinFactory<Context> = with { f.activity }


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param f The fragment whose activity context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(f: android.support.v4.app.Fragment): CurriedKodeinFactory<Context> = with { f.activity }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param f The fragment whose activity context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(f: android.support.v4.app.Fragment): CurriedInjectorFactory<Context> = with { f.activity }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param f The fragment whose activity context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(f: android.support.v4.app.Fragment): CurriedLazyKodeinFactory<Context> = with { f.activity }


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param d The dialog whose context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(d: Dialog): CurriedKodeinFactory<Context> = with { d.context }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param d The dialog whose context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(d: Dialog): CurriedInjectorFactory<Context> = with { d.context }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param d The dialog whose context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(d: Dialog): CurriedLazyKodeinFactory<Context> = with { d.context }


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param v The dialog whose context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(v: View): CurriedKodeinFactory<Context> = with { v.context }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param v The dialog whose context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(v: View): CurriedInjectorFactory<Context> = with { v.context }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param v The dialog whose context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(v: View): CurriedLazyKodeinFactory<Context> = with { v.context }


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param tsa The threaded sync adapter whose context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(tsa: AbstractThreadedSyncAdapter): CurriedKodeinFactory<Context> = with { tsa.context }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param tsa The threaded sync adapter whose context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(tsa: AbstractThreadedSyncAdapter): CurriedInjectorFactory<Context> = with { tsa.context }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param tsa The threaded sync adapter whose context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(tsa: AbstractThreadedSyncAdapter): CurriedLazyKodeinFactory<Context> = with { tsa.context }


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param l The loader whose context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(l: Loader<*>): CurriedKodeinFactory<Context> = with { l.context }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param l The loader whose context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(l: Loader<*>): CurriedInjectorFactory<Context> = with { l.context }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param l The loader whose context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(l: Loader<*>): CurriedLazyKodeinFactory<Context> = with { l.context }


/**
 * Allows to get an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param l The loader whose context to curry the factory with.
 * @return A curried factory object from which you can retrieve an instance or a provider.
 */
fun KodeinAware.withContext(l: android.support.v4.content.Loader<*>): CurriedKodeinFactory<Context> = with { l.context }

/**
 * Allows to inject an instance or a provider from a factory which takes a `Context` as argument.
 *
 * @param l The loader whose context to curry the factory with.
 * @return A curried factory object from which you can get an injected instance or provider property.
 */
fun KodeinInjected.withContext(l: android.support.v4.content.Loader<*>): CurriedInjectorFactory<Context> = with { l.context }

/**
 * Allows to get a lazy instance or provider property from a factory which takes a `Context` as argument.
 *
 * @param l The loader whose context to curry the factory with.
 * @return A curried factory object from which you can get a lazy instance or provider.
 */
fun LazyKodeinAware.withContext(l: android.support.v4.content.Loader<*>): CurriedLazyKodeinFactory<Context> = with { l.context }
