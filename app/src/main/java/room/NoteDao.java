package room;

import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;


import java.util.List;

import model.TaskModel;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM ta")
    LiveData<List<TaskModel>> getAll();

    @Insert
    void insertTask(TaskModel taskModel);
}
