package hcu.info.cne.isd_kadai2_g20138;

import java.util.ArrayList;

public class UserInfo {
    private static UserInfo UserInfo = new UserInfo();
    BookInfo bookInfo = BookInfo.getInstance();
    private UserInfo(){
        UserList = new ArrayList<>();
        System.out.println("インスタンスを作成しました");

        User stu1 = new User();stu1.userID = "111"; stu1.name = "ウツホ";UserList.add(stu1);
        User stu2 = new User();stu2.userID = "222"; stu2.name = "フウカ";UserList.add(stu2);
        User stu3 = new User();stu3.userID = "333"; stu3.name = "マンタロー";UserList.add(stu3);
        User stu4 = new User();stu4.userID = "g20138"; stu4.name = "手島　悠斗";UserList.add(stu4);

    }
    private ArrayList<User> UserList;

    public static UserInfo getInstance(){
        return UserInfo;
    }
    //ログイン
    public int login(String userID){
        for(int i=0;i<UserList.size();i++){
            User user = UserList.get(i);
            String id = user.userID;

            if(id.equals(userID)){
                return 0;
            }
        }
        return -1;
    }

    //インデックスを返す
    private int Number(String userID){
        for(int i=0;i<UserList.size();i++){
            User user = UserList.get(i);
            String id = user.userID;

            if(id.equals(userID)){
                return i;
            }
        }
        return -1;
    }

    //本を借りる
    public int Borrow(String userID,String bookID){
        User user = UserList.get(Number(userID));
        if(bookInfo.exsist(bookID)){
            if(bookInfo.Canborrow(bookID)){
                return -1;
            }
            user.Books.add(bookID);
            bookInfo.Change(bookID);
            return 0;
        }
        return -1;
    }

    //本を返す
    public int ReturnBook(String userID,String bookID){
        User user = UserList.get(Number(userID));
        if(bookInfo.exsist(bookID)){
            int MYBOOLEAN=-1;
            //自分が借りている本の中に返したい本があるか確かめる
            for(int i=0;i<user.Books.size();i++){
                String id = user.Books.get(i);
                if(id.equals(bookID)){
                    MYBOOLEAN = 0;//存在する場合
                    break;
                }
                MYBOOLEAN = -1;//ない場合
            }
            if(MYBOOLEAN==0){
                if(!bookInfo.Canborrow(bookID)){
                    return -1;
                }
                user.Books.remove(bookID);
                bookInfo.Change(bookID);
                return 0;
            }
        }
        return -1;
    }

    //利用者の確認
    public String getUserInfo(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<UserList.size();i++){
            User Alluser = UserList.get(i);
            sb.append(Alluser.toString() + "\n");
        }
        return sb.toString();
    }

    //利用者が借りている図書の確認
    public String getUserBookInfo(String userID){
        StringBuffer sb = new StringBuffer();
        User user = UserList.get(Number(userID));

        for(int i=0;i<user.Books.size();i++){
            sb.append(bookInfo.toString(user.Books.get(i)) + "\n");
        }

        return sb.toString();
    }

    // 指定されたIDが存在するかどうかの確認　存在する場合はtrue，存在しない場合はfalseを返す
    public Boolean existsOfUserID(String _userID){
        for(int i=0;i<UserList.size();i++){
            User user = UserList.get(i);
            if(_userID.equals(user.userID)){
                return true;
            }
        }
        return false;
    }

    // 指定したIDが登録済みかどうかを判定して，情報を登録する
    // 登録した場合は0，指定したIDが登録済みの場合は1を返す
    public int setUserJoho(String _id, String _name){
        if(existsOfUserID(_id))
            return 1;

        User stu = new User();
        stu.userID = _id;
        stu.name = _name;
        UserList.add(stu);
        return 0;
    }



};