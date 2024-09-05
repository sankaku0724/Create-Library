package hcu.info.cne.isd_kadai2_g20138;

public class Book {

    public String bookID;
    public String name;
    public Boolean status;
    public String status2;


    Book(){
        bookID = "No information.";
        name = "No information.";
        status =false;
    }

    public String toString(){
        if(status.equals(false)){
            status2 = "貸出可";
        }else{
            status2 = "貸出中";
        }

        return "ID: " + bookID + " 図書名: " + name+" 貸出状況: " + status2;
    }

    public String NewtoString(){
        return "ID: " + bookID + " 図書名: " + name;
    }
}
