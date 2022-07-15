package com.yico.automation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yico.automation.auto.DailyRoutineService
import com.yico.automation.databinding.ActivityMainBinding
import com.yico.automation.utils.PermissionUtils
import com.yico.automation.utils.PhoneUtils

class MainActivity : AppCompatActivity() {


    private var check = false
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initView()
    }

    private fun initView() {
        if (!PermissionUtils.isAccessibilityEnabled(this, DailyRoutineService::class.java, true)) {
            PermissionUtils.gotoAccessibilitySetting(this, DailyRoutineService::class.java)
            checkAccessibility()
        }

        binding.tvAccessibilityStatus.setOnClickListener {
            PermissionUtils.gotoAccessibilitySetting(this, DailyRoutineService::class.java)
            checkAccessibility()
        }

        binding.tvPolicyAccessStatus.setOnClickListener {
            PermissionUtils.gotoPolicyAccessSetting(this)
        }

        binding.tvStop.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "stop")
            this.startService(intent)
        }

        binding.tvDo.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            this.startService(intent)
        }
        binding.tv1.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "1")
            this.startService(intent)
        }
        binding.tv2.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "2")
            this.startService(intent)
        }
        binding.tv3.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "3")
            this.startService(intent)
        }
        binding.tv5.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "5")
            this.startService(intent)
        }
        binding.tv6.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "6")
            this.startService(intent)
        }
        binding.tv7.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "7")
            this.startService(intent)
        }
        binding.tv8.setOnClickListener {
            if (!PermissionUtils.isPolicyAccessEnabled(this)) {
                PermissionUtils.gotoPolicyAccessSetting(this)
                return@setOnClickListener
            }
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "8")
            this.startService(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        if (PermissionUtils.isAccessibilityEnabled(this, DailyRoutineService::class.java, true)) {
            binding.tvAccessibilityStatus.text = "无障碍已授权"
        } else {
            binding.tvAccessibilityStatus.text = "无障碍未授权"
        }
        if (PermissionUtils.isPolicyAccessEnabled(this)) {
            binding.tvPolicyAccessStatus.text = "音量已授权"
        } else {
            binding.tvPolicyAccessStatus.text = "音量未授权"
        }
    }

    private fun checkAccessibility() {
        check = true
        Thread {
            while (check) {
                if (PermissionUtils.isAccessibilityEnabled(this, DailyRoutineService::class.java, true)) {
                    val intent = Intent(this, MainActivity::class.java)
                    this.startActivity(intent)
                    check = false
                }
            }
        }.start()
    }
}