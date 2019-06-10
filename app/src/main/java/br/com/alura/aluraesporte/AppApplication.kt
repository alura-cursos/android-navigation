package br.com.alura.aluraesporte

import android.app.Application
import br.com.alura.aluraesporte.di.daoModule
import br.com.alura.aluraesporte.di.testeDatabaseModule
import br.com.alura.aluraesporte.di.uiModule
import br.com.alura.aluraesporte.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
                listOf(
                    testeDatabaseModule,
                    daoModule,
                    uiModule,
                    viewModelModule
                )
            )
        }
    }
}