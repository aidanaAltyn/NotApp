package room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import model.TaskModel;

@Database(entities = TaskModel.class,version = 2,exportSchema = false)
public abstract class  NoteDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
}
