package com.example.android.architecture.blueprints.todoapp.data.source
import androidx.lifecycle.LiveData
import com.example.android.architecture.blueprints.todoapp.data.Result
import com.example.android.architecture.blueprints.todoapp.data.Task

//Creating fake test double for testing
//Fake test double has implementation but only to the extent of the testing
//Implmenting the TaskDataSource interface because we have to replace the current data sources
//and both implement TaskDataSource
class FakeDataSource (var tasks: MutableList<Task>? = mutableListOf()) : TasksDataSource {

    override suspend fun getTasks(): Result<List<Task>> {
        tasks?.let {
            return Result.Success(ArrayList(it))
        }
        return Result.Error(Exception("Tasks not found"))
    }


    override suspend fun deleteAllTasks() {
        tasks?.clear()
    }

    override suspend fun saveTask(task: Task) {
        tasks?.add(task)
    }
    override fun observeTasks(): LiveData<Result<List<Task>>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshTasks() {
        TODO("Not yet implemented")
    }

    override fun observeTask(taskId: String): LiveData<Result<Task>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTask(taskId: String): Result<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun completeTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun completeTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun activateTask(task: Task) {
        TODO("Not yet implemented")
    }

    override suspend fun activateTask(taskId: String) {
        TODO("Not yet implemented")
    }

    override suspend fun clearCompletedTasks() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(taskId: String) {
        TODO("Not yet implemented")
    }

}