package com.example.spanneblestringbuilder

import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.QuoteSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.spanneblestringbuilder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val spannable = SpannableStringBuilder("Текст разносторонний!")
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            /* начальный индекс */ 8,
            /* конечный индекс */ 12,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        spannable.setSpan(
            StyleSpan(BOLD),
            8,
            spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            RelativeSizeSpan(2f),
            0, 4,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannable.setSpan(
            QuoteSpan(Color.GREEN),
            8, spannable.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )


        //spannable.insert(12, "(и фон)")

        // устанавливаем текст как Spannable
        binding.textView.setText(spannable, TextView.BufferType.SPANNABLE)
        // позднее получение экземпляра текстового объекта
        // из TextView
        // его можно привести к Spannable только потому, что мы установили его как
        // BufferType.SPANNABLE перед
        val spannableText = binding.textView.text as Spannable
    }
}