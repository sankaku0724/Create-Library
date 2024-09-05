package hcu.info.cne.isd_kadai2_g20138;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    UserInfo userInfo = UserInfo.getInstance();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 利用者画面へ遷移
        Button btRogin = findViewById(R.id.btrogin);
        btRogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                //
                btRogin.setText("利用者ログイン");
                EditText etrogin = findViewById(R.id.edrogin); String id = etrogin.getText().toString();
                TextView etsign = findViewById(R.id.textView2);

                // 未入力の場合は，メッセージを出して，登録をしない
                if (etrogin.getText().length() == 0) {
                    etsign.setText("利用者番号を入力してください");
                    return;
                }

                // 入力情報に基づいてログインし，入力欄を空欄とする
                int msg = userInfo.login(etrogin.getText().toString());
                if (msg == 0) {
                    etsign.setText("");
                    Intent i = new Intent(MainActivity.this, UserActivity.class);
                    i.putExtra("userID", id);
                    startActivity(i);
                    etrogin.setText("");
                } else if (msg == -1) {
                    etsign.setText("正しい利用者番号を入力してください");
                    etrogin.setText("");
                }
            }
        });
        // 管理者画面へ遷移
        Button btMaster = findViewById(R.id.btmaster);
        btMaster.setText("管理者");
        btMaster.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AdministratorActivity.class);
                startActivity(i);
            }
        });
    }
}