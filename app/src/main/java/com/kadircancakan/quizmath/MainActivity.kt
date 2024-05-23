package com.kadircancakan.quizmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kadircancakan.quizmath.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.startButton.setOnClickListener{
            // Ana iş parçası hattından çıkarak arka planda işlem yapmak için CoroutineScope oluşturun
            CoroutineScope(Dispatchers.Main).launch {
                // Arka planda işlem yaparken UI'ı engelleme
                withContext(Dispatchers.IO) {
                    // Arka planda uzun süreli işlemleri burada gerçekleştirin, örneğin ağ istekleri veya veritabanı işlemleri
                    delay(1000) // Örnek olarak 1 saniye gecikme ekleyelim
                }

                // İşlem tamamlandıktan sonra UI'ı güncelleyin
                startActivity(Intent(this@MainActivity, QuestionsActivity::class.java))
                finish()
            }
        }
    }
}
