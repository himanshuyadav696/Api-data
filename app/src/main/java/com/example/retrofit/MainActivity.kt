package com.example.retrofit
import android.os.Bundle
import android.util.Log.d
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

const val BASE_URl ="https://my-json-server.typicode.com/easygautam/data/"
class MainActivity : AppCompatActivity() {
    lateinit var MyAdapter:MyAdapter
    lateinit var toolbar:Toolbar
    lateinit var LinearLayoutManager:LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar =findViewById(R.id.tooldbar)
        toolbar.setNavigationOnClickListener{
            finishAffinity()
        }
        recyclerview_users.setHasFixedSize(true)
        LinearLayoutManager= LinearLayoutManager(this)
        recyclerview_users.layoutManager=LinearLayoutManager
        getMyData()
    }
    private fun getMyData() {
        val retrofitBuilder= Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URl)
            .build()
            .create(Apiinterface::class.java)

        val retrofitData =retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyData.MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyData.MyDataItem>?>,
                response: Response<List<MyData.MyDataItem>?>,
            ) {
                val responseBody = response.body()!!
                responseBody
                MyAdapter = MyAdapter(baseContext,responseBody)
                MyAdapter.notifyDataSetChanged()
                recyclerview_users.adapter=MyAdapter
            }
            override fun onFailure(call: Call<List<MyData.MyDataItem>?>, t: Throwable) {
                d("mainActivity","on failure"+t.message)
            }
        })
    }
}

