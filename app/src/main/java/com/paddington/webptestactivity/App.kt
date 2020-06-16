package com.paddington.webptestactivity

import android.app.Application
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import me.jessyan.autosize.AutoSizeConfig
import okhttp3.Call
import okhttp3.OkHttpClient
import org.apache.http.conn.ssl.X509HostnameVerifier
import java.io.InputStream
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.SSLSocket
import javax.net.ssl.X509TrustManager

/**
 * <pre>
 *     author : paddington
 *     e-mail : paddington.699@gmail.com
 *     time   : 2020/06/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AutoSizeConfig.getInstance().designHeightInDp = 640
    }
}