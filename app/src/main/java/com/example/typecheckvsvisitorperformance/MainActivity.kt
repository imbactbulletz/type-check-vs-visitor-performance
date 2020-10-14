package com.example.typecheckvsvisitorperformance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.typecheckvsvisitorperformance.model.*
import java.lang.NullPointerException
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSet = generateDataSet(FIVE_MILLION)

        var totalVisitorTimeTaken = 0L
        var totalTypeCheckTimeTaken = 0L

        for(x in 1..BENCHMARK_ITERATIONS) {
            totalVisitorTimeTaken += measureTimeMillis {
                determineTypesUsingVisitor(dataSet)
            }

            totalTypeCheckTimeTaken += measureTimeMillis {
                determineTypesUsingTypeCheck(dataSet)
            }
        }

        Log.i("Benchmark", "Benchmark results for $BENCHMARK_ITERATIONS iterations:")
        Log.i("Benchmark", "Average visitor time taken: ${totalVisitorTimeTaken / BENCHMARK_ITERATIONS}")
        Log.i("Benchmark", "Average type check time taken ${totalTypeCheckTimeTaken / BENCHMARK_ITERATIONS}")
    }

    private fun determineTypesUsingTypeCheck(dataSet: List<ChatItem>) {
        for (chatItem in dataSet) {
            val type = when (chatItem) {
                is TypeIndicator -> 1
                is Timestamp -> 2
                is TextChatMessage -> 3
                is VideoChatMessage -> 4
                is AudioChatMessage -> 5
                is ImageChatMessage -> 6
                is LinkChatMessage -> 7
            }
        }
    }

    private fun determineTypesUsingVisitor(dataSet: List<ChatItem>) {
        val chatItemTypeVisitor = ChatItemTypeVisitorImpl()

        for (chatItem in dataSet) {
            val type = chatItem.type(chatItemTypeVisitor)
        }

    }

    private fun generateDataSet(numberOfEntries: Int): List<ChatItem> {
        val dataSet = mutableListOf<ChatItem>()

        for(i in 1..numberOfEntries) {
            val entry = when(Random.nextInt(1,7)) {
                1 -> TypeIndicator(0)
                2 -> Timestamp(0)
                3 -> TextChatMessage(0,"")
                4 -> VideoChatMessage(0, "")
                5 -> AudioChatMessage(0, "")
                6 -> ImageChatMessage(0, "")
                7 -> LinkChatMessage(0,"")
                else -> throw NullPointerException("wtf")
            }

            dataSet.add(entry)
        }

        return dataSet
    }

    companion object {
        private const val FIVE_MILLION = 5000000
        private const val BENCHMARK_ITERATIONS = 1000
    }
}