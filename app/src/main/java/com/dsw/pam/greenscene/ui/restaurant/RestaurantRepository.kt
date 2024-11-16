package com.dsw.pam.greenscene.ui.restaurant
import com.dsw.pam.greenscene.model.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RestaurantRepository {
    private val firestore = FirebaseFirestore.getInstance()
    private val restaurantsCollection = firestore.collection("restaurants")

    suspend fun getRestaurants(): List<Restaurant> {
        return try {
            val snapshot = restaurantsCollection.get().await()
            snapshot.documents.map { document ->
                document.toObject(Restaurant::class.java)!!.copy(id = document.id)
            }
        } catch (e: Exception) {
            emptyList()
        }
    }
}
