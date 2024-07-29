import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class Main extends Activity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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





Trong đoạn mã trên, chúng ta định nghĩa một phương thức `openApp()` nhận vào tên gói (package name) của ứng dụng mà chúng ta muốn mở. Trong phương thức này, chúng ta sử dụng `getPackageManager().getLaunchIntentForPackage()` để lấy `Intent` để khởi chạy ứng dụng. Nếu ứng dụng được tìm thấy, chúng ta sẽ sử dụng `startActivity()` để mở ứng dụng. Nếu không tìm thấy ứng dụng, chúng ta sẽ mở Google Play Store để tìm kiếm ứng dụng.

Bạn chỉ cần thay `"com.example.myapp"` bằng tên gói của ứng dụng mà bạn muốn mở và tích hợp đoạn mã này vào ứng dụng Android của bạn.
