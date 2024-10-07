package com.example.oopsimle

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),OnClickListener,OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txv: TextView=findViewById(R.id.txv)
        txv.text="OOP example"
        var v1 =Two()
        v1.x = 7
        v1.y = 5

        var v2=Two()
        v2.x= 55
        v2.y= 7

        var v3 =Three(55,6,21)
        txv.text=v3.Sum().toString()+"\n"+ v3.Avg().toString()

        var img:ImageView=findViewById(R.id.img)
        img .setOnClickListener(this)
        img.setOnLongClickListener(this)
        txv .setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        var txv:TextView=findViewById(R.id.txv)
        var img:ImageView=findViewById(R.id.img)
        if(v == txv) {
            txv.text = "我是可愛的喵喵醬"
        }else{
            txv.text = "喵"
        }
    }

    override fun onLongClick(v: View?): Boolean {
        var txv:TextView=findViewById(R.id.txv)
        txv.text="哈摟"
        return false
    }
}

interface  Average{
    fun Avg():Float
}
 open class Two(var x:Int=0,var y:Int=0){
    open fun Sum():Int{
         return  x+y
     }
 }
class Three(x:Int,y:Int,var z:Int): Two(x,y),Average{
    override fun Sum():Int {
        return x + y + z
    }
    override fun Avg():Float{
            return (x+y+z).toFloat()/3
        }


}