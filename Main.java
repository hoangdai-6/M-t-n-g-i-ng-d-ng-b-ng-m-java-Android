import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openApp("com.example.myapp"); // Thay "com.example.myapp" bằng tên gói của ứng dụng mà bạn muốn mở
    }

    private void openApp(String packageName) {
        try {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntent != null) {
                startActivity(launchIntent);
            } else {
                // Nếu không tìm thấy ứng dụng, mở Google Play Store để tìm kiếm ứng dụng
                Intent playStoreIntent = new Intent(Intent.ACTION_VIEW);
                playStoreIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
                startActivity(playStoreIntent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
