package com.example.dono.classes;

public class personaldetailspenefactor {
    private String EMAILS;
    private String PHONENUM;
    private String image;

    public personaldetailspenefactor(String EMAILS, String PHONENUM, String image) {
        this.EMAILS = EMAILS;
        this.PHONENUM = PHONENUM;
        this.image = image;
    }




    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public personaldetailspenefactor(String image) {
        this.image = image;
    }






    public String getPHONENUM() {
        return PHONENUM;
    }



    public String getEMAILS() {
        return EMAILS;
    }




    public  personaldetailspenefactor(String EMAILS, String PHONENUM) {
        this.EMAILS=EMAILS;
        this.PHONENUM=PHONENUM;


    }


    public void setEMAILS(String EMAILS) {
        this.EMAILS = EMAILS;
    }

    public void setPHONENUM(String PHONENUM) {
        this.PHONENUM = PHONENUM;
    }





}
