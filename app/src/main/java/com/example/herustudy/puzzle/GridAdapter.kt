package com.example.herustudy.puzzle

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.example.herustudy.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.puzzle_item.view.*

/** 2021-02-28 0:07 Created by: Heru Apr */
class GridAdapter(var context: Context) :
    BaseAdapter() {
    private var list = images()
    private var currentBlank = 0
    var yAxis = 0
    var xAxis = 1
    var ordo = 3
    var rowCounter = 0
    var rightEdges = mutableListOf<Int>()
    var leftEdges = mutableListOf<Int>()
    var counter = 0

    fun addItems(item: List<Model>) {
        //soon to be add body
    }

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Inflate the custom view
        val inflater =
            parent?.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.puzzle_item, null)

        val puzzleIV = view.puzzleImageView

//        Glide.with(view)
//            .load(Uri.parse(list[position].uri))
//            .into(puzzleIV)
        Glide.with(view)
            .load("file:///android_asset/" + list[position].uri)
            .into(puzzleIV)
//        tv.text = list[position].id.toString()

        puzzleIV.setOnClickListener {
            Log.d(
                "clicked: ",
                list[position].id.toString() + " current blank: " + this.currentBlank.toString()
            )

            //loop setup edges of matrix
            for (i in 0 until ordo) {
                this.leftEdges.add(counter)
                this.rightEdges.add((list.size - 1) - counter)
                counter += ordo
            }
            val isBackwardAvailable: Boolean
            val isForwardAvailable: Boolean

            //check the availability of forward and backward move
            when {
                rightEdges.contains(position) -> {
                    isForwardAvailable = false
                    isBackwardAvailable = true
                }
                leftEdges.contains(position) -> {
                    isForwardAvailable = true
                    isBackwardAvailable = false
                }
                else -> {
                    isForwardAvailable = true
                    isBackwardAvailable = true
                }
            }

            if (position - ordo == currentBlank || position + ordo == currentBlank) {
                val temp = list[currentBlank]
                list[currentBlank] = list[position]
                list[position] = temp
                this.currentBlank = position
                notifyDataSetChanged()
            } else if (position + 1 == currentBlank && isForwardAvailable) {
                val temp = list[currentBlank]
                list[currentBlank] = list[position]
                list[position] = temp
                this.currentBlank = position
                notifyDataSetChanged()
            } else if (position - 1 == currentBlank && isBackwardAvailable) {
                val temp = list[currentBlank]
                list[currentBlank] = list[position]
                list[position] = temp
                this.currentBlank = position
                notifyDataSetChanged()

            } else {
                Log.d("clicked: ", "Not a Valid Move")
            }

            for (i in 0 until list.size) {
                if (i != list[i].id) {
                    break
                } else {
                    //game done
                    if (i == list.size - 1) {
                        val snackbar = Snackbar.make(view, "WELL DONE!", Snackbar.LENGTH_SHORT)
                        snackbar.animationMode
                        val vieww = snackbar.view
                        val params = vieww.layoutParams as FrameLayout.LayoutParams
                        params.gravity = Gravity.CENTER
                        vieww.layoutParams = params
                        snackbar.show()
                    }
                }
            }

        }

        return view
    }

    override fun getItem(position: Int): Any? {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }


    // Custom method to generate list data
    private fun images(): MutableList<Model> {
        var lists = mutableListOf(
            //perfect assembly
//            Model(
//                0,
//                "7.png"
//            ),
//            Model(
//                1,
//                "8.png"
//            ),
//            Model(
//                2,
//                "9.png"
//            ),
//            Model(
//                3,
//                "4.png"
//            ),
//            Model(
//                4,
//                "5.png"
//            ),
//            Model(
//                5,
//                "6.png"
//            ),
//            Model(
//                6,
//                "1.png"
//            ),
//            Model(
//                7,
//                "2.png"
//            ),
//            Model(
//                8,
//                ""
//            )

            //a bit scrambled
            Model(
                0,
                "7.png"
            ),
            Model(
                1,
                "8.png"
            ),
            Model(
                2,
                "9.png"
            ),
            Model(
                3,
                "4.png"
            ),
            Model(
                4,
                "5.png"
            ),
            Model(
                5,
                "6.png"
            ),
            Model(
                8,
                ""
            ),
            Model(
                6,
                "1.png"
            ),
            Model(
                7,
                "2.png"
            )
//            Model(
//                0,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                1,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                2,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                3,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                4,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                5,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                6,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                7,
//                "https://resources.stuff.co.nz/content/dam/images/1/l/c/d/6/b/image.related.StuffLandscapeSixteenByNine.710x400.1l8vmb.png/1504056226696.jpg"
//            ),
//            Model(
//                8,
//                ""
//            )
        )
        for (i in lists.indices) {
            //setup current blank space
            if (lists[i].uri == "") {
                this.currentBlank = i
            }
        }

        return lists
    }
}