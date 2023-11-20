package br.com.fiap.memo.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.memo.model.Memo

@Database(entities = [Memo::class], version = 1)
abstract class MemoDb : RoomDatabase() {

    abstract fun memoDao(): MemoDao

    companion object {

        private lateinit var instance: MemoDb

        fun getDatabase(context: Context): MemoDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        MemoDb::class.java,
                        "memo"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}