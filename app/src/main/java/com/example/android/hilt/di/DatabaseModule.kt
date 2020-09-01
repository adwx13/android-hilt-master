package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class LoggingDatabase

@Qualifier
annotation class LogsDatabase

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @LoggingDatabase
    @Provides
    @Singleton
    fun provideLoggingDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "logging.db").build()
    }

//    Provides도 한정자 주입으로 똑같은 클래스의 인스턴스중 무엇을 사용할지 선택가능
//    현재 Retention(AnnotationRetention.BINARY) 가 추가되어있었는데 뭘뜻하는지 알수없음
    @LogsDatabase
    @Provides
    @Singleton
    fun provideLogsDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "logs.db").build()
    }
    @Provides
    fun provideLogDao(@LoggingDatabase database: AppDatabase): LogDao {
        return database.logDao()
    }

}