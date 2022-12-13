package com.example.basicsandroid

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import androidx.test.runner.screenshot.ScreenCaptureProcessor
import androidx.test.runner.screenshot.Screenshot
import androidx.test.uiautomator.*
import com.google.firebase.testlab.screenshot.FirebaseScreenCaptureProcessor
import org.hamcrest.*
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.*


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class UiAutomatorTest {
    private var device: UiDevice? = null

    companion object {
        private const val BASIC_SAMPLE_PACKAGE = "com.example.basicsandroid"
        private const val LAUNCH_TIMEOUT = 25000
    }

    @Before
    fun startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device?.pressHome()
        // Wait for launcher
        val launcherPackage = device?.launcherPackageName

        MatcherAssert.assertThat(launcherPackage, Matchers.notNullValue())
        device?.wait(
            Until.hasObject(By.pkg(launcherPackage).depth(0)),
            LAUNCH_TIMEOUT.toLong()
        )

        // Launch the app
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager
            .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE)

        // Clear out any previous instances
        intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // Wait for the app to appear
        device?.wait(
            Until.hasObject(
                By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)
            ),
            LAUNCH_TIMEOUT.toLong()
        )

    }

    @Test
    fun renderLoginPage() {
        val placeholderUsername = "Login";
        val placeholderPassword = "Password";
        val textLogin = "ENTRAR"
        val titleHome = "Home";

        val usernameInput = device!!.findObject(UiSelector().text(placeholderUsername));
        val passwordInput = device!!.findObject(UiSelector().text(placeholderPassword));
        val loginButton = device!!.findObject(UiSelector().text(textLogin));

        assertEquals("Should be get a username input", usernameInput.text, placeholderUsername)
        assertEquals("Should be get a Password Input", passwordInput.text, placeholderPassword)

        usernameInput.text = "Michel"
        passwordInput.text = "********"

        assertEquals("Should get a login button ", loginButton.text, textLogin);

        loginButton.clickAndWaitForNewWindow(10000)

        val loginTextField = device!!.findObject(UiSelector().text(titleHome));
        assertEquals("Should have a text with $titleHome", loginTextField.text, titleHome);

        val processors: MutableSet<ScreenCaptureProcessor> = HashSet()
        processors.add(FirebaseScreenCaptureProcessor())

        Screenshot.capture().setName("LoginTestScreenshot").setFormat(Bitmap.CompressFormat.JPEG)
            .process();
    }


}