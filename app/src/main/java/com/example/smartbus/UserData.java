package com.example.smartbus;

/**
 * Created by Y on 11/1/2018.
 */

public class UserData {
    String SavedTrack;
    String name,course,mobile,college,busname;
    public UserData() {
    }

    public UserData(String savedTrack, String name, String course, String mobile, String college,String busname) {
      //  SavedTrack = savedTrack;
        this.name = name;
      this.course = course;
     //   this.mobile = mobile;
     //   this.college = college;
   //     this.busname=busname;
    }

    public String getCourse() {
        return course;
    }
    public String getName() {
        return name;
    }

/*
     public String getSavedTrack() {
        return SavedTrack;
    }


    public String getMobile() {
        return mobile;
    }

    public String getCollege() {
        return college;
    }
    public String getBusname() {
        return busname;
    }*/

}
