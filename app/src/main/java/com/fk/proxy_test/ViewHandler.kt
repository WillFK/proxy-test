package com.fk.proxy_test

import android.util.Log
import java.lang.reflect.InvocationHandler
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * Created by william on 11.10.17.
 */
class ViewHandler(private val view: Any) : InvocationHandler {
    @Throws(Throwable::class)
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        Log.d(view::class.java.simpleName, "invoking ${method.toString()}")
        return try {
                if (args == null) {
                    method?.invoke(view)
                } else {
                    method?.invoke(view, *args)
                }
            } catch (ex: InvocationTargetException) {
                throw ex.targetException
            }
    }
}