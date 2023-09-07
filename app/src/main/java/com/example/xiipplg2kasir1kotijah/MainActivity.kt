package com.example.xiipplg2kasir1kotijah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val namaPelanggan = findViewById<EditText>(R.id.editnamaPelanggan)
        val namaBarang = findViewById<EditText>(R.id.editnamaBarang)
        val jumlahbeli = findViewById<EditText>(R.id.editJumlahbeli)
        val hargasatuan = findViewById<EditText>(R.id.editHarga)
        val uangbayar = findViewById<EditText>(R.id.editUangbayar)
        val btnProses = findViewById<TextView>(R.id.btnProses)

        val txtHargaTotal = findViewById<TextView>(R.id.txtHargaTotal)
        val txtUangKembali = findViewById<TextView>(R.id.txtUangKembali)
        val txtBonus = findViewById<TextView>(R.id.txtBonus)
        val txtKeterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var hargaBarang = Integer.parseInt(hargasatuan.text.toString())
            var jmlBarang = Integer.parseInt(jumlahbeli.text.toString())
            var hargaTotal = hargaBarang * jmlBarang
            var uangbayar = Integer.parseInt(uangbayar.text.toString())
            var Kembalian = uangbayar - hargaTotal

            txtHargaTotal.text = "Harga Total Rp. " + hargaTotal
            txtUangKembali.text = "Kembalian: " + if (Kembalian <= 0) "Tidak ada" else Kembalian

            if (hargaTotal >= 200000) {
                txtBonus.text = "Bonus Mouse"
            } else if (hargaTotal > 400000) {
                txtBonus.text = "Bonus Kyboard"
            } else if (hargaTotal >= 600000) {
                txtBonus.text = "Bonus Harddisk"
            } else {
                txtBonus.text = "Bonus: Tidak ada"
            }
            if (Kembalian == 0) {
                txtKeterangan.text = "Keterangan: Uang Pas"
            } else if (Kembalian > 0) {
                txtKeterangan.text = "Keterangan: Menunggu Kembalian"
            } else {
                txtKeterangan.text = "Keterangan: Uang Kurang" + abs(Kembalian)
            }
        }
        btnReset.setOnClickListener {
            namaPelanggan.setText("")
            namaBarang.setText("")
            jumlahbeli.setText("")
            hargasatuan.setText("")
            uangbayar.setText("")
            txtHargaTotal.text = "Harga Total"
            txtUangKembali.text = "Kembalian"
            txtBonus.text = "Bonus"
            txtKeterangan.text = "Keterangan"
        }
    }
}