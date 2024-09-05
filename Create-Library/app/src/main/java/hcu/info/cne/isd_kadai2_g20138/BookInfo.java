package hcu.info.cne.isd_kadai2_g20138;

import java.util.ArrayList;

public class BookInfo {
    private static BookInfo BookInfo = new BookInfo();

    private BookInfo(){
        BookList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        Book book1 = new Book();book1.bookID = "111"; book1.name = "ドラえもん";BookList.add(book1);
        Book book2 = new Book();book2.bookID = "222"; book2.name = "進撃の巨人";BookList.add(book2);
        Book book3 = new Book();book3.bookID = "333"; book3.name = "鋼の錬金術師";BookList.add(book3);
        Book book4 = new Book();book4.bookID = "444"; book4.name = "SPY x FAMILY";BookList.add(book4);

    }
    private ArrayList<Book> BookList;

    public static BookInfo getInstance(){
        return BookInfo;
    }

    //インデックスを返す
    private int BookNumber(String bookID){
        for(int i=0;i<BookList.size();i++){
            Book book = BookList.get(i);
            String id = book.bookID;

            if(id.equals(bookID)){
                return i;
            }
        }
        return -1;
    }


    //本が存在するかどうか
    public Boolean exsist(String BookID){
        for(int i=0;i<BookList.size();i++){
            Book book = BookList.get(i);
            String id = book.bookID;

            if(id.equals(BookID)){
                return true;
            }
        }
        return false;
    }

    //本が貸出できるかどうか
    public Boolean Canborrow(String BookID){
        Book book = BookList.get(BookNumber(BookID));
        return book.status;
    }

    //本の貸出状態を変える
    public void Change(String BookID){
        Book book = BookList.get(BookNumber(BookID));
        book.status =! book.status;
    }

    // 登録された全図書の取得　文字列で返す
    public String getBookInfo(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<BookList.size();i++){
            Book Allbook = BookList.get(i);
            sb.append(Allbook.toString() + "\n");
        }
        return sb.toString();
    }

    // 指定されたIDが存在するかどうかの確認　存在する場合はtrue，存在しない場合はfalseを返す
    public Boolean existsOfBookID(String _bookID){
        for(int i=0;i<BookList.size();i++){
            Book stu = BookList.get(i);
            if(_bookID.equals(stu.bookID)){
                return true;
            }
        }
        return false;
    }

    // 指定したIDが登録済みかどうかを判定して，情報を登録する
    // 登録した場合は0，指定したIDが登録済みの場合は1を返す
    public int setBookJoho(String _id, String _name){
        if(existsOfBookID(_id))
            return 1;

        Book stu = new Book();
        stu.bookID = _id;
        stu.name = _name;
        BookList.add(stu);
        return 0;
    }

    //Book.javaで作成したNewtoStringを返す
    public String toString(String bookID){
        int bookID2 = BookNumber(bookID);
        Book book = BookList.get(bookID2);
        return book.NewtoString();
    }

}
