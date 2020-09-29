# DogBreedsList
Retrieving list of dog breeds and subbreeds from (https://dog.ceo/dog-api), displaying list of breeds and photos of dogs. Photos can be liked and thus saved in the list of favorites.

* Language: Kotlin
* Layout elements: ViewPager, BottomNavigationBar (with navigation graphs), RecyclerView (of CardViews), ConstraintLayout
* Architecture components: Room, LiveData, ViewModel, Lifecycle
* CleanArch MVVM with Repository + DataBinding
* Retrofit + OkHttp3 for constructing the REST API
* Moshi for JSON parsing
* Coroutines for asynchronous DB and network requests
* DI: Dagger + Hilt
* Glide for image uploading
