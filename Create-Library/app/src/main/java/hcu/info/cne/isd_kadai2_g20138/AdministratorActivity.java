package hcu.info.cne.isd_kadai2_g20138;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdministratorActivity extends AppCompatActivity {

    UserInfo userInfo = UserInfo.getInstance();
    BookInfo bookInfo = BookInfo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_sample2);

        TextView etViewall = findViewById(R.id.textViewall);
        etViewall.setText("ようこそ");

        // ID
        EditText etTextID = findViewById(R.id.editTextID);
        // 名前
        EditText etTextName = findViewById(R.id.editTextName);

        Button btAddhu = findViewById(R.id.buttonaddhuman);
        btAddhu.setText("利用者を登録する");
        btAddhu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 未入力の場合は，メッセージを出して，登録をしない
                if (etTextID.length() == 0 || etTextName.length() == 0) {
                    etViewall.setText("正確に入力してください");
                    return;
                }
                // 入力情報に基づいて学生を登録し，入力欄を空欄とする
                int msg = userInfo.setUserJoho(etTextID.getText().toString(),etTextName.getText().toString());
                if (msg == 0) {
                    etViewall.setText("登録しました");
                    etTextID.setText("");
                    etTextName.setText("");
                } else if (msg == 1) {
                    etViewall.setText("そのIDは登録されています");
                };
            }
        });

        Button btViewhu = findViewById(R.id.buttonviewhuman);
        btViewhu.setText("利用者一覧を表示する");
        btViewhu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                etViewall.setText(userInfo.getUserInfo());
            }
        });

        Button btAddbo = findViewById(R.id.buttonaddbook);
        btAddbo.setText("図書を登録する");
        btAddbo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 未入力の場合は，メッセージを出して，登録をしない
                if (etTextID.length() == 0 || etTextName.length() == 0) {
                    etViewall.setText("正確に入力してください");
                    return;
                }
                // 入力情報に基づいて学生を登録し，入力欄を空欄とする
                int msg = bookInfo.setBookJoho(etTextID.getText().toString(),etTextName.getText().toString());
                if (msg == 0) {
                    etViewall.setText("登録しました");
                    etTextID.setText("");
                    etTextName.setText("");
                } else if (msg == 1) {
                    etViewall.setText("そのIDは登録されています");
                };
            }
        });


        Button btViewbo = findViewById(R.id.buttonviewbook);
        btViewbo.setText("図書の貸出記録を一覧表示する");
        btViewbo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                etViewall.setText(bookInfo.getBookInfo());
            }
        });

        // 初期画面に戻る
        Button btBack = findViewById(R.id.button2);
        btBack.setText("ログアウト");
        btBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });
    }
}