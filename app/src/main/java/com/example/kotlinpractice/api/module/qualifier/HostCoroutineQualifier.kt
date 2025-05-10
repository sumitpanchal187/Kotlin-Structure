package com.example.kotlinpractice.api.module.qualifier

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
annotation class HostCoroutineQualifier 