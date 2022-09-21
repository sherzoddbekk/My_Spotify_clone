package com.example.myspotifyclone.fragment.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myspotifyclone.R
import com.example.myspotifyclone.adapters.CourseRVAdapter
import com.example.myspotifyclone.models.CourseRVModal
import java.util.Locale.filter

class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        setContentView(R.layout.fragment_search)
//
//        // initializing our variables.
//        courseRV = findViewById(R.id.idRVCourses)
//
//        // calling method to
//        // build recycler view.
//        buildRecyclerView()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView()
    }

    private fun searchView(){

        lateinit var courseRV: RecyclerView
        lateinit var courseRVAdapter: CourseRVAdapter
        lateinit var courseList: ArrayList<CourseRVModal>

        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)


            // on below line we are initializing our list
            courseList = ArrayList()

            // on below line we are initializing our adapter
            courseRVAdapter = CourseRVAdapter(courseList)

            // on below line we are setting adapter to our recycler view.
            courseRV.adapter = courseRVAdapter

            // on below line we are adding data to our list
            courseList.add(CourseRVModal("Android Development", R.drawable.icon_spotify))
            courseList.add(CourseRVModal("C++ Development", R.drawable.icon_spotify))
            courseList.add(CourseRVModal("Java Development", R.drawable.icon_spotify))
            courseList.add(CourseRVModal("Python Development", R.drawable.icon_spotify))
            courseList.add(CourseRVModal("JavaScript Development", R.drawable.icon_spotify))

            // on below line we are notifying adapter
            // that data has been updated.
            courseRVAdapter.notifyDataSetChanged()

        }

        // calling on create option menu
        // layout to inflate our menu file.
        fun onCreateOptionsMenu(menu: Menu): Boolean {
            // below line is to get our inflater
            val inflater = requireActivity().menuInflater

            // inside inflater we are inflating our menu file.
            inflater.inflate(R.menu.search_menu, menu)

            // below line is to get our menu item.
            val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

            // getting search view of our item.
            val searchView: SearchView = searchItem.getActionView() as SearchView

            // below line is to call set on query text listener method.
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    return false
                }

                override fun onQueryTextChange(msg: String): Boolean {
                    // inside on query text change method we are
                    // calling a method to filter our recycler view.
                    //filter(msg)
                    return false
                }
            })
            return true
        }

        fun filter(text: String) {
            // creating a new array list to filter our data.
            val filteredlist: ArrayList<CourseRVModal> = ArrayList()

            // running a for loop to compare elements.
            for (item in courseList) {
                // checking if the entered string matched with any item of our recycler view.
                if (item.courseName.toLowerCase().contains(text.toLowerCase())) {
                    // if the item is matched we are
                    // adding it to our filtered list.
                    filteredlist.add(item)
                }
            }
            if (filteredlist.isEmpty()) {
                // if no item is added in filtered list we are
                // displaying a toast message as no data found.
                Toast.makeText(context, "No Data Found..", Toast.LENGTH_SHORT).show()
            } else {
                // at last we are passing that filtered
                // list to our adapter class.
                courseRVAdapter.filterList(filteredlist)
            }
        }

    }

}