package com.kotlinegitim.hw4_kotlin

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class NewContent {

    fun news () : List<New> {
        val arr = mutableListOf<New>()
        val url = "https://www.haberler.com/"
        val doc: Document = Jsoup.connect(url).timeout(15000).get()


        var elements :Elements = doc.getElementsByClass("slide")

        for ( item in elements) {


            val imageTag = item.getElementsByTag("img")

            val new_title = imageTag.attr("alt")
            val image_link = imageTag.attr("data-src")
            val url= item.attr("abs:href")




            if ( new_title != "" && url != "" && image_link != "" ) {

                val news = New(new_title, image_link, url)
                arr.add(news)
            }
        }
        return arr
    }
}