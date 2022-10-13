package com.example.kotlin_hw1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edname: EditText
    private lateinit var tvtext: TextView
    private lateinit var tvname: TextView
    private lateinit var tvwinner: TextView
    private lateinit var tvmmora: TextView
    private lateinit var tvcmora: TextView
    private lateinit var btnscissor: RadioButton
    private lateinit var btnstone: RadioButton
    private lateinit var btnpaper: RadioButton
    private lateinit var btnmora: Button
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edname = findViewById(R.id.ed_name)
        tvtext = findViewById(R.id.tv_text)
        tvname = findViewById(R.id.tv_name)
        tvwinner = findViewById(R.id.tv_winner)
        tvmmora = findViewById(R.id.tv_mmora)
        tvcmora = findViewById(R.id.tv_cmora)
        btnscissor = findViewById(R.id.btn_scissor)
        btnstone = findViewById(R.id.btn_stone)
        btnpaper = findViewById(R.id.btn_paper)
        btnmora = findViewById(R.id.btn_mora)
        btnmora.setOnClickListener(View.OnClickListener {
            //判斷字串是否是空白來要求輸入姓名
            if (edname.length() < 1) tvtext.text = "請輸入玩家姓名" else {
                //顯示玩家姓名與我方出拳
                tvname.text = String.format(
                    "名字\n%s",
                    edname.text.toString()
                )
                if (btnscissor.isChecked) tvmmora.text = "我方出拳\n剪刀" else if (btnstone.isChecked) tvmmora.text =
                    "我方出拳\n石頭" else tvmmora.text = "我方出拳\n布"
                //Random()產生介於0~1間不含1的亂數，乘3產生0~2當作電腦的出拳
                val computer = (Math.random() * 3).toInt()
                when (computer) {
                    0 -> tvcmora.text = "電腦出拳\n剪刀"
                    1 -> tvcmora.text = "電腦出拳\n石頭"
                    else -> tvcmora.text = "電腦出拳\n布"
                }
                //用三個判斷式判斷並顯示猜拳結果
                if (btnscissor.isChecked && computer == 2 ||
                    btnstone.isChecked && computer == 0 ||
                    btnpaper.isChecked && computer == 1
                ) {
                    tvwinner.text = """
                                            勝利者
                                            ${edname.text}
                                            """.trimIndent()
                    tvtext.text = "恭喜你獲勝了!!!"
                } else if (btnscissor.isChecked && computer == 1 ||
                    btnstone.isChecked && computer == 2 ||
                    btnpaper.isChecked && computer == 0
                ) {
                    tvwinner.text = "勝利者\n電腦"
                    tvtext.text = "可惜，電腦獲勝了!"
                } else {
                    tvwinner.text = "勝利者\n平手"
                    tvtext.text = "平局，請在試一次"
                }
            }
        })
    }
}