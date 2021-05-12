package com.example.vetapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vetapp.R
import com.example.vetapp.databinding.AnswerRecyclerBinding
import com.example.vetapp.databinding.RecyclerItemBinding
import com.example.vetapp.model.Answer
import com.example.vetapp.model.AnswerRemove
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.answer_recycler.view.*
import kotlinx.android.synthetic.main.fragment_answer.view.*
import kotlinx.coroutines.newFixedThreadPoolContext

class AnswerAdapter(var answerList: ArrayList<Answer>) :
    RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {
    class AnswerViewHolder(var itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.answer_recycler,
            parent,
            false
        )
        return AnswerViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.itemView.questionText.text = answerList[position].soru
        holder.itemView.answerText.text = answerList[position].cevap
        holder.itemView.removeBtn.setOnClickListener {
            delete(answerList[position].cevapId.toString(), answerList[position].soruId.toString());
        }


    }

    override fun getItemCount(): Int {
        return answerList.size
    }

    fun update(newList: List<Answer>) {
        answerList.clear()
        answerList.addAll(newList)
        notifyDataSetChanged()
    }

    private fun delete(cevapid: String, soruid: String) {

        VetAPI.getService().getRemoveAnswer(cevapid, soruid)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<AnswerRemove> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ServiceOnSubscribed", "ServiceOnSubscribed")
                }

                override fun onNext(t: AnswerRemove) {


                }

                override fun onError(e: Throwable) {
                    Log.d("ServiceOnError", "ServiceOnError" + e.message)
                }

                override fun onComplete() {
                    Log.d("ServiceOnComplete", "ServiceOnComplete")
                }

            })


    }
}