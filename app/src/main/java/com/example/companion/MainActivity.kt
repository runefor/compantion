package com.example.companion

import android.content.res.AssetManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReader
import java.io.InputStreamReader
import java.lang.Exception
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var csvData: List<Array<String>>
        var csvTest : List<String>? = null
        fun csvRead1(assets : AssetManager): List<String>? {
            return try {
//                val parser = CSVParserBuilder().withSeparator(',').build()
                val assetManager : AssetManager = assets
                val inputStream = assetManager.open("revers.csv")
                val reader = CSVReader(InputStreamReader(inputStream))
                val allContent = reader.readAll()

                val resultCSV = ArrayList<String>()
                for(content in allContent){
//                    resultCSV.add(content.toList().toString())
//                    Log.i("add", content.toList().toString().split(", ").toString())
//                    val typeI = content.javaClass.toString().split(", ").toString()
//                    Log.i("add", typeI)
//                    Log.i("add", content.toList().toString().split(", ")[1].toString())
                    val li = content.toList().toString().split(", ")

                    resultCSV.add(li.toString())
                }

//            Log.i("read csv1", resultCSV.toString())

                // return
                resultCSV
            }catch (e: Exception){
                Log.e("csv_bug", e.toString())
                // return
                null
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputStream = assets.open("revers.csv")
        val reader = InputStreamReader(inputStream)
        val csvReader = CSVReader(reader)
        csvData = csvReader.readAll()
        reader.close()

        Log.i("read", csvData.toList().toString())

        val other = Other()
        other.log()

        val csv = csvRead1(this.assets)

        if (csv != null) {
            Log.i("read", csv.toList().toString())
        }

        csvTest = csvRead1(this.assets)
        val testIndexim = csvTest?.toList()?.get(0)
        Log.i("read me", testIndexim?.toList()?.get(3).toString())

        val other2 = Other2()
        other2.log()

    }
}