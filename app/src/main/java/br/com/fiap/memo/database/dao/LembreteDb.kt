package br.com.fiap.memo.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.memo.model.Lembrete


@Database(entities = [Lembrete::class], version = 1)
abstract class LembreteDb : RoomDatabase() {

    abstract fun lembreteDao(): LembreteDao

    companion object {

        private lateinit var instance: LembreteDb

        fun getDatabase(context: Context): LembreteDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        LembreteDb::class.java,
                        "lembrete"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}