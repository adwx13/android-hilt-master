package com.example.android.hilt.di

import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.LoggerInMemoryDataSource
import com.example.android.hilt.data.LoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger

@InstallIn(ApplicationComponent::class)
@Module
abstract class LoggingDatabaseModule {

//    DatabaseLogger라는 한정자 추가 -> LoggerDataSource를 반환하는 instance가 현재 두개인데 DatabaseLogger라는한정자가 붙은 인스턴스에는
//    bindDatabaseLogger를 이용한 인스턴스를 만들어서 주입시킴
    @DatabaseLogger
    @Singleton
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource): LoggerDataSource
}

@InstallIn(ActivityComponent::class)
@Module
abstract class LoggingInMemoryModule {

//    InMemoryLogger라는 한정자 추가 -> LoggerDataSource를 반환하는 instance가 현재 두개인데 InMemoryLogger라는한정자가 붙은 인스턴스에는
//    bbindInMemoryLogger를 이용한 인스턴스를 만들어서 주입시킴
    @InMemoryLogger
    @ActivityScoped
    @Binds
    abstract fun bindInMemoryLogger(impl: LoggerInMemoryDataSource): LoggerDataSource
}