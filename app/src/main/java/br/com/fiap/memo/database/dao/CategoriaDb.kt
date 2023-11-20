package br.com.fiap.memo.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.memo.model.Categoria


@Database(entities = [Categoria::class], version = 1)
abstract class CategoriaDb : RoomDatabase() {

    abstract fun categoriaDao(): CategoriaDao

    companion object {

        private lateinit var instance: CategoriaDb

        fun getDatabase(context: Context): CategoriaDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        CategoriaDb::class.java,
                        "categoria"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}