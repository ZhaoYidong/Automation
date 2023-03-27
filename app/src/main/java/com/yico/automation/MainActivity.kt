package com.yico.automation

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.yico.automation.auto.DailyRoutineService
import com.yico.automation.databinding.ActivityMainBinding
import com.yico.automation.utils.PermissionUtils
import com.yico.automation.utils.PhoneUtils
import com.yico.automation.utils.ScreenOffAdminReceiver


class MainActivity : AppCompatActivity() {


    private var check = false
    private lateinit var binding: ActivityMainBinding
    private lateinit var policyManager: DevicePolicyManager
    private lateinit var adminReceiver: ComponentName

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

        binding.tvWriteSettingStatus.setOnClickListener {
            PermissionUtils.gotoWriteSetting(this)
        }

        adminReceiver = ComponentName(this, ScreenOffAdminReceiver::class.java)
        policyManager = this.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val adminReceiverRequest =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                //判断超级管理员是否激活
                if (policyManager.isAdminActive(adminReceiver)) {
                    Toast.makeText(this, "设备已被激活", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "设备没有被激活", Toast.LENGTH_SHORT).show();
                }
            }
        adminReceiverRequest.launch(Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
            putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, adminReceiver)
            putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "开启后就可以使用锁屏功能了...")
        })

        if (!Settings.System.canWrite(this)) {
            val writeSettingRequest =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    Toast.makeText(this, "已获得修改设备配置权限", Toast.LENGTH_SHORT).show()
                }
            writeSettingRequest.launch(Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS).apply {
                data = Uri.parse("package:$packageName")
            })
        }

        if (PermissionUtils.isPolicyAccessEnabled(this)) {
            PhoneUtils.silentSwitchOn(this)
        }

        binding.tvStop.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "stop")
            this.startService(intent)
        }

        binding.tvDo.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            this.startService(intent)
        }
        binding.Article1.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "Article1")
            this.startService(intent)
        }
        binding.Article1.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "Article2")
            this.startService(intent)
        }
        binding.KuaiShou1.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "KuaiShou1")
            this.startService(intent)
        }
        binding.KuaiShou2.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "KuaiShou2")
            this.startService(intent)
        }
        binding.tv3.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "3")
            this.startService(intent)
        }
        binding.tv5.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "5")
            this.startService(intent)
        }
        binding.tv6.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "6")
            this.startService(intent)
        }
        binding.WatchVideo.setOnClickListener {
            val intent = Intent(this, DailyRoutineService::class.java)
            intent.putExtra("type", "WatchVideo")
            this.startService(intent)

            PhoneUtils.goHome(this)
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
        if (Settings.System.canWrite(this)) {
            binding.tvWriteSettingStatus.text = "亮度已授权"
        } else {
            binding.tvWriteSettingStatus.text = "亮度未授权"
        }
    }

    private fun checkAccessibility() {
        check = true
        Thread {
            while (check) {
                if (PermissionUtils.isAccessibilityEnabled(
                        this,
                        DailyRoutineService::class.java,
                        true
                    )
                ) {
                    val intent = Intent(this, MainActivity::class.java)
                    this.startActivity(intent)
                    check = false
                }
            }
        }.start()
    }

}