package com.example.dono.classes;

public class addprojectmanager {

    private String projectname;
    private String projectdeatails;





    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdeatails() {
        return projectdeatails;
    }

    public void setProjectdeatails(String projectdeatails) {
        this.projectdeatails = projectdeatails;
    }





    public addprojectmanager(String projectname, String projectdeatails) {
        this.projectname = projectname;
        this.projectdeatails = projectdeatails;

    }

}
