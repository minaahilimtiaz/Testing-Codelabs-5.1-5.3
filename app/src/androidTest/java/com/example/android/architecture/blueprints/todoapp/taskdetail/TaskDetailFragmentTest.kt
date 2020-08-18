package com.example.android.architecture.blueprints.todoapp.taskdetail

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.android.architecture.blueprints.todoapp.R
import com.example.android.architecture.blueprints.todoapp.data.source.FakeAndroidTestRepository
import com.example.android.architecture.blueprints.todoapp.data.Task
import com.example.android.architecture.blueprints.todoapp.data.source.ServiceLocator
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

//Should be run as a part of medium test here unit tests
//kotlinx-coroutines-test is still experimental and the API might change
@MediumTest
@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class TaskDetailFragmentTest {

    private lateinit var repository: TasksRepository

    @Before
    fun initRepository() {
        repository = FakeAndroidTestRepository()
        ServiceLocator.tasksRepository = repository
    }

    @After
    fun cleanupDb() = runBlockingTest {
        ServiceLocator.resetRepository()
    }

    //runBlockingTest runs coroutines in synchronized, deterministic manner & avoid delay() calls
    @Test
    fun activeTaskDetails_DisplayedInUi()  = runBlockingTest{

        val activeTask = Task("Active Task", "AndroidX Rocks", false)
        repository.saveTask(activeTask)
        val bundle = TaskDetailFragmentArgs(activeTask.id).toBundle()
        //launch fragment in activity's view
        launchFragmentInContainer<TaskDetailFragment>(bundle, R.style.AppTheme)

    }

}