package hcu.info.cne.isd_kadai2_g20138;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    UserInfo userInfo = UserInfo.getInstance();
    BookInfo bookInfo = BookInfo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sample1);

        Intent i = this.getIntent();
        String userID = i.getStringExtra("userID");

        TextView etallView = findViewById(R.id.alltextView);
        etallView.setText("利用者番号"+userID+"さんようこそ");

        EditText etID = findViewById(R.id.editID);

        Button btSearch = findViewById(R.id.buttonsearch);
        btSearch.setText("図書を検索する");
        btSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                etallView.setText(bookInfo.getBookInfo());
            }
        });

        Button btBorrow = findViewById(R.id.buttonborrow);
        btBorrow.setText("図書を借りる");
        btBorrow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String ID = etID.getText().toString();
                // 未入力の場合は，メッセージを出して，登録をしない
                if (ID.length() == 0) {
                    etallView.setText("図書番号を入力してください");
                    return;
                }
                if(!bookInfo.exsist(ID)){
                    etallView.setText("その図書は存在しません");
                    return;
                }
                int msg = userInfo.Borrow(userID,ID);
                if (msg == 0) {
                    etallView.setText("貸出完了！");
                    etID.setText("");

                } else if (msg == -1) {
                    etallView.setText("貸出できませんでした");
                }
            }
        });

        Button btReturn = findViewById(R.id.buttonreturn);
        btReturn.setText("図書を返却する");
        btReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String ID = etID.getText().toString();
                // 未入力の場合は，メッセージを出して，登録をしない
                if (ID.length() == 0) {
                    etallView.setText("図書番号を入力してください");
                    return;
                }
                if(!bookInfo.exsist(ID)){
                    etallView.setText("その図書は存在しません");
                    return;
                }
                int msg = userInfo.ReturnBook(userID,ID);
                if (msg == 0) {
                    etallView.setText("返却完了！");
                    etID.setText("");

                } else if (msg == -1) {
                    etallView.setText("返却できませんでした");
                }
            }
        });

        Button btCheck = findViewById(R.id.buttoncheck);
        btCheck.setText("借りている図書の確認");
        btCheck.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                etallView.setText(userInfo.getUserBookInfo(userID));
            }
        });
        
        // 初期画面に戻る
        Button btBack = findViewById(R.id.button);
        btBack.setText("ログアウト");
        btBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}