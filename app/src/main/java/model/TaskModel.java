package model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
  @Entity
  public class TaskModel implements Serializable {
      @PrimaryKey(autoGenerate = true)
      public int id;
      private String title;

      public String getTitle() {
          return title;
      }

      public void setTitle(String title) {
          this.title = title;
      }

      public TaskModel(String title) {
          this.title = title;
      }
  }

