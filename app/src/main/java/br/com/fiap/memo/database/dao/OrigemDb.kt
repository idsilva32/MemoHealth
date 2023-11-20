package br.com.fiap.memo.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.memo.model.Origem


@Database(entities = [Origem::class], version = 1)
abstract class OrigemDb : RoomDatabase() {

    abstract fun origemDao(): OrigemDao

    companion object {

        private lateinit var instance: OrigemDb

        fun getDatabase(context: Context): OrigemDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        OrigemDb::class.java,
                        "origem"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}